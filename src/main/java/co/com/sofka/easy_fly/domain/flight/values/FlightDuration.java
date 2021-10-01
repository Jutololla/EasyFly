package co.com.sofka.easy_fly.domain.flight.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalTime;
import java.util.Objects;

public class FlightDuration implements ValueObject<LocalTime> {
    private final LocalTime value;

    public FlightDuration(LocalTime value) {
        if(value.isAfter(LocalTime.of(0,0))){
            this.value = Objects.requireNonNull(value);
        }
        else{
            throw new IllegalArgumentException("The flight duration can't be negative");
        }
    }

    @Override
    public LocalTime value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightDuration)) return false;
        FlightDuration that = (FlightDuration) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return ""+value;
    }
}
