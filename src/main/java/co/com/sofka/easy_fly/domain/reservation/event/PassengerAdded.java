package co.com.sofka.easy_fly.domain.reservation.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.easy_fly.domain.reservation.values.PassengerId;
import co.com.sofka.easy_fly.domain.reservation.values.PhoneNumber;
import co.com.sofka.easy_fly.domain.shared.Email;
import co.com.sofka.easy_fly.domain.shared.Name;

public class PassengerAdded extends DomainEvent {
    private final PassengerId passengerId;
    private final Name name;
    private final PhoneNumber phoneNumber;
    private final Email email;

    public PassengerAdded(PassengerId passengerId, Name name, PhoneNumber phoneNumber, Email email) {
        super("sofka.easy_fly.reservation.passengeradded");
        this.passengerId = passengerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public PassengerId getPassengerId() {
        return passengerId;
    }

    public Name getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public Email getEmail() {
        return email;
    }
}
