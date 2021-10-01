package co.com.sofka.easy_fly.domain.flight.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.easy_fly.domain.flight.values.FlightId;
import co.com.sofka.easy_fly.domain.flight.values.FlightStatus;

public class CreateFlight extends Command {
    private final FlightId flightId;
    private final FlightStatus flightStatus;

    public CreateFlight(FlightId flightId, FlightStatus flightStatus) {
        this.flightId = flightId;
        this.flightStatus = flightStatus;
    }

    public FlightId getFlightId() {
        return flightId;
    }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }
}
