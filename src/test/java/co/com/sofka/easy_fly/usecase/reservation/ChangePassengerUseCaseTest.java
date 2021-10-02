package co.com.sofka.easy_fly.usecase.reservation;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.easy_fly.domain.flight.event.FlightCreated;
import co.com.sofka.easy_fly.domain.flight.event.ScheduleAdded;
import co.com.sofka.easy_fly.domain.flight.values.*;
import co.com.sofka.easy_fly.domain.reservation.Reservation;
import co.com.sofka.easy_fly.domain.reservation.command.AddPassenger;
import co.com.sofka.easy_fly.domain.reservation.command.ChangePassenger;
import co.com.sofka.easy_fly.domain.reservation.event.PassengerAdded;
import co.com.sofka.easy_fly.domain.reservation.event.PassengerChanged;
import co.com.sofka.easy_fly.domain.reservation.event.ReservationCreated;
import co.com.sofka.easy_fly.domain.reservation.values.PassengerId;
import co.com.sofka.easy_fly.domain.reservation.values.PhoneNumber;
import co.com.sofka.easy_fly.domain.reservation.values.ReservationId;
import co.com.sofka.easy_fly.domain.reservation.values.SeatId;
import co.com.sofka.easy_fly.domain.shared.Email;
import co.com.sofka.easy_fly.domain.shared.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.MockHandler;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ChangePassengerUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test the change of a passenger when valid arguments are provided")
    void validArgumentsCase_ChangePassenger() {
        //arrange
        var command = new ChangePassenger(
                new ReservationId("XXXxX"),
                new PassengerId("343"),
                new Name("Juan"),
                new PhoneNumber("30342"),
                new Email("jajak@jeje.com")
        );
        var useCase = new ChangePassengerUseCase();
        Mockito.when(repository.getEventsBy(Mockito.any())).thenReturn(EventRestore());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getReservationId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        var event = (PassengerChanged) events.get(0);

        //assert
        Assertions.assertEquals("XXXxX", event.aggregateRootId());
        Assertions.assertEquals("343", event.getPassengerId().value());
        Assertions.assertEquals("Juan", event.getName().value());
        Assertions.assertEquals("30342", event.getPhoneNumber().value());
        Assertions.assertEquals("jajak@jeje.com", event.getEmail().value());


    }

    private List<DomainEvent> EventRestore() {
        return List.of(
                new ReservationCreated(new ReservationId("3131"), new FlightId("13"), new SeatId(15)),
                new PassengerAdded(
                        new PassengerId("456"),
                        new Name("Juan"),
                        new PhoneNumber("1551"),
                        new Email("carlos@calor.co")
                ));

    }

}