package com.amadeus.client;

import com.amadeus.Configuration;
import com.amadeus.Constants;
import com.amadeus.HTTPClient;
import com.amadeus.HttpVerbs;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;

/**
 * Utility class for authentication-related operations.
 */
public class AuthUtils {

  private AuthUtils() {
    // Prevent instantiation
  }

  public static Params createAuthRequestParams(Configuration config) {
    return Params.with(Constants.GRANT_TYPE, Constants.CLIENT_CREDENTIALS)
      .and(Constants.CLIENT_ID, config.getClientId())
      .and(Constants.CLIENT_SECRET, config.getClientSecret());
  }

  public static Response executeUnauthenticatedRequest(HTTPClient client, Params params)
    throws ResponseException {
    return client.unauthenticatedRequest(
      HttpVerbs.POST,
      Constants.AUTH_URL,
      params,
      null,
      null
    );
  }
}
