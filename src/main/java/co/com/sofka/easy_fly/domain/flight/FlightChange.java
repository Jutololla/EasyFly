package co.com.sofka.easy_fly.domain.flight;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.easy_fly.domain.flight.event.FlightCreated;
import co.com.sofka.easy_fly.domain.flight.event.ScheduleAdded;

public class FlightChange extends EventChange {

    public FlightChange(Flight flight) {

        apply((FlightCreated event) -> {
            flight.flightStatus = event.getFlightStatus();
        });

        apply((ScheduleAdded event) -> {
            flight.schedule = new Schedule(
                    event.getScheduleId(),
                    event.getInRoomDateTime(),
                    event.getDepartureDateTime(),
                    event.getFlightDuration()
            );
        });

    }
}

