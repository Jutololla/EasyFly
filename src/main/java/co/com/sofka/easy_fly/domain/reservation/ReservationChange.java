package co.com.sofka.easy_fly.domain.reservation;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.easy_fly.domain.reservation.event.LuggageAdded;
import co.com.sofka.easy_fly.domain.reservation.event.ReservationCreated;
import co.com.sofka.easy_fly.domain.reservation.values.LuggageId;
import co.com.sofka.easy_fly.domain.reservation.values.ReservationId;

public class ReservationChange extends EventChange {

    public ReservationChange(Reservation reservation){

        apply((ReservationCreated event) -> {
            reservation.flightId= event.getFlightId();
            reservation.seatId=event.getSeatId();
        });

        apply((LuggageAdded event) ->{
            reservation.luggage= new Luggage(
                    event.getLuggageId(),
                    event.getBaggagePieces(),
                    event.getHandLuggagePieces());
        });







    }
}
