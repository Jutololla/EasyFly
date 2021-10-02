package co.com.sofka.easy_fly.usecase.reservation;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.easy_fly.domain.flight.command.AddPlane;
import co.com.sofka.easy_fly.domain.flight.event.FlightCreated;
import co.com.sofka.easy_fly.domain.flight.event.PilotAdded;
import co.com.sofka.easy_fly.domain.flight.values.FlightId;
import co.com.sofka.easy_fly.domain.flight.values.FlightStatus;
import co.com.sofka.easy_fly.domain.reservation.command.AddLuggage;
import co.com.sofka.easy_fly.domain.reservation.event.LuggageAdded;
import co.com.sofka.easy_fly.domain.reservation.event.ReservationCreated;
import co.com.sofka.easy_fly.domain.reservation.values.*;
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
class AddLuggageUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test the addition of luggage to a reservation when valid arguments are provided")
    void validArguments_addLuggage() {
        //arrange
        var command = new AddLuggage(
                new ReservationId("GGF"),
                new LuggageId("JJDS"),
                new BaggagePieces(2),
                new HandLuggagePieces(2));

        var useCase = new AddLuggageUseCase();
        Mockito.when(repository.getEventsBy(command.getReservationId().value())).thenReturn(EventRestore());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getLuggageId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        var eventPilotAdded = (LuggageAdded)events.get(0);

        //Assert
        Assertions.assertEquals("GGF", eventPilotAdded.aggregateRootId());
        Assertions.assertEquals("JJDS", eventPilotAdded.getLuggageId().value());
        Assertions.assertEquals(2,eventPilotAdded.getBaggagePieces().value());
        Assertions.assertEquals(2,eventPilotAdded.getHandLuggagePieces().value());





    }
        private List<DomainEvent> EventRestore() {
            return List.of(
                    new ReservationCreated(
                            ReservationId.of("GGF"),
                            new FlightId("665"),
                            new SeatId(2)));
        }

    }
