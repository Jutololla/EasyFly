package co.com.sofka.easy_fly.domain.reservation.event;

import co.com.sofka.domain.generic.DomainEvent;

public class AlertSentByReservationCreated extends DomainEvent {

    private final String message;

    public AlertSentByReservationCreated(String message){
        super("sofka.easy_fly.reservation.alertsentbyreservationcreated");
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
