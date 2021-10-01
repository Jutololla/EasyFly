package co.com.sofka.easy_fly.usecase.reservation;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.easy_fly.domain.flight.values.FlightId;
import co.com.sofka.easy_fly.domain.reservation.ReservationChange;
import co.com.sofka.easy_fly.domain.reservation.command.CreateReservation;
import co.com.sofka.easy_fly.domain.reservation.event.ReservationCreated;
import co.com.sofka.easy_fly.domain.reservation.values.ReservationId;
import co.com.sofka.easy_fly.domain.reservation.values.SeatId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.Request;

import static org.junit.jupiter.api.Assertions.*;

class CreateReservationUseCaseTest {

    @Test
    @DisplayName("Test the creation of a reservation when valid arguments are provided")
    void validArgument_CreateReservation() {
        //arrange
        var command = new CreateReservation(
                ReservationId.of("BBB"),
                new FlightId("JJJ"),
                new SeatId(1));
        var useCase = new CreateReservationUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        var event = (ReservationCreated) events.get(0);
        Assertions.assertEquals("JJJ",event.getFlightId().value());
        Assertions.assertEquals(1,event.getSeatId().value());

        //assert

    }
}