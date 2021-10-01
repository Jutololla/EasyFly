package co.com.sofka.easy_fly.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.easy_fly.domain.flight.command.AddPilot;
import co.com.sofka.easy_fly.domain.flight.event.FlightCreated;
import co.com.sofka.easy_fly.domain.flight.event.PilotAdded;
import co.com.sofka.easy_fly.domain.flight.values.FlightId;
import co.com.sofka.easy_fly.domain.flight.values.FlightStatus;
import co.com.sofka.easy_fly.domain.flight.values.PilotId;
import co.com.sofka.easy_fly.domain.shared.Email;
import co.com.sofka.easy_fly.domain.shared.Name;
import co.com.sofka.easy_fly.usecase.flight.AddPilotUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AddPilotUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test the addition of a pilot to a flight when valid arguments are provided")
    void validArguments_addPilot(){
        //arrange
        var command = new AddPilot(
                new FlightId("Flight#001"),
                new PilotId("TTTT"),
                new Name("PEPE"),
                new Email("PEPE@PEPE.com"));

        var useCase = new AddPilotUseCase();
        Mockito.when(repository.getEventsBy(command.getPilotId().value())).thenReturn(EventRestore());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPilotId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        var eventPilotAdded = (PilotAdded)events.get(0);

        //Assert
        Assertions.assertEquals("PEPE", eventPilotAdded.getName().value());
        Assertions.assertEquals("PEPE@PEPE.com", eventPilotAdded.getEmail().value());

    }

    private List<DomainEvent> EventRestore() {
        return List.of(
                new FlightCreated(FlightId.of("Flight#001") ,new FlightStatus()));
    }

}