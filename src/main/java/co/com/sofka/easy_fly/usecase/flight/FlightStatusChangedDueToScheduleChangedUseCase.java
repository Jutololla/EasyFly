package co.com.sofka.easy_fly.usecase.flight;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.easy_fly.domain.flight.Flight;
import co.com.sofka.easy_fly.domain.flight.event.FlightStatusChangedDueToScheduleChanged;

public class FlightStatusChangedDueToScheduleChangedUseCase extends UseCase<TriggeredEvent<FlightStatusChangedDueToScheduleChanged>, ResponseEvents> {


    @Override
    public void executeUseCase(TriggeredEvent<FlightStatusChangedDueToScheduleChanged> flightStatusChangedDueToScheduleChangedTriggeredEvent) {
        var command = flightStatusChangedDueToScheduleChangedTriggeredEvent.getDomainEvent();
        var flight = Flight.from(command.getFlightId(), retrieveEvents(command.getFlightStatus().value()));

        flight.changeFlightStatusDueToScheduledChanged(
                command.getFlightId(),
                command.getFlightStatus()
        );
        emit().onResponse(new ResponseEvents(flight.getUncommittedChanges()));
    }
}
