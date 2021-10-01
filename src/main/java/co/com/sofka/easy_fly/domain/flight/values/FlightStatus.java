package co.com.sofka.easy_fly.domain.flight.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class FlightStatus implements ValueObject<String> {
    private final String value;

    public FlightStatus() {
        this.value="Pending";
    }

    public FlightStatus(String value) {
        if(value.isEmpty()||value.isBlank()){
            this.value="Pending";
        }
        else{this.value = value;};
    }

    public static FlightStatus of(String flightStatus){
        return new FlightStatus(flightStatus);
    }

    @Override
    public String value() {
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
