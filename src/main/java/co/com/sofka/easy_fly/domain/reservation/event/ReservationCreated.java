package co.com.sofka.easy_fly.domain.reservation.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.easy_fly.domain.flight.values.FlightId;
import co.com.sofka.easy_fly.domain.reservation.EmergencyContact;
import co.com.sofka.easy_fly.domain.reservation.Luggage;
import co.com.sofka.easy_fly.domain.reservation.Passenger;
import co.com.sofka.easy_fly.domain.reservation.values.SeatId;

public class ReservationCreated extends DomainEvent {
    protected FlightId flightId;
    protected SeatId seatId;

    public ReservationCreated(SeatId seatId) {
        super("sofka.easy_fly.reservation.reservationcreated");
        this.flightId = new FlightId();
        this.seatId = seatId;
    }
    public ReservationCreated(FlightId flightId, SeatId seatId) {
        super("sofka.easy_fly.reservation.reservationcreated");
        this.flightId = flightId;
        this.seatId = seatId;
    }

    public FlightId getFlightId() {
        return flightId;
    }

    public SeatId getSeatId() {
        return seatId;
    }
}
