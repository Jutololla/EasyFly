package co.com.sofka.easy_fly.domain.reservation.values;

import co.com.sofka.domain.generic.Identity;

public class LuggageId extends Identity {
    public LuggageId(String uuid) {
        super(uuid);
    }

    public static LuggageId of(String id) {
    return new LuggageId(id);
    }
}
