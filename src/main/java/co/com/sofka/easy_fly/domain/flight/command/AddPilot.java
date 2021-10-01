package co.com.sofka.easy_fly.domain.flight.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.easy_fly.domain.flight.values.FlightId;
import co.com.sofka.easy_fly.domain.flight.values.PilotId;
import co.com.sofka.easy_fly.domain.shared.Email;
import co.com.sofka.easy_fly.domain.shared.Name;

public class AddPilot extends Command {
    private final FlightId flightId;
    private final PilotId entityId;
    private final Name name;
    private final Email email;

    public AddPilot(FlightId flightId, PilotId entityId, Name name, Email email) {
        this.flightId = flightId;
        this.entityId = entityId;
        this.name = name;
        this.email = email;
    }

    public FlightId getFlightId() {
        return flightId;
    }

    public PilotId getPilotId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }
}
