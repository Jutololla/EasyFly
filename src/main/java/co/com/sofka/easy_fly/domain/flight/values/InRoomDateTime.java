package co.com.sofka.easy_fly.domain.flight.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDateTime;
import java.util.Objects;

public class InRoomDateTime implements ValueObject<LocalDateTime> {
    private final LocalDateTime value;

    public InRoomDateTime(LocalDateTime value) {
        if(value.isAfter(LocalDateTime.now())){
            this.value = Objects.requireNonNull(value);
        }
        else{
            throw new IllegalArgumentException("The value of InRoomDateTime can't be before the actual time");
        }
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
