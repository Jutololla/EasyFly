package co.com.sofka.easy_fly.usecase;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.easy_fly.domain.flight.Flight;
import co.com.sofka.easy_fly.domain.flight.command.CreateFlight;

public class CreateFlightUseCase extends UseCase<RequestCommand<CreateFlight>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateFlight> createFlightRequestCommand) {
        var command = createFlightRequestCommand.getCommand();

        var flight = new Flight(
                command.getEntityId(),
                command.getFlightStatus());

        emit().onResponse(new ResponseEvents(flight.getUncommittedChanges()));
    }
}














