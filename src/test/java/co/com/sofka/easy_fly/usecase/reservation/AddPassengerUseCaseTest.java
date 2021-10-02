package co.com.sofka.easy_fly.usecase.reservation;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.easy_fly.domain.flight.values.FlightId;
import co.com.sofka.easy_fly.domain.reservation.command.AddPassenger;
import co.com.sofka.easy_fly.domain.reservation.event.LuggageAdded;
import co.com.sofka.easy_fly.domain.reservation.event.PassengerAdded;
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
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class AddPassengerUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test the addition of passenger to a reservation when valid arguments are provided")
    void validArguments_addPassenger(){
        //arrange
        var command = new AddPassenger(
                new ReservationId("123"),
                new PassengerId("456"),
                new Name("Juan"),
                new PhoneNumber("1551"),
                new Email("carlos@calor.co")
        );

        var useCase= new AddPassengerUseCase();
        Mockito.when(repository.getEventsBy(command.getReservationId().value())).thenReturn(EventRestore());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPassengerId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        var eventPilotAdded = (PassengerAdded)events.get(0);

        //Assert
        Assertions.assertEquals("456",eventPilotAdded.getPassengerId().value());
        Assertions.assertEquals("Juan",eventPilotAdded.getName().value());
        Assertions.assertEquals("1551", eventPilotAdded.getPhoneNumber().value());
        Assertions.assertEquals("carlos@calor.co", eventPilotAdded.getEmail().value());

  }

    private List<DomainEvent> EventRestore() {
        return List.of(
                new ReservationCreated(
                        ReservationId.of("123"),
                        new FlightId("665"),
                        new SeatId(2)));
    }

}