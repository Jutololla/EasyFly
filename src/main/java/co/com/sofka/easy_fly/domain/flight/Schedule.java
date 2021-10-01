package co.com.sofka.easy_fly.domain.flight;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.easy_fly.domain.flight.values.DepartureDateTime;
import co.com.sofka.easy_fly.domain.flight.values.FlightDuration;
import co.com.sofka.easy_fly.domain.flight.values.InRoomDateTime;
import co.com.sofka.easy_fly.domain.flight.values.ScheduleId;
import co.com.sofka.easy_fly.domain.shared.Email;
import co.com.sofka.easy_fly.domain.shared.Name;

import java.util.Objects;

public class Schedule extends Entity<ScheduleId> {
    protected InRoomDateTime inRoomDateTime;
    protected DepartureDateTime departureDateTime;
    protected FlightDuration flightDuration;

    private Schedule(ScheduleId entityId) {
        super(entityId);
    }

    protected Schedule(ScheduleId entityId, InRoomDateTime inRoomDateTime, DepartureDateTime departureDateTime, FlightDuration flightDuration) {
        super(entityId);
        this.inRoomDateTime = inRoomDateTime;
        this.departureDateTime = departureDateTime;
        this.flightDuration = flightDuration;
    }

    public static Schedule from(ScheduleId scheduleId, InRoomDateTime inRoomDateTime, DepartureDateTime departureDateTime, FlightDuration flightDuration) {
        var schedule = new Schedule(scheduleId);
        schedule.inRoomDateTime = inRoomDateTime;
        schedule.departureDateTime = departureDateTime;
        schedule.flightDuration = flightDuration;
        return schedule;
    }

    public InRoomDateTime InRoomDateTime() {
        return inRoomDateTime;
    }

    public void setInRoomDateTime(InRoomDateTime inRoomDateTime) {
        this.inRoomDateTime = inRoomDateTime;
    }

    public DepartureDateTime DepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(DepartureDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public FlightDuration FlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(FlightDuration flightDuration) {
        this.flightDuration = flightDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schedule)) return false;
        if (!super.equals(o)) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(inRoomDateTime, schedule.inRoomDateTime) && Objects.equals(departureDateTime, schedule.departureDateTime) && Objects.equals(flightDuration, schedule.flightDuration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), inRoomDateTime, departureDateTime, flightDuration);
    }
}
