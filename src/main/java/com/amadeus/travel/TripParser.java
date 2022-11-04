package com.amadeus.travel;

import com.amadeus.Amadeus;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Resource;
import com.amadeus.resources.TripDetail;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

/**
 * <p>
 * A namespaced client for the
 * <code>/v3/travel/trip-parser</code> endpoints.
 * </p>
 *
 * <p>
 * Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder(API_KEY, API_SECRET).build();
 * amadeus.travel.tripParser;</pre>
 */
public class TripParser {
  private Amadeus client;

  /**
   * Constructor.
   *
   * @hide
   */
  public TripParser(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   * The Trip Parser API parses the content of a document to extract trip information.
   * Documents can be of type: PDF, XML, JSON, JPG, EML etc.
   * </p>
   *
   * <pre>
   * amadeus.travel.tripParser.post(body);</pre>
   *
   * @param body the parameters to send to the API as a JSonObject
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public TripDetail post(JsonObject body) throws ResponseException {
    Response response = client.post("/v3/travel/trip-parser", body);
    return (TripDetail) Resource.fromObject(response, TripDetail.class);
  }

  /**
   * <p>
   * The Trip Parser API parses the content of a document to extract trip information.
   * Documents can be of type: PDF, XML, JSON, JPG, EML etc.
   * </p>
   *
   * <pre>
   * amadeus.travel.tripParser.post(body);</pre>
   *
   * @param body the parameters to send to the API as a String
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public TripDetail post(String body) throws ResponseException {
    Response response = client.post("/v3/travel/trip-parser", body);
    return (TripDetail) Resource.fromObject(response, TripDetail.class);
  }

  /**
   * <p>
   * The Trip Parser API parses the content of a document to extract trip information.
   * Documents can be of type: PDF, XML, JSON, JPG, EML etc.
   * </p>
   *
   * <pre>
   * amadeus.travel.tripParser.post(file);</pre>
   *
   * @param file the file to send to the API as a File
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public TripDetail post(File file) throws ResponseException, IOException {
    // Base64 encode file and create request body
    try (FileInputStream fileInputStreamReader = new FileInputStream(file)) {
      byte[] bytes = new byte[(int)file.length()];
      int count = 0;
      if (fileInputStreamReader.read(bytes) > 0) {
        String encodedFile;
        encodedFile = Base64.getEncoder().encodeToString(bytes);
        JsonObject body = new JsonObject();
        body.addProperty("payload", encodedFile);
        count = count + fileInputStreamReader.read(bytes);

        Response response = client.post("/v3/travel/trip-parser", body);
        return (TripDetail) Resource.fromObject(response, TripDetail.class);
      }
    }
    return null;
  }

  /**
   * Convenience method for calling <code>post</code> without any parameters.
   *
   * @see TripParser#post()
   */
  public TripDetail post() throws ResponseException {
    return post((String) null);
  }
}
