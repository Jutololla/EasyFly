package co.com.sofka.easy_fly.domain.flight.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class FlightStatus implements ValueObject<Integer> {
    private final Integer value;

    public FlightStatus(Integer value) {
        this.value = Objects.requireNonNull(value);
    }

    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightStatus)) return false;
        FlightStatus that = (FlightStatus) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
