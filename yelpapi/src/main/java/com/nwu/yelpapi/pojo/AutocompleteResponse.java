package com.nwu.yelpapi.pojo;

import java.io.Serializable;
import java.util.List;

public class AutocompleteResponse implements Serializable {
   //---------------------------------------------------------------------------
   public final List<Term> terms;
   public final List<Business> businesses;
   public final List<Category> categories;

   //---------------------------------------------------------------------------
   public AutocompleteResponse(List<Term> terms, List<Business> businesses,
                               List<Category> categories) {
      this.terms = terms;
      this.businesses = businesses;
      this.categories = categories;
   }

   //---------------------------------------------------------------------------
   public class Term implements Serializable {
      public final String text;

      public Term(String text) {
         this.text = text;
      }
   }

   //---------------------------------------------------------------------------
}
