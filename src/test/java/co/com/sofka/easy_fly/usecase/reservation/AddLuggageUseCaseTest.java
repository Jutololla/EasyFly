package co.com.sofka.easy_fly.usecase.reservation;

import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.easy_fly.domain.flight.command.AddPlane;
import co.com.sofka.easy_fly.domain.flight.event.FlightCreated;
import co.com.sofka.easy_fly.domain.flight.values.FlightId;
import co.com.sofka.easy_fly.domain.flight.values.FlightStatus;
import co.com.sofka.easy_fly.domain.reservation.command.AddLuggage;
import co.com.sofka.easy_fly.domain.reservation.event.LuggageAdded;
import co.com.sofka.easy_fly.domain.reservation.event.ReservationCreated;
import co.com.sofka.easy_fly.domain.reservation.values.*;
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
    Integer a =1;
    Integer b=2;

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
        Mockito.when(repository.getEventsBy(command.getLuggageId()Id().value())).thenReturn(EventRestore());
        useCase.addRepository(repository);





    }
        private List<DomainEvent> EventRestore() {
            return List.of(
                    new ReservationCreated(ReservationId.of("GGF"),new FlightId("665"),new SeatId(2)));
        }

    }
