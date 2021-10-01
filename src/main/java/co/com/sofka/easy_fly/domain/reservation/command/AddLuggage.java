package co.com.sofka.easy_fly.domain.reservation.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.easy_fly.domain.reservation.values.BaggagePieces;
import co.com.sofka.easy_fly.domain.reservation.values.HandLuggagePieces;
import co.com.sofka.easy_fly.domain.reservation.values.LuggageId;
import co.com.sofka.easy_fly.domain.reservation.values.ReservationId;

public class AddLuggage extends Command {
    private final ReservationId reservationId;
    private final LuggageId luggageId;
    private final BaggagePieces baggagePieces;
    private final HandLuggagePieces handLuggagePieces;

    public AddLuggage(ReservationId reservationId, LuggageId luggageId, BaggagePieces baggagePieces, HandLuggagePieces handLuggagePieces) {
        this.reservationId = reservationId;
        this.luggageId = luggageId;
        this.baggagePieces = baggagePieces;
        this.handLuggagePieces = handLuggagePieces;
    }

    public ReservationId getReservationId() {
        return reservationId;
    }

    public BaggagePieces getBaggagePieces() {
        return baggagePieces;
    }

    public HandLuggagePieces getHandLuggagePieces() {
        return handLuggagePieces;
    }

    public LuggageId getLuggageId() {
        return luggageId;
    }
}
