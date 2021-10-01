package co.com.sofka.easy_fly.domain.reservation;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.easy_fly.domain.reservation.values.PassengerId;
import co.com.sofka.easy_fly.domain.reservation.values.PhoneNumber;
import co.com.sofka.easy_fly.domain.shared.Email;
import co.com.sofka.easy_fly.domain.shared.Name;

import java.util.Objects;

public class Passenger extends Entity<PassengerId> {
    protected Name name;
    protected PhoneNumber phoneNumber;
    protected Email email;

    private Passenger(PassengerId entityId) {
        super(entityId);
    }

    protected Passenger(PassengerId entityId, Name name, PhoneNumber phoneNumber, Email email) {
        super(entityId);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public static Passenger from(PassengerId entityId, Name name, PhoneNumber phoneNumber, Email email) {
        var passenger = new Passenger(entityId);
        passenger.name = name;
        passenger.phoneNumber = phoneNumber;
        passenger.email = email;
        return passenger;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger)) return false;
        if (!super.equals(o)) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(getName(), passenger.getName()) && Objects.equals(getPhoneNumber(), passenger.getPhoneNumber()) && Objects.equals(getEmail(), passenger.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName(), getPhoneNumber(), getEmail());
    }
}
