package co.com.sofka.easy_fly.domain.reservation.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.easy_fly.domain.flight.values.FlightId;
import co.com.sofka.easy_fly.domain.reservation.values.ReservationId;
import co.com.sofka.easy_fly.domain.reservation.values.SeatId;

public class CreateReservation extends Command {
    private final ReservationId reservationId;
    private final FlightId flightId;
    private final SeatId seatId;

    public CreateReservation(ReservationId reservationId, FlightId flightId, SeatId seatId) {
        this.reservationId = reservationId;
        this.flightId = flightId;
        this.seatId = seatId;
    }

    public ReservationId getReservationId() {
        return reservationId;
    }

    public FlightId getFlightId() {
        return flightId;
    }

    public SeatId getSeatId() {
        return seatId;
    }
}
