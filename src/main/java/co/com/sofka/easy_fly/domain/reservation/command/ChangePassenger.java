package co.com.sofka.easy_fly.domain.reservation.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.easy_fly.domain.reservation.Reservation;
import co.com.sofka.easy_fly.domain.reservation.values.PassengerId;
import co.com.sofka.easy_fly.domain.reservation.values.PhoneNumber;
import co.com.sofka.easy_fly.domain.reservation.values.ReservationId;
import co.com.sofka.easy_fly.domain.shared.Email;
import co.com.sofka.easy_fly.domain.shared.Name;

public class ChangePassenger extends Command {
    private final ReservationId reservationId;
    private final PassengerId passengerId;
    private final Name name;
    private final PhoneNumber phoneNumber;
    private final Email email;

    public ReservationId getReservationId() {
        return reservationId;
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

    public ChangePassenger(ReservationId reservationId, PassengerId passengerId, Name name, PhoneNumber phoneNumber, Email email) {
        this.reservationId = reservationId;
        this.passengerId = passengerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;


    }
}
