package co.com.sofka.easy_fly.domain.reservation;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.easy_fly.domain.reservation.event.*;
import co.com.sofka.easy_fly.domain.reservation.values.LuggageId;
import co.com.sofka.easy_fly.domain.reservation.values.ReservationId;

public class ReservationChange extends EventChange {

    public ReservationChange(Reservation reservation) {

        apply((ReservationCreated event) -> {
            reservation.flightId = event.getFlightId();
            reservation.seatId = event.getSeatId();
        });

        apply((LuggageAdded event) -> {
            reservation.luggage = new Luggage(
                    event.getLuggageId(),
                    event.getBaggagePieces(),
                    event.getHandLuggagePieces()
            );
        });

        apply((EmergencyContactAdded event) -> {
            reservation.emergencyContact = new EmergencyContact(
                    event.getEmergencyContactId(),
                    event.getName(),
                    event.getPhoneNumber()
            );
        });

        apply((PassengerAdded event) -> {
            reservation.passenger = new Passenger(
                    event.getPassengerId(),
                    event.getName(),
                    event.getPhoneNumber(),
                    event.getEmail()
            );
        });

        apply((PassengerChanged event) ->{
            reservation.passenger.setName(event.getName());
            reservation.passenger.setPhoneNumber(event.getPhoneNumber());
            reservation.passenger.setEmail(event.getEmail());
        });


    }
}
