package co.com.sofka.easy_fly.domain.reservation.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.easy_fly.domain.reservation.Passenger;

public class PassengerId extends Identity {
    public PassengerId(String uuid) {
        super(uuid);
    }

    public PassengerId() {
    }

    public static PassengerId of(String id) {
        return new PassengerId(id);
    }
}
