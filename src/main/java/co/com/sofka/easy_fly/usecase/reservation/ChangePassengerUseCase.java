package co.com.sofka.easy_fly.usecase.reservation;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.easy_fly.domain.reservation.Reservation;
import co.com.sofka.easy_fly.domain.reservation.command.ChangePassenger;

public class ChangePassengerUseCase extends UseCase<RequestCommand<ChangePassenger>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ChangePassenger> changePassengerRequestCommand) {
        var command = changePassengerRequestCommand.getCommand();
        var reservation = Reservation.from(command.getReservationId(), retrieveEvents(command.getReservationId().value()));

        reservation.changePassenger(
                command.getPassengerId(),
                command.getName(),
                command.getPhoneNumber(),
                command.getEmail()
        );
        emit().onResponse(new ResponseEvents(reservation.getUncommittedChanges()));
    }
}
