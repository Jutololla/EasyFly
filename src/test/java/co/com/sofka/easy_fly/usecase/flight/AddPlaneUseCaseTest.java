package co.com.sofka.easy_fly.usecase.flight;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.easy_fly.domain.flight.command.AddPlane;
import co.com.sofka.easy_fly.domain.flight.event.FlightCreated;
import co.com.sofka.easy_fly.domain.flight.event.PlaneAdded;
import co.com.sofka.easy_fly.domain.flight.values.FlightId;
import co.com.sofka.easy_fly.domain.flight.values.FlightStatus;
import co.com.sofka.easy_fly.domain.flight.values.Model;
import co.com.sofka.easy_fly.domain.flight.values.PlaneId;
import co.com.sofka.easy_fly.usecase.flight.AddPlaneUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AddPlaneUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test the addition of a plane to a flight when valid arguments are provided")
    void validArgumentsCase_addPlane(){
        //arrange
        var command = new AddPlane(
                new FlightId("Flight#001"),
                new PlaneId("AAAA"),
                new Model("Airbus 580"));

        var useCase = new AddPlaneUseCase();
        Mockito.when(repository.getEventsBy(command.getFlightId().value())).thenReturn(EventRestore());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPlaneId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        var eventPlaneAdded = (PlaneAdded)events.get(0);

        //assert
        Assertions.assertEquals("Airbus 580",eventPlaneAdded.getModel().value());








    }

    private List<DomainEvent> EventRestore() {
        return List.of(
                new FlightCreated(FlightId.of("Flight#001") ,new FlightStatus()));
    }

}