package co.com.sofka.easy_fly.usecase.reservation;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.easy_fly.domain.reservation.Reservation;
import co.com.sofka.easy_fly.domain.reservation.command.AddPassenger;

public class AddPassengerUseCase extends UseCase<RequestCommand<AddPassenger>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddPassenger> addPassengerRequestCommand) {
        var command = addPassengerRequestCommand.getCommand();
        var reservation = Reservation.from(command.getReservationId(), retrieveEvents(command.getReservationId().value()));

        reservation.addPassenger(
                command.getPassengerId(),
                command.getName(),
                command.getPhoneNumber(),
                command.getEmail()
        );

        emit().onResponse(new ResponseEvents(reservation.getUncommittedChanges()));
    }
}
