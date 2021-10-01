package co.com.sofka.easy_fly.domain.reservation.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.easy_fly.domain.reservation.values.BaggagePieces;
import co.com.sofka.easy_fly.domain.reservation.values.HandLuggagePieces;
import co.com.sofka.easy_fly.domain.reservation.values.LuggageId;

public class LuggageAdded extends DomainEvent {
    private final LuggageId luggageId;
    private final BaggagePieces baggagePieces;
    private final HandLuggagePieces handLuggagePieces;

    public LuggageAdded(LuggageId luggageId, BaggagePieces baggagePieces, HandLuggagePieces handLuggagePieces) {
        super("sofka.easy_fly.reservation.baggageadded");
        this.luggageId = luggageId;
        this.baggagePieces = baggagePieces;
        this.handLuggagePieces = handLuggagePieces;
    }

    public LuggageId getLuggageId() {
        return luggageId;
    }

    public BaggagePieces getBaggagePieces() {
        return baggagePieces;
    }

    public HandLuggagePieces getHandLuggagePieces() {
        return handLuggagePieces;
    }
}
