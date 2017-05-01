package com.nwu.yelpapi.pojo;

import java.io.Serializable;
import java.util.List;

public class SearchResponse implements Serializable {
   //---------------------------------------------------------------------------
   public final int total;
   public final List<Business> businesses;
   public final Region region; // Search API

   //---------------------------------------------------------------------------
   public SearchResponse(int total, List<Business> businesses, Region region) {
      this.total = total;
      this.businesses = businesses;
      this.region = region;
   }

   //---------------------------------------------------------------------------
   public class Region implements Serializable {
      public class Center implements Serializable {
         public final double latitude;
         public final double longitude;

         public Center(double latitude, double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
         }
      }

      public final Center center;

      public Region(Center center) {
         this.center = center;
      }
   }

   //---------------------------------------------------------------------------
}
