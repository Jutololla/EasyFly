package co.com.sofka.easy_fly.domain.reservation;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.easy_fly.domain.reservation.values.BaggagePieces;
import co.com.sofka.easy_fly.domain.reservation.values.HandLuggagePieces;
import co.com.sofka.easy_fly.domain.reservation.values.LuggageId;

import java.util.Objects;

public class Luggage extends Entity<LuggageId> {
    protected BaggagePieces baggagePieces;
    protected HandLuggagePieces handLuggagePieces;

    private Luggage(LuggageId entityId) {
        super(entityId);
    }

    protected Luggage(LuggageId entityId, BaggagePieces baggagePieces, HandLuggagePieces handLuggagePieces) {
        super(entityId);
        this.baggagePieces = baggagePieces;
        this.handLuggagePieces = handLuggagePieces;
    }

    public static Luggage from(LuggageId entityId, BaggagePieces baggagePieces, HandLuggagePieces handLuggagePieces) {
        var luggage = new Luggage(entityId);
        luggage.baggagePieces = baggagePieces;
        luggage.handLuggagePieces = handLuggagePieces;
        return luggage;
    }

    public BaggagePieces getBaggagePieces() {
        return baggagePieces;
    }

    public void setBaggagePieces(BaggagePieces baggagePieces) {
        this.baggagePieces = baggagePieces;
    }

    public HandLuggagePieces getHandLuggagePieces() {
        return handLuggagePieces;
    }

    public void setHandLuggagePieces(HandLuggagePieces handLuggagePieces) {
        this.handLuggagePieces = handLuggagePieces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Luggage)) return false;
        if (!super.equals(o)) return false;
        Luggage luggage = (Luggage) o;
        return Objects.equals(getBaggagePieces(), luggage.getBaggagePieces()) && Objects.equals(getHandLuggagePieces(), luggage.getHandLuggagePieces());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getBaggagePieces(), getHandLuggagePieces());
    }
}
