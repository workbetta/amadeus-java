package com.amadeus.client;

import com.amadeus.Configuration;
import com.amadeus.Constants;
import com.amadeus.HTTPClient;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.google.gson.JsonObject;
import lombok.Getter;

/**
 * Handles token-related functionality, including fetching and refreshing tokens.
 */
public class TokenManager {
  private static final long TOKEN_BUFFER = 10000L;
  private static final long MILLISECONDS_IN_SECOND = 1000L;

  private final HTTPClient client;
  @Getter
  private String tokenValue = null;
  private long expiresAt;

  public TokenManager(HTTPClient client) {
    this.client = client;
  }

  public void lazyUpdateAccessToken() throws ResponseException {
    if (isTokenExpiredOrNull()) {
      updateAccessToken();
    }
  }

  private boolean isTokenExpiredOrNull() {
    return isTokenNull() || isTokenExpired();
  }

  private boolean isTokenNull() {
    return tokenValue == null;
  }

  private boolean isTokenExpired() {
    return (System.currentTimeMillis() + TOKEN_BUFFER) > expiresAt;
  }

  private void updateAccessToken() throws ResponseException {
    Configuration config = client.getConfiguration();
    Params requestParams = AuthUtils.createAuthRequestParams(config);
    Response response = AuthUtils.executeUnauthenticatedRequest(client, requestParams);
    storeAccessTokenDetails(response.getResult());
  }

  private void storeAccessTokenDetails(JsonObject result) {
    this.tokenValue = result.get(Constants.ACCESS_TOKEN).getAsString();
    int expiresIn = result.get(Constants.EXPIRES_IN).getAsInt();
    this.expiresAt = calculateExpiryTime(expiresIn);
  }

  private long calculateExpiryTime(int expiresIn) {
    return System.currentTimeMillis() + expiresIn * MILLISECONDS_IN_SECOND;
  }
}
