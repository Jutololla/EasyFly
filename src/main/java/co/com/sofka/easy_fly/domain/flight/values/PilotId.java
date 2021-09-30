package co.com.sofka.easy_fly.domain.flight.values;

import co.com.sofka.domain.generic.Identity;

public class PilotId extends Identity {
    public PilotId(String id){
        super(id);
    }
    public PilotId(){}

    public static PilotId of(String id){
        return new PilotId(id);
    }
}
