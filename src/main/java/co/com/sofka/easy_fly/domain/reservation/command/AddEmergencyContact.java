package co.com.sofka.easy_fly.domain.reservation.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.easy_fly.domain.reservation.values.EmergencyContactId;
import co.com.sofka.easy_fly.domain.reservation.values.PhoneNumber;
import co.com.sofka.easy_fly.domain.reservation.values.ReservationId;
import co.com.sofka.easy_fly.domain.shared.Name;

public class AddEmergencyContact extends Command {
    private final ReservationId reservationId;
    private final EmergencyContactId emergencyContactId;
    private final Name name;
    private final PhoneNumber phoneNumber;

    public AddEmergencyContact(ReservationId reservationId, EmergencyContactId emergencyContactId, Name name, PhoneNumber phoneNumber) {
        this.reservationId = reservationId;
        this.emergencyContactId = emergencyContactId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public EmergencyContactId getEmergencyContactId() {
        return emergencyContactId;
    }

    public ReservationId getReservationId() {
        return reservationId;
    }

    public Name getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
