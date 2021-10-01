package co.com.sofka.easy_fly.domain.reservation;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.easy_fly.domain.flight.values.FlightId;
import co.com.sofka.easy_fly.domain.reservation.event.LuggageAdded;
import co.com.sofka.easy_fly.domain.reservation.event.ReservationCreated;
import co.com.sofka.easy_fly.domain.reservation.values.*;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.List;

public class Reservation extends AggregateEvent<ReservationId> {
    protected FlightId flightId;
    protected Passenger passenger;
    protected Luggage luggage;
    protected EmergencyContact emergencyContact;
    protected SeatId seatId;

    public Reservation(ReservationId reservationId, FlightId flightId, SeatId seatId){
        super(reservationId);
        appendChange(new ReservationCreated(flightId,seatId)).apply();

    }

    private Reservation(ReservationId reservationId){
        super(reservationId);
        subscribe(new ReservationChange(this));
    }

    public static Reservation from(ReservationId reservationId, List<DomainEvent> events){
        var reservation = new Reservation(reservationId);
        events.forEach(reservation::applyEvent);
        return reservation;
    }

    public FlightId getFlightId() {
        return flightId;
    }

    public SeatId getSeatId() {
        return seatId;
    }

    //comportamientos de la funcion

    public void addLuggage(LuggageId luggageId, BaggagePieces baggagePieces, HandLuggagePieces handLuggagePieces){
        appendChange(new LuggageAdded(luggageId, baggagePieces, handLuggagePieces)).apply();
    }
}

