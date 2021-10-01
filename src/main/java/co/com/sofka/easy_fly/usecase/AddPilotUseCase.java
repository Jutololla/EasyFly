package co.com.sofka.easy_fly.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.easy_fly.domain.flight.Flight;
import co.com.sofka.easy_fly.domain.flight.command.AddPilot;

public class AddPilotUseCase extends UseCase<RequestCommand<AddPilot>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddPilot> addPilotRequestCommand) {
        var command = addPilotRequestCommand.getCommand();
        var flight = Flight.from(command.getFlightId(), retrieveEvents(command.getPilotId().value()));

        flight.addPilot(command.getPilotId(),
                command.getName(),
                command.getEmail());

        emit().onResponse(new ResponseEvents(flight.getUncommittedChanges()));
    }
}
