package com.nwu.yelpapi.pojo;

import java.io.Serializable;

public class Review implements Serializable {
   //---------------------------------------------------------------------------
   public final String text;
   public final String url;
   public final String rating;
   public final String time_created;
   public final User user;

   //---------------------------------------------------------------------------
   public Review(String text, String url, String rating,
                 String time_created, User user) {
      this.text = text;
      this.url = url;
      this.rating = rating;
      this.time_created = time_created;
      this.user = user;
   }

   //---------------------------------------------------------------------------
   public class User implements Serializable {
      public final String name;
      public final String image_url;

      public User(String name, String image_url) {
         this.name = name;
         this.image_url = image_url;
      }
   }

   //---------------------------------------------------------------------------
}
