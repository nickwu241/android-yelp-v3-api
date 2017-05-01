package com.nwu.yelpapi.pojo;

import java.io.Serializable;

public class AccessToken implements Serializable {
   //---------------------------------------------------------------------------
   public final String access_token;
   public final String token_type;
   public final int expires_in;

   //---------------------------------------------------------------------------
   public AccessToken(String access_token, String token_type, int expires_in) {
      this.access_token = access_token;
      this.token_type = token_type;
      this.expires_in = expires_in;
   }

   //---------------------------------------------------------------------------
}
