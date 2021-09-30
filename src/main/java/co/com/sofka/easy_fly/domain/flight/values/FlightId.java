package co.com.sofka.easy_fly.domain.flight.values;

import co.com.sofka.domain.generic.Identity;

public class FlightId extends Identity {
    public FlightId(String id){
        super(id);
    }
    public FlightId(){}

    public static FlightId of(String id){
        return new FlightId(id);
    }

}
