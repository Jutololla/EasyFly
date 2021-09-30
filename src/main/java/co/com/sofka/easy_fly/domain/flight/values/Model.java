package co.com.sofka.easy_fly.domain.flight.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Model implements ValueObject<String> {
    private final String value;

    public Model(String value) {
        this.value = Objects.requireNonNull(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Model)) return false;
        Model model = (Model) o;
        return Objects.equals(value, model.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
