package co.com.sofka.easy_fly.domain.flight;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.easy_fly.domain.flight.values.Model;
import co.com.sofka.easy_fly.domain.flight.values.FlightStatus;
import co.com.sofka.easy_fly.domain.flight.values.PlaneId;

import java.util.Objects;

public class Plane extends Entity<PlaneId> {
    protected Model model;

    protected Plane(PlaneId entityId, Model model) {
        super(entityId);
        this.model = Objects.requireNonNull(model);
    }

    private Plane(PlaneId entityId){ super(entityId);}

    public static Plane from(PlaneId entityId, Model model){
        var plane = new Plane(entityId);
        plane.model=model;
        return plane;
    }

    public Model Model() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;
        if (!super.equals(o)) return false;
        Plane plane = (Plane) o;
        return Objects.equals(model, plane.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), model);
    }
}
