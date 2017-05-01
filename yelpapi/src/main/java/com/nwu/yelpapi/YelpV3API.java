package com.nwu.yelpapi;

import com.nwu.yelpapi.pojo.AutocompleteResponse;
import com.nwu.yelpapi.pojo.Business;
import com.nwu.yelpapi.pojo.ReviewResponse;
import com.nwu.yelpapi.pojo.SearchResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface YelpV3API {
   String SEARCH_PATH = "/v3/businesses/search";
   String PHONE_SEARCH_PATH = "/v3/businesses/search/phone";
   String TRANSACTION_SEARCH_PATH = "/v3/transactions/{transaction_type}/search";
   String BUSINESS_PATH = "/v3/businesses/{id}";
   String REVIEWS_PATH = "/v3/businesses/{id}/reviews";
   String AUTOCOMPLETE_PATH = "/v3/autocomplete";

   @GET(SEARCH_PATH)
   Call<SearchResponse> search(@QueryMap Map<String, String> parameters);

   @GET(PHONE_SEARCH_PATH)
   Call<SearchResponse> phoneSearch(@Query("phone") String phone);

   @GET(TRANSACTION_SEARCH_PATH)
   Call<SearchResponse> transactionSearch(
         @Path("transaction_type") String transaction_type,
         @QueryMap Map<String, String> parameters);

   @GET(BUSINESS_PATH)
   Call<Business> business(@Path("id") String id, @Query("locale") String locale);

   @GET(REVIEWS_PATH)
   Call<ReviewResponse> reviews(@Path("id") String id, @Query("locale") String locale);

   @GET(AUTOCOMPLETE_PATH)
   Call<AutocompleteResponse> autocomplete(
         @Query("text") String text,
         @Query("latitude") Double latitude,
         @Query("longitude") Double longitude,
         @Query("locale") String locale);
}
