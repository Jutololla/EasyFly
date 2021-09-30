package co.com.sofka.easy_fly.domain.flight.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.easy_fly.domain.flight.values.FlightStatus;

public class FlightCreated extends DomainEvent {
    private final FlightStatus flightStatus;

    public FlightCreated(FlightStatus flightStatus){
        super("sofka.easy_fly.flight.flightcreated");
        this.flightStatus=flightStatus;
    }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }
}
