package co.com.sofka.easy_fly.domain.flight.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.easy_fly.domain.flight.Flight;
import co.com.sofka.easy_fly.domain.flight.values.FlightId;
import co.com.sofka.easy_fly.domain.flight.values.FlightStatus;

public class FlightCreated extends DomainEvent {
    private final FlightId flightId;
    private final FlightStatus flightStatus;

    public FlightCreated(FlightStatus flightStatus){
        super("sofka.easy_fly.flight.flightcreated");
        this.flightStatus=flightStatus;
        this.flightId=new FlightId();
    }

    public FlightCreated(FlightId flightId, FlightStatus flightStatus){
        super("sofka.easy_fly.flight.flightcreated");
        this.flightStatus=flightStatus;
        this.flightId=flightId;
    }

    public FlightId getFlightId() {
        return flightId;
    }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }
}
