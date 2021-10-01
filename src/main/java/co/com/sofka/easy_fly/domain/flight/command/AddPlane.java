package co.com.sofka.easy_fly.domain.flight.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.easy_fly.domain.flight.values.FlightId;
import co.com.sofka.easy_fly.domain.flight.values.Model;
import co.com.sofka.easy_fly.domain.flight.values.PlaneId;

public class AddPlane extends Command {
    private final FlightId flightId;
    private final PlaneId planeId;
    private final Model model;

    public AddPlane(FlightId flightId, PlaneId planeId, Model model) {
        this.flightId = flightId;
        this.planeId = planeId;
        this.model = model;
    }

    public FlightId getFlightId() {
        return flightId;
    }

    public PlaneId getPlaneId() {
        return planeId;
    }

    public Model getModel() {
        return model;
    }
}
