package co.com.sofka.easy_fly.domain.flight;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.easy_fly.domain.flight.values.ScheduleId;
import co.com.sofka.easy_fly.domain.shared.Email;
import co.com.sofka.easy_fly.domain.shared.Name;

import java.util.Objects;

public class Schedule extends Entity<ScheduleId> {
    protected Name name;
    protected Email email;

    protected Schedule(ScheduleId entityId, Name name, Email email) {
        super(entityId);
        this.name = name;
        this.email = email;
    }

    private Schedule(ScheduleId entityId) {
        super(entityId);
    }

    public static Schedule from(ScheduleId entityId, Name name, Email email){
        var schedule = new Schedule(entityId);
        schedule.name=name;
        schedule.email=email;
        return schedule;
    }

    public Name Name() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Email Email() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schedule)) return false;
        if (!super.equals(o)) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(name, schedule.name) && Objects.equals(email, schedule.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, email);
    }
}
