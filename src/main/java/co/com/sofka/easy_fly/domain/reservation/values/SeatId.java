package co.com.sofka.easy_fly.domain.reservation.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class SeatId implements ValueObject<Integer> {
    private final Integer value;

    public SeatId(Integer value) {
        if(value>0) {
            this.value = Objects.requireNonNull(value);
        }
        else{
            throw new IllegalArgumentException("The seat id must be equals or greater than 1");
        }
    }

    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SeatId)) return false;
        SeatId seatId = (SeatId) o;
        return Objects.equals(value, seatId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
