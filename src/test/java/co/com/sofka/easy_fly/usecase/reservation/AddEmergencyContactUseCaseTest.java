package co.com.sofka.easy_fly.usecase.reservation;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.easy_fly.domain.flight.values.FlightId;
import co.com.sofka.easy_fly.domain.reservation.command.AddEmergencyContact;
import co.com.sofka.easy_fly.domain.reservation.event.EmergencyContactAdded;
import co.com.sofka.easy_fly.domain.reservation.event.ReservationCreated;
import co.com.sofka.easy_fly.domain.reservation.values.EmergencyContactId;
import co.com.sofka.easy_fly.domain.reservation.values.PhoneNumber;
import co.com.sofka.easy_fly.domain.reservation.values.ReservationId;
import co.com.sofka.easy_fly.domain.reservation.values.SeatId;
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
class AddEmergencyContactUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test the addition of luggage to a reservation when valid arguments are provided")
    void validArguments_addEmergencyContact(){
        //arrange
        var command = new AddEmergencyContact(
          new ReservationId("GGF"),
          new EmergencyContactId("LLKL"),
          new Name("Pedro Manjarrez"),
          new PhoneNumber("01234567890")
        );
        var useCase = new AddEmergencyContactUseCase();
        Mockito.when(repository.getEventsBy(command.getEmergencyContactId().value())).thenReturn(EventRestore());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getEmergencyContactId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        var eventEmergencyContactAdded = (EmergencyContactAdded)events.get(0);

        //Assert
        Assertions.assertEquals("LLKL", command.getEmergencyContactId().value());
        Assertions.assertEquals("Pedro Manjarrez", command.getName().value());
        Assertions.assertEquals("01234567890",command.getPhoneNumber().value());

    }

    private List<DomainEvent> EventRestore() {
        return List.of(
                new ReservationCreated(
                        ReservationId.of("GGF"),
                        new FlightId("665"),
                        new SeatId(2)));
    }

}