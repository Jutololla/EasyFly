package co.com.sofka.easy_fly.domain.flight.event;

import co.com.sofka.domain.generic.DomainEvent;

public class FlightCreated extends DomainEvent {

    public FlightCreated(){
        super("sofka.easy_fly.flight.flightcreated");
    }
}
