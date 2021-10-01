package co.com.sofka.easy_fly.usecase.flight;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.easy_fly.domain.flight.Flight;
import co.com.sofka.easy_fly.domain.flight.Schedule;
import co.com.sofka.easy_fly.domain.flight.command.AddSchedule;
import co.com.sofka.easy_fly.domain.flight.values.FlightStatus;

public class AddScheduleUseCase extends UseCase<RequestCommand<AddSchedule>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddSchedule> addScheduleRequestCommand) {
        var command = addScheduleRequestCommand.getCommand();

        var flight = Flight.from(command.getFlightId(), retrieveEvents(command.getScheduleId().value()));

        flight.addSchedule(command.getScheduleId(),
                command.getInRoomDateTime(),
                command.getDepartureDateTime(),
                command.getFlightDuration());

        emit().onResponse(new ResponseEvents(flight.getUncommittedChanges()));




    }
}
