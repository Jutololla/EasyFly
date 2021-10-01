package co.com.sofka.easy_fly.domain.flight;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.easy_fly.domain.flight.event.*;

public class FlightChange extends EventChange {

    public FlightChange(Flight flight) {

        apply((FlightCreated event) -> {
            flight.flightStatus = event.getFlightStatus();
        });

        apply((PilotAdded event) -> {
            flight.pilot = new Pilot(
                    event.getEntityId(),
                    event.getName(),
                    event.getEmail());
        });

        apply((ScheduleAdded event) -> {
            flight.schedule = new Schedule(
                    event.getScheduleId(),
                    event.getInRoomDateTime(),
                    event.getDepartureDateTime(),
                    event.getFlightDuration()
            );
        });

        apply((ScheduledChanged event) -> {
            flight.schedule.setInRoomDateTime(event.getInRoomDateTime());
            flight.schedule.setDepartureDateTime(event.getDepartureDateTime());
            flight.schedule.setFlightDuration(event.getFlightDuration());
        });

        apply((PlaneAdded event) -> {
            flight.plane = new Plane(
                    event.getPlaneId(),
                    event.getModel());
        });


    }
}

