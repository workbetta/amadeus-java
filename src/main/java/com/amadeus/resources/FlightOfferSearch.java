package com.amadeus.resources;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import lombok.Getter;
import lombok.ToString;


@ToString
public class FlightOfferSearch extends Resource {
  protected FlightOfferSearch() {}

  private @Getter String type;
  private @Getter String id;

  private @Getter boolean instantTicketingRequired;
  private @Getter boolean nonHomogeneous;
  private @Getter boolean oneWay;
  private @Getter Date lastTicketingDate;
  private @Getter int numberOfBookableSeats;
  private @Getter Itinerary[] itineraries;
  private @Getter SearchPrice price;
  private @Getter PricingOptions pricingOptions;


  @ToString
  public class Itinerary {
    protected Itinerary() {
    }

    private @Getter String duration;
    private @Getter SearchSegment[] segments;

  }

  @ToString
  public class SearchSegment {
    protected SearchSegment() {
    }

    private @Getter AirportInfo departure;
    private @Getter AirportInfo arrival;
    private @Getter String carrierCode;
    private @Getter String number;
    private @Getter Aircraft aircraft;
    private @Getter String duration;
    private @Getter String id;
    private @Getter int numberOfStops;
    private @Getter boolean blacklistedInEU;
  }

  @ToString
  public class AirportInfo {
    protected AirportInfo() {
    }

    private @Getter String iataCode;
    private @Getter String terminal;
    private @Getter String at;
  }

  @ToString
  public class Aircraft {
    protected Aircraft() {
    }

    private @Getter String code;
  }

  @ToString
  public class SearchPrice {
    protected SearchPrice() {
    }

    private @Getter String currency;
    private @Getter double total;
    private @Getter double base;
    private @Getter Fee[] fees;
    private @Getter double grandTotal;
  }

  @ToString
  public class Fee {
    protected Fee() {
    }

    private @Getter double amount;
    private @Getter String type;
  }

  @ToString
  public class PricingOptions {
    private @Getter boolean includedCheckedBagsOnly;
  }

  @ToString
  public class TravelerPricings {
    protected TravelerPricings() {
    }

    private @Getter String travelerId;
    private @Getter String fareOption;
    private @Getter String travelerType;
    private @Getter SearchPrice price;
  }

  @ToString
  public class FareDetailsBySegment {
    protected FareDetailsBySegment() {
    }

    private @Getter String segmentId;
    private @Getter String cabin;
    private @Getter String fareBasis;
    @SerializedName("class")
    private @Getter String segmentClass;
    private @Getter IncludedCheckedBags includedCheckedBags;

  }

  @ToString
  public class IncludedCheckedBags {
    protected IncludedCheckedBags() {
    }

    private @Getter double weight;
    private @Getter String weightUnit;
  }
}
