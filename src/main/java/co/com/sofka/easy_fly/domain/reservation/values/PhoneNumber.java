package co.com.sofka.easy_fly.domain.reservation.values;

import co.com.sofka.domain.generic.ValueObject;

public class PhoneNumber implements ValueObject<String> {
    private final String value;

    public PhoneNumber(String value) {
        try{
            var test = Integer.parseInt(value);
            this.value = value;
        }
        catch(Exception e) {
            throw new IllegalArgumentException("The phonenumber must contain only digits [0-9]");
        }
    }

    public String value() {
        return value;
    }
}
