package co.com.sofka.easy_fly.usecase.reservation;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.easy_fly.domain.reservation.event.EmailSentDueToReservationCreated;
import co.com.sofka.easy_fly.usecase.SendEmailService;

public class SendEmailDueToReservationCreatedUseCase extends UseCase<TriggeredEvent<EmailSentDueToReservationCreated>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<EmailSentDueToReservationCreated> emailSentDueToReservationCreatedTriggeredEvent) {
        var event= emailSentDueToReservationCreatedTriggeredEvent.getDomainEvent();
        var service =getService(SendEmailService.class).orElseThrow();
        var ok =service.sendEmail("client.distro@easyfly.com", "Flight reservation succesfully created"
        ,event.getMessage());

        if(!ok){
            emit().onError(new BusinessException(
                    event.aggregateRootId(), "Notification mail was not send"
            ));
        }

    }
}
