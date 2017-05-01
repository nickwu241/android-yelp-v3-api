package com.nwu.yelpapi.pojo;

import java.io.Serializable;

public class Category implements Serializable {
   //---------------------------------------------------------------------------
   public final String alias;
   public final String title;

   //---------------------------------------------------------------------------
   public Category(String alias, String title) {
      this.alias = alias;
      this.title = title;
   }

   //---------------------------------------------------------------------------
}
