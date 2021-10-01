package co.com.sofka.easy_fly.domain.reservation.event;

import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.easy_fly.domain.reservation.values.EmergencyContactId;
import co.com.sofka.easy_fly.domain.reservation.values.PhoneNumber;
import co.com.sofka.easy_fly.domain.shared.Name;

public class EmergencyContactAdded extends DomainEvent {
    EmergencyContactId emergencyContactId;
    Name name;
    PhoneNumber phoneNumber;

    public EmergencyContactAdded(EmergencyContactId emergencyContactId, Name name, PhoneNumber phoneNumber) {
        super("sofka.easy_fly.reservation.emergencycontactadded");
        this.emergencyContactId = emergencyContactId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public EmergencyContactId getEmergencyContactId() {
        return emergencyContactId;
    }

    public Name getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
