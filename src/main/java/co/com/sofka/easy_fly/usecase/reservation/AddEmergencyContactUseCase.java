package co.com.sofka.easy_fly.usecase.reservation;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.easy_fly.domain.reservation.Reservation;
import co.com.sofka.easy_fly.domain.reservation.command.AddEmergencyContact;

public class AddEmergencyContactUseCase extends UseCase<RequestCommand<AddEmergencyContact>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddEmergencyContact> addEmergencyContactRequestCommand) {
        var command = addEmergencyContactRequestCommand.getCommand();
        var reservation = Reservation.from(command.getReservationId(), retrieveEvents(command.getEmergencyContactId().value()));

        reservation.addEmergencyContact(
                command.getEmergencyContactId(),
                command.getName(),
                command.getPhoneNumber()
        );
        emit().onResponse(new ResponseEvents(reservation.getUncommittedChanges()));

    }
}
