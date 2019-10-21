package com.amadeus.travel;

import com.amadeus.Amadeus;
import com.amadeus.travel.predictions.TripPurpose;

/**
 * <p>
 * A namespaced client for the
 * <code>/v1/travel/pridictions</code> endpoints.
 * </p>
 *
 * <p>
 * Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.travel.predictions;</pre>
 *
 * @hide
 */
public class Predictions {
  /**
   * <p>
   * A namespaced client for the
   * <code>/v1/travel/predictions/trip-purpose</code> endpoints.
   * </p>
   */
  public TripPurpose tripPurpose;

  /**
   * Constructor.
   *
   * @hide
   */
  public Predictions(Amadeus client) {
    this.tripPurpose = new TripPurpose(client);
  }
}
