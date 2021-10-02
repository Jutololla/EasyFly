package co.com.sofka.easy_fly.domain.reservation.event;

import co.com.sofka.domain.generic.DomainEvent;

public class EmailSentDueToReservationCreated extends DomainEvent {
    private final String message;

    public EmailSentDueToReservationCreated(String message){
        super("sofka.easy_fly.reservation.emailsentduetoreservationcreated");
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
