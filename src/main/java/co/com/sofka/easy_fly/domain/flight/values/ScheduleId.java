package co.com.sofka.easy_fly.domain.flight.values;

import co.com.sofka.domain.generic.Identity;

public class ScheduleId extends Identity {
    public ScheduleId(String id){
        super(id);
    }
    public ScheduleId(){}

    public static ScheduleId of(String id){
        return new ScheduleId(id);
    }

}
