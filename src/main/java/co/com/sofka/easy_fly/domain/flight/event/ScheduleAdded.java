package co.com.sofka.easy_fly.domain.flight.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.easy_fly.domain.flight.values.*;

public class ScheduleAdded extends DomainEvent {
    private final ScheduleId scheduleId;
    private final InRoomDateTime inRoomDateTime;
    private final DepartureDateTime departureDateTime;
    private final FlightDuration flightDuration;

    public ScheduleAdded(ScheduleId scheduleId, InRoomDateTime inRoomDateTime, DepartureDateTime departureDateTime, FlightDuration flightDuration) {
        super("sofka.easy_fly.flight.flightcreated");
        this.scheduleId = scheduleId;
        this.inRoomDateTime = inRoomDateTime;
        this.departureDateTime = departureDateTime;
        this.flightDuration = flightDuration;
    }

    public ScheduleId getScheduleId() {
        return scheduleId;
    }

    public InRoomDateTime getInRoomDateTime() {
        return inRoomDateTime;
    }

    public DepartureDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public FlightDuration getFlightDuration() {
        return flightDuration;
    }
}
