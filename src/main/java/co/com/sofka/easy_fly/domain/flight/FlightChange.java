package co.com.sofka.easy_fly.domain.flight;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.easy_fly.domain.flight.event.FlightCreated;

public class FlightChange extends EventChange {

    public FlightChange(Flight flight){

        apply((FlightCreated event)->{});

    }
}
