package co.com.sofka.easy_fly.domain.flight;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.easy_fly.domain.flight.event.FlightCreated;
import co.com.sofka.easy_fly.domain.flight.values.*;

import java.util.List;

public class Flight extends AggregateEvent<FlightId> {
    protected Schedule schedule;
    protected Pilot pilot;
    protected Plane plane;
    protected FlightStatus flightStatus;

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

    public FlightStatus FlightStatus() {
        return flightStatus;
    }
    //<comportamientos de la funcion/>

    public void addSchedule(ScheduleId entityId, InRoomDateTime inRoomDateTime, DepartureDateTime departureDateTime, FlightDuration flightDuration){
        appendChange(new ScheduleCreated(entityId,inRoomDateTime, departureDateTime, flightDuration)).apply();
    }

}
