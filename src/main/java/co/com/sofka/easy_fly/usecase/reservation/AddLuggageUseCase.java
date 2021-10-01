package co.com.sofka.easy_fly.usecase.reservation;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.easy_fly.domain.reservation.Reservation;
import co.com.sofka.easy_fly.domain.reservation.command.AddLuggage;

public class AddLuggageUseCase extends UseCase<RequestCommand<AddLuggage>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddLuggage> addLuggageRequestCommand) {
        var command = addLuggageRequestCommand.getCommand();

        var reservation = Reservation.from(command.getReservationId(), retrieveEvents(command.getReservationId().value()));

        reservation.addLuggage(
                command.getLuggageId(),
                command.getBaggagePieces(),
                command.getHandLuggagePieces()
        );

        emit().onResponse(new ResponseEvents(reservation.getUncommittedChanges()));
    }
}
