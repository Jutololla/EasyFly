package co.com.sofka.easy_fly.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.easy_fly.domain.flight.Flight;
import co.com.sofka.easy_fly.domain.flight.command.AddPlane;

public class AddPlaneUseCase extends UseCase<RequestCommand<AddPlane>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddPlane> addPlaneRequestCommand) {
        var command = addPlaneRequestCommand.getCommand();

        var flight = Flight.from(command.getFlightId(), retrieveEvents(command.getFlightId().value()));

        flight.addPlane(command.getPlaneId(),
                command.getModel());

        emit().onResponse(new ResponseEvents(flight.getUncommittedChanges()));
    }
}
