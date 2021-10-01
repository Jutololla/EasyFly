package co.com.sofka.easy_fly.domain.reservation.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.easy_fly.domain.flight.values.PlaneId;

public class ReservationId  extends Identity {
    public ReservationId(String uuid) {
        super(uuid);
    }

    public ReservationId() {
        super();
    }

    public static ReservationId of(String id) {
        return new ReservationId(id);
    }
}
