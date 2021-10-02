package co.com.sofka.easy_fly.domain.flight.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.easy_fly.domain.flight.Flight;
import co.com.sofka.easy_fly.domain.flight.values.FlightId;
import co.com.sofka.easy_fly.domain.flight.values.FlightStatus;

public class FlightStatusChangedDueToScheduleChanged extends DomainEvent {
    private final FlightId flightId;
    private final FlightStatus flightStatus;

    public FlightStatusChangedDueToScheduleChanged(FlightId flightId, FlightStatus flightStatus) {
        super("sofka.easy_fly.flight.flightstatuschangedduetoschedulechanged");
        this.flightId = flightId;
        this.flightStatus = FlightStatus.of("Changed");
    }

    public FlightId getFlightId() {
        return flightId;
    }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }
}
