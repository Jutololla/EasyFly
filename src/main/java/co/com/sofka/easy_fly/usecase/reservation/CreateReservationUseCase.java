package co.com.sofka.easy_fly.usecase.reservation;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.easy_fly.domain.reservation.Reservation;
import co.com.sofka.easy_fly.domain.reservation.command.CreateReservation;

public class CreateReservationUseCase extends UseCase<RequestCommand<CreateReservation>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateReservation> createReservationRequestCommand) {
        var command = createReservationRequestCommand.getCommand();

        var reservation = new Reservation(
                command.getReservationId(),
                command.getFlightId(),
                command.getSeatId());

        emit().onResponse(new ResponseEvents(reservation.getUncommittedChanges()));
    }
}
