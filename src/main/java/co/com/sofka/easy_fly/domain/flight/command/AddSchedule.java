package co.com.sofka.easy_fly.domain.flight.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.easy_fly.domain.flight.values.*;

public class AddSchedule extends Command {
    private final FlightId flightId;
    private final ScheduleId scheduleId;
    private final InRoomDateTime inRoomDateTime;
    private final DepartureDateTime departureDateTime;
    private final FlightDuration flightDuration;

    public AddSchedule(FlightId flightId, ScheduleId scheduleId, InRoomDateTime inRoomDateTime, DepartureDateTime departureDateTime, FlightDuration flightDuration) {
        this.flightId = flightId;
        this.scheduleId = scheduleId;
        this.inRoomDateTime = inRoomDateTime;
        this.departureDateTime = departureDateTime;
        this.flightDuration = flightDuration;
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

    public ScheduleId getScheduleId() {
        return scheduleId;
    }

    public FlightId getFlightId() {
        return flightId;
    }
}
