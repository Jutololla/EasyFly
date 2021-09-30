package co.com.sofka.easy_fly.domain.flight.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.easy_fly.domain.flight.values.FlightId;
import co.com.sofka.easy_fly.domain.flight.values.FlightStatus;

public class CreateFlight extends Command {
    private final FlightId entityId;
    private final FlightStatus flightStatus;

    public CreateFlight(FlightId entityId, FlightStatus flightStatus) {
        this.entityId = entityId;
        this.flightStatus = flightStatus;
    }

    public FlightId getEntityId() {
        return entityId;
    }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }
}
