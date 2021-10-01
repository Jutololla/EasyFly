package co.com.sofka.easy_fly.usecase.flight;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.easy_fly.domain.flight.Flight;
import co.com.sofka.easy_fly.domain.flight.command.ChangeSchedule;

public class ChangeScheduleUseCase extends UseCase<RequestCommand<ChangeSchedule>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ChangeSchedule> changeScheduleRequestCommand) {
        var command = changeScheduleRequestCommand.getCommand();
        var flight = Flight.from(command.getFlightId(), retrieveEvents(command.getFlightId().value()));

        flight.changeSchedule(command.getScheduleId(),
                command.getInRoomDateTime(),
                command.getDepartureDateTime(),
                command.getFlightDuration());

        emit().onResponse(new ResponseEvents(flight.getUncommittedChanges()));
    }
}
