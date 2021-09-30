package co.com.sofka.easy_fly.domain.flight.values;

import co.com.sofka.domain.generic.Identity;

public class PlaneId extends Identity {
    public PlaneId(String id){
        super(id);
    }
    public PlaneId(){}

    public static PlaneId of(String id){
        return new PlaneId(id);
    }
}
