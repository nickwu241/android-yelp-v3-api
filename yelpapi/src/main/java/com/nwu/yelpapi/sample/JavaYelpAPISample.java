package com.nwu.yelpapi.sample;

import com.google.gson.Gson;
import com.nwu.yelpapi.YelpV3API;
import com.nwu.yelpapi.YelpV3APIProvider;
import com.nwu.yelpapi.pojo.*;
import retrofit2.Call;

import java.io.IOException;
import java.util.HashMap;

public class JavaYelpAPISample {
   private static final String CLIENT_ID = null; // ENTER CLIENT_ID
   private static final String CLIENT_SECRET = null; // ENTER CLIENT_SECRET

   private static final String SAMPLE_LOCATION = "San Francisco, CA";
   private static final String SAMPLE_BUSINESS_ID = "anchor-oyster-bar-san-francisco";
   private static final String SAMPLE_PHONE_NUMBER = "+14159083801";
   private static final String SAMPLE_TRANSACTION_TYPE = "delivery";
   private static final String SAMPLE_AUTOCOMPLETE_TEXT = "del";

   public static void main(String... args) throws IOException {
      // Make sure to enter CLIENT_ID and CLIENT_SECRET
      assert (CLIENT_ID != null && CLIENT_SECRET != null);

      final YelpV3APIProvider factory = new YelpV3APIProvider(CLIENT_ID, CLIENT_SECRET);
      final AccessToken accessToken = factory.getAccessToken().execute().body();

      final YelpV3API yelp = factory.getAPI(accessToken.access_token);

      // Search API
      final HashMap<String, String> params = new HashMap<String, String>();
      params.put("location", SAMPLE_LOCATION);
      final Call<SearchResponse> searchCall = yelp.search(params);
      final SearchResponse searchResponse = searchCall.execute().body();

      // Phone Search API
      final Call<SearchResponse> phoneSearchCall = yelp.phoneSearch(SAMPLE_PHONE_NUMBER);
      final SearchResponse phoneSearchResponse = phoneSearchCall.execute().body();

      // Transaction Search API
      final Call<SearchResponse> transactionSearchCall =
            yelp.transactionSearch(SAMPLE_TRANSACTION_TYPE, params);
      final SearchResponse transactionSearchResponse = transactionSearchCall.execute().body();

      // Business API
      final Call<Business> businessCall = yelp.business(SAMPLE_BUSINESS_ID, null);
      final Business business = businessCall.execute().body();

      // Reviews API
      final Call<ReviewResponse> reviewsCall = yelp.reviews(SAMPLE_BUSINESS_ID, null);
      final ReviewResponse reviewResponse = reviewsCall.execute().body();

      // Autocomplete API
      final Call<AutocompleteResponse> autocompleteCall =
            yelp.autocomplete(SAMPLE_AUTOCOMPLETE_TEXT, null, null, null);
      final AutocompleteResponse autocompleteResponse = autocompleteCall.execute().body();

      // Output results from API calls
      final Gson gson = new Gson();
      System.out.println("--Search API--");
      System.out.println(gson.toJson(searchResponse));
      System.out.println("--Phone Search API--");
      System.out.println(gson.toJson(phoneSearchResponse));
      System.out.println("--Transaction Search API--");
      System.out.println(gson.toJson(transactionSearchResponse));
      System.out.println("--Business API--");
      System.out.println(gson.toJson(business));
      System.out.println("--Reviews API--");
      System.out.println(gson.toJson(reviewResponse));
      System.out.println("--Autocomplete API--");
      System.out.println(gson.toJson(autocompleteResponse));
   }

}
