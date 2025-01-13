package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * An SeatMap object as returned by the SeatMap API.
 * @see com.amadeus.shopping.SeatMaps#get()
 * @see com.amadeus.shopping.SeatMaps#post() */
@ToString
public class SeatMap extends Resource {
  private @Getter String type;
  private @Getter String flightOfferid;
  private @Getter String segmentid;
  private @Getter String carrierCode;
  private @Getter String number;
  private @Getter Aircraft aircraft;
  private @Getter Departure departure;
  private @Getter Deck[] decks;
  private @Getter AircraftCabinAmenities aircraftCabinAmenities;
  private @Getter AvailableSeatsCounter[] availableSeatsCounters;

  protected SeatMap() {}

  @ToString
  public class Aircraft {
    private @Getter String code;

    protected Aircraft() {}
  }

  @ToString
  public class Departure {
    private @Getter String iataCode;
    private @Getter String at;

    protected Departure() {}
  }

  @ToString
  public class Arrival {
    private @Getter String iataCode;

    protected Arrival() {}
  }

  @ToString
  public class Deck {
    private @Getter String deckType;
    private @Getter DeckConfiguration deckConfiguration;
    private @Getter Facility[] facilities;
    private @Getter Seat[] seats;

    protected Deck() {}
  }

  @ToString
  public class Facility {
    private @Getter String code;
    private @Getter String column;
    private @Getter String row;
    private @Getter String position;
    private @Getter Coordinates coordinates;

    protected Facility() {}
  }

  @ToString
  public class Coordinates {
    private @Getter int coordX;
    private @Getter int coordY;

    protected Coordinates() {}
  }

  @ToString
  public class Seat {
    private @Getter String cabin;
    private @Getter String number;
    private @Getter String[] characteristicsCodes;
    private @Getter SeatmapTravelerPricing[] travelerPricings;
    private @Getter Coordinates coordinates;

    protected Seat() {}
  }

  @ToString
  public class SeatmapTravelerPricing {
    private @Getter String travelerId;
    private @Getter String seatAvailabilityStatus;
    private @Getter Price price;

    protected SeatmapTravelerPricing() {}
  }

  @ToString
  public class Price {
    private @Getter String currency;
    private @Getter String total;
    private @Getter String base;
    private @Getter Fee[] fees;
    private @Getter Tax[] taxes;

    protected Price() {}
  }

  @ToString
  public class Fee {
    private @Getter String amount;
    private @Getter String type;

    protected Fee() {}
  }

  @ToString
  public class Tax {
    private @Getter String amount;
    private @Getter String code;

    protected Tax() {}
  }

  @ToString
  public class AircraftCabinAmenities {
    private @Getter AmenityPower power;
    private @Getter AmenityWifi wifi;
    private @Getter AmenityBeverage beverage;
    private @Getter AmenityFood food;
    private @Getter AmenityEntertainment[] entertainment;
    private @Getter AmenitySeat seat;

    protected AircraftCabinAmenities() {}
  }

  @ToString
  public class AmenitySeat {
    private @Getter int legSpace;
    private @Getter String spaceUnit;
    private @Getter String tilt;
    private @Getter String amenityType;
    private @Getter Media[] medias;

    protected AmenitySeat() {}
  }

  @ToString
  public class AmenityPower {
    private @Getter boolean isChargeable;
    private @Getter String powerType;
    private @Getter String usbType;

    protected AmenityPower() {}
  }

  @ToString
  public class AmenityWifi {
    private @Getter boolean isChargeable;
    private @Getter String wifiCoverage;

    protected AmenityWifi() {}
  }

  @ToString
  public class AmenityBeverage {
    private @Getter boolean isChargeable;
    private @Getter String beverageType;

    protected AmenityBeverage() {}
  }

  @ToString
  public class AmenityFood {
    private @Getter boolean isChargeable;
    private @Getter String foodType;

    protected AmenityFood() {}
  }

  @ToString
  public class AmenityEntertainment {
    private @Getter boolean isChargeable;
    private @Getter String entertainmentType;

    protected AmenityEntertainment() {}
  }

  @ToString
  public class DeckConfiguration {

    private @Getter int width;
    private @Getter int length;
    private @Getter int startseatRow;
    private @Getter int endSeatRow;
    private @Getter int startWingsRow;
    private @Getter int endWingsRow;
    private @Getter int startWingsX;
    private @Getter int endWingsX;

    protected DeckConfiguration() {}
  }

  @ToString
  public class AvailableSeatsCounter {
    private @Getter int value;
    private @Getter String travelerId;

    protected AvailableSeatsCounter() {}
  }

  @ToString
  public class Media {
    private @Getter String title;
    private @Getter String href;
    private @Getter String mediaType;
    private @Getter QualifiedFreeText description;

    protected Media() {}
  }

  @ToString
  public class QualifiedFreeText {
    private @Getter String text;
    private @Getter String lang;

    protected QualifiedFreeText() {}
  }
}
