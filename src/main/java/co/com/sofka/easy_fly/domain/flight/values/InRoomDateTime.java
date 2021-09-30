package co.com.sofka.easy_fly.domain.flight.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDateTime;
import java.util.Objects;

public class InRoomDateTime implements ValueObject<LocalDateTime> {
    private final LocalDateTime value;

    public InRoomDateTime(LocalDateTime value) {
        this.value = Objects.requireNonNull(value);
    }

    public LocalDateTime value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InRoomDateTime)) return false;
        InRoomDateTime that = (InRoomDateTime) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
