package co.com.sofka.easy_fly.domain.flight;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.easy_fly.domain.flight.values.PilotId;
import co.com.sofka.easy_fly.domain.shared.Email;
import co.com.sofka.easy_fly.domain.shared.Name;

import java.util.Objects;

public class Pilot extends Entity<PilotId> {
    protected Name name;
    protected Email email;

    private Pilot(PilotId entityId) {
        super(entityId);
    }

    protected Pilot(PilotId entityId, Name name, Email email) {
        super(entityId);
        this.name = name;
        this.email = email;
    }
    public static Pilot from(PilotId entityId, Name name, Email email){
        var pilot = new Pilot(entityId);
        pilot.name=name;
        pilot.email=email;
        return pilot;
    }

    public Name Name() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Email Email() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pilot)) return false;
        if (!super.equals(o)) return false;
        Pilot pilot = (Pilot) o;
        return Objects.equals(name, pilot.name) && Objects.equals(email, pilot.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, email);
    }
}
