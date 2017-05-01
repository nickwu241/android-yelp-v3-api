package com.nwu.yelpapi.pojo;

import java.io.Serializable;
import java.util.List;

public class Business implements Serializable {
   //---------------------------------------------------------------------------
   public final List<Category> categories;
   public final Coordinates coordinates;
   public final String display_phone;
   public final double distance; // Search API
   public final List<Hour> hours; // Business API
   public final String id;
   public final String image_url;
   public final Boolean is_claimed; // Business API
   public final boolean is_closed;
   public final Location location;
   public final String name;
   public final String phone;
   public final List<String> photos; // Business API
   public final String price;
   public final double rating;
   public final int review_count;
   public final List<String> transactions;
   public final String url;

   //---------------------------------------------------------------------------
   public Business(List<Category> categories, Coordinates coordinates,
                   String display_phone, List<Hour> hours,
                   double distance, String id,
                   String image_url, Boolean is_claimed,
                   boolean is_closed, Location location,
                   String name, String phone,
                   List<String> photos, String price,
                   double rating, int review_count,
                   List<String> transactions, String url) {
      this.categories = categories;
      this.coordinates = coordinates;
      this.display_phone = display_phone;
      this.hours = hours;
      this.distance = distance;
      this.id = id;
      this.image_url = image_url;
      this.is_claimed = is_claimed;
      this.is_closed = is_closed;
      this.location = location;
      this.name = name;
      this.phone = phone;
      this.photos = photos;
      this.price = price;
      this.rating = rating;
      this.review_count = review_count;
      this.transactions = transactions;
      this.url = url;
   }

   //---------------------------------------------------------------------------
   public class Coordinates implements Serializable {
      public final double latitude;
      public final double longitude;

      public Coordinates(double latitude, double longitude) {
         this.latitude = latitude;
         this.longitude = longitude;
      }
   }

   //---------------------------------------------------------------------------
   public class Hour implements Serializable {
      public class Open {
         public final int day;
         public final String start;
         public final String end;
         public final boolean is_overnight;

         public Open(int day, String start, String end, boolean is_overnight) {
            this.day = day;
            this.start = start;
            this.end = end;
            this.is_overnight = is_overnight;
         }
      }

      public final boolean is_open_now;
      public final String hours_type;
      public final List<Open> open;

      public Hour(boolean is_open_now, String hours_type, List<Open> open) {
         this.is_open_now = is_open_now;
         this.hours_type = hours_type;
         this.open = open;
      }
   }

   //---------------------------------------------------------------------------
   public class Location implements Serializable {
      public final String address1;
      public final String address2;
      public final String address3;
      public final String city;
      public final String country;
      public final List<String> display_address;
      public final String state;
      public final String zip_code;
      public final String cross_streets; // Business API

      public Location(String address1, String address2, String address3,
                      String city, String country, List<String> display_address,
                      String state, String zip_code, String cross_streets) {
         this.address1 = address1;
         this.address2 = address2;
         this.address3 = address3;
         this.city = city;
         this.country = country;
         this.display_address = display_address;
         this.state = state;
         this.zip_code = zip_code;
         this.cross_streets = cross_streets;
      }
   }

   //---------------------------------------------------------------------------
}
