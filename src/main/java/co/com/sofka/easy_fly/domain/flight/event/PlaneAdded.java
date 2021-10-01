package co.com.sofka.easy_fly.domain.flight.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.easy_fly.domain.flight.values.Model;
import co.com.sofka.easy_fly.domain.flight.values.PlaneId;

public class PlaneAdded extends DomainEvent {
    private final PlaneId planeId;
    private final Model model;


    public PlaneAdded(PlaneId planeId, Model model) {
        super("sofka.easy_fly.flight.planeadded");
        this.planeId = planeId;
        this.model = model;
    }

    public PlaneId getPlaneId() {
        return planeId;
    }

    public Model getModel() {
        return model;
    }
}
