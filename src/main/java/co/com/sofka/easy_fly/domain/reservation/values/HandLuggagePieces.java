package co.com.sofka.easy_fly.domain.reservation.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class HandLuggagePieces implements ValueObject<Integer> {
    private final Integer value;

    public HandLuggagePieces(Integer value) {
        if(value>=0) {
            this.value = value;
        }
        else{
            throw new IllegalArgumentException("HandLuggagePieces value can't be negative");
        }
    }

    public HandLuggagePieces(){
        this.value=0;
    }

    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HandLuggagePieces)) return false;
        HandLuggagePieces that = (HandLuggagePieces) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
