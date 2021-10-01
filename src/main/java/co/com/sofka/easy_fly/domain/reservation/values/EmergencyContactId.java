package co.com.sofka.easy_fly.domain.reservation.values;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.Identity;
import co.com.sofka.easy_fly.domain.flight.values.PlaneId;

public class EmergencyContactId extends Identity {
    public EmergencyContactId(String entityId) {
        super(entityId);
    }

    public static PlaneId of(String id){
        return new PlaneId(id);
    }
}
