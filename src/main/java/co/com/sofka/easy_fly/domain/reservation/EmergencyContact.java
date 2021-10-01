package co.com.sofka.easy_fly.domain.reservation;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.easy_fly.domain.reservation.values.EmergencyContactId;
import co.com.sofka.easy_fly.domain.reservation.values.PhoneNumber;
import co.com.sofka.easy_fly.domain.shared.Name;

import java.util.Objects;

public class EmergencyContact extends Entity<EmergencyContactId> {
    protected Name name;
    protected PhoneNumber phoneNumber;

    private EmergencyContact(EmergencyContactId entityId) {
        super(entityId);
    }

    protected EmergencyContact(EmergencyContactId entityId, Name name, PhoneNumber phoneNumber) {
        super(entityId);
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public EmergencyContact from(EmergencyContactId entityId, Name name, PhoneNumber phoneNumber) {
        var emergencyContact = new EmergencyContact(entityId);
        this.name = name;
        this.phoneNumber = phoneNumber;
        return emergencyContact;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmergencyContact)) return false;
        if (!super.equals(o)) return false;
        EmergencyContact that = (EmergencyContact) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getPhoneNumber(), that.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName(), getPhoneNumber());
    }
}

