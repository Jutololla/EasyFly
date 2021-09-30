package co.com.sofka.easy_fly.domain.flight.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDateTime;
import java.util.Objects;

public class DepartureDateTime implements ValueObject<LocalDateTime> {
    private final LocalDateTime value;

    public DepartureDateTime(LocalDateTime value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public LocalDateTime value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DepartureDateTime)) return false;
        DepartureDateTime that = (DepartureDateTime) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
