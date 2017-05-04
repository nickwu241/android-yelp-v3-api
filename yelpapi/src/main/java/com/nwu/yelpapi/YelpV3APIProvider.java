package com.nwu.yelpapi;

import com.nwu.yelpapi.pojo.AccessToken;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public class YelpV3APIProvider {
   //---------------------------------------------------------------------------
   private static final String API_HOST = "https://api.yelp.com";
   private static final String TOKEN_PATH = "/oauth2/token";
   private static final String GRANT_TYPE = "client_credentials";

   private final OkHttpClient httpClient;
   private final GsonConverterFactory gsonConverterFactory;
   private final YelpOAuth2 yelpAuth;
   private final String client_id;
   private final String client_secret;

   //---------------------------------------------------------------------------
   public YelpV3APIProvider(String client_id, String client_secret) {
      httpClient = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build();

      gsonConverterFactory = GsonConverterFactory.create();

      yelpAuth = new Retrofit.Builder()
            .baseUrl(API_HOST)
            .addConverterFactory(gsonConverterFactory)
            .client(httpClient)
            .build()
            .create(YelpOAuth2.class);

      this.client_id = client_id;
      this.client_secret = client_secret;
   }

   //---------------------------------------------------------------------------
   public Call<AccessToken> getAccessToken() {
      return yelpAuth.getToken(GRANT_TYPE, client_id, client_secret);
   }

   //---------------------------------------------------------------------------
   public YelpV3API getAPI(final String accessToken) {
      if (accessToken == null) {
         return null;
      }

      OkHttpClient client = httpClient.newBuilder().addInterceptor(new Interceptor() {
         public Response intercept(Chain chain) throws IOException {
            Request request = chain.request()
                  .newBuilder()
                  .header("Authorization", "Bearer " + accessToken)
                  .build();

            return chain.proceed(request);
         }
      }).build();

      return new Retrofit.Builder()
            .baseUrl(API_HOST)
            .addConverterFactory(gsonConverterFactory)
            .client(client)
            .build()
            .create(YelpV3API.class);
   }

   //---------------------------------------------------------------------------
   private interface YelpOAuth2 {
      @FormUrlEncoded
      @POST(TOKEN_PATH)
      Call<AccessToken> getToken(@Field("grant_type") String grant_type,
                                 @Field("client_id") String client_id,
                                 @Field("client_secret") String client_secret);
   }

   //---------------------------------------------------------------------------
}
