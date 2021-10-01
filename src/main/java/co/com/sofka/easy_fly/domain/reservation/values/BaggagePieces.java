package co.com.sofka.easy_fly.domain.reservation.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class BaggagePieces implements ValueObject<Integer> {
    private final Integer value;

    public BaggagePieces(Integer value) {
    if(value>=0){
        this.value = value;
    }
    else{
    throw new IllegalArgumentException("Baggage pieces can't be negative");
    }
    }

    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaggagePieces)) return false;
        BaggagePieces that = (BaggagePieces) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
