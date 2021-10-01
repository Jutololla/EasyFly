package co.com.sofka.easy_fly.domain.flight.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.easy_fly.domain.flight.values.PilotId;
import co.com.sofka.easy_fly.domain.shared.Email;
import co.com.sofka.easy_fly.domain.shared.Name;

public class PilotAdded extends DomainEvent {
    private final PilotId entityId;
    private final Name name;
    private final Email email;

    public PilotAdded(PilotId entityId, Name name, Email email) {
        super("sofka.easy_fly.flight.pilotadded");
        this.entityId = entityId;
        this.name = name;
        this.email = email;
    }

    public PilotId getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }
}
