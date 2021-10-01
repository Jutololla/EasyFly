package co.com.sofka.easy_fly.domain.flight;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.easy_fly.domain.flight.event.*;
import co.com.sofka.easy_fly.domain.flight.values.*;
import co.com.sofka.easy_fly.domain.shared.Email;
import co.com.sofka.easy_fly.domain.shared.Name;

import java.util.List;
import java.util.Optional;

public class Flight extends AggregateEvent<FlightId> {
    protected Schedule schedule;
    protected Pilot pilot;
    protected Plane plane;
    protected FlightStatus flightStatus;

    public FlightStatus FlightStatus() {
        return flightStatus;
    }

    public Flight(FlightId entityId, FlightStatus flightStatus) {
        super(entityId);
        appendChange(new FlightCreated(flightStatus)).apply();
    }

    private Flight(FlightId entityId){
        super(entityId);
        subscribe(new FlightChange(this));
        }

    public static Flight from(FlightId entityId, List<DomainEvent> events){
        var flight = new Flight(entityId);
        events.forEach(flight::applyEvent);
        return flight;
        }
    //<comportamientos de la funcion/>

    public void addSchedule(ScheduleId scheduleId, InRoomDateTime inRoomDateTime, DepartureDateTime departureDateTime, FlightDuration flightDuration){
        appendChange(new ScheduleAdded(scheduleId, inRoomDateTime, departureDateTime, flightDuration)).apply();
    }

    public void changeSchedule(ScheduleId scheduleId, InRoomDateTime inRoomDateTime, DepartureDateTime departureDateTime, FlightDuration flightDuration){
        appendChange(new ScheduledChanged(scheduleId, inRoomDateTime, departureDateTime, flightDuration)).apply();
    }

    public void addPlane(PlaneId entityId, Model model){
        appendChange(new PlaneAdded(entityId, model)).apply();
    }

    public void addPilot(PilotId entityId, Name name, Email email) { new PilotAdded(entityId, name, email);}

}
