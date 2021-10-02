package co.com.sofka.easy_fly.usecase.reservation;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.easy_fly.domain.reservation.Reservation;
import co.com.sofka.easy_fly.domain.reservation.event.ReservationCreated;
import co.com.sofka.easy_fly.domain.reservation.values.ReservationId;

public class AlertSentByReservationCreatedUseCase extends UseCase<TriggeredEvent<ReservationCreated>, ResponseEvents> {
    private final String MESSAGE = "Your reservation has been created. Attached you'll find the details.";

    @Override
    public void executeUseCase(TriggeredEvent<ReservationCreated> reservationCreatedTriggeredEvent) {

        var event = reservationCreatedTriggeredEvent.getDomainEvent();
        var reservation = Reservation.from(ReservationId.of(event.aggregateRootId()), this.retrieveEvents());

        reservation.sendAlertByReservationCreated(MESSAGE);
        emit().onResponse(new ResponseEvents(reservation.getUncommittedChanges()));
    }
}
