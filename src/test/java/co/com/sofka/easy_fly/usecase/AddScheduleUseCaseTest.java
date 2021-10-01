package co.com.sofka.easy_fly.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.easy_fly.domain.flight.command.AddSchedule;
import co.com.sofka.easy_fly.domain.flight.event.FlightCreated;
import co.com.sofka.easy_fly.domain.flight.event.ScheduleAdded;
import co.com.sofka.easy_fly.domain.flight.values.*;
import co.com.sofka.easy_fly.usecase.flight.AddScheduleUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class AddScheduleUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test the addition of a schedule to a flight when valid arguments are provided")
    void validArgumentsCase_addSchedule() {
        //arrange
        var command = new AddSchedule(
                new FlightId("Flight#001"),
                new ScheduleId("xxxx"),
                new InRoomDateTime(LocalDateTime.of(2022, 9, 30, 15, 30)),
                new DepartureDateTime(LocalDateTime.of(2022, 9, 30, 15, 45)),
                new FlightDuration(LocalTime.of(0, 30)));

        var useCase = new AddScheduleUseCase();
        Mockito.when(repository.getEventsBy(command.getScheduleId().value())).thenReturn(EventRestore());
        useCase.addRepository(repository);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getScheduleId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        var eventScheduleAdded = (ScheduleAdded)events.get(0);

        //assert
        Assertions.assertEquals("xxxx", eventScheduleAdded.getScheduleId().value());
        Assertions.assertEquals("30-09-2022 15:30", dateTimeFormatter.format(eventScheduleAdded.getInRoomDateTime().value()));
        Assertions.assertEquals("30-09-2022 15:45", dateTimeFormatter.format(eventScheduleAdded.getDepartureDateTime().value()));
        Assertions.assertEquals("00:30", eventScheduleAdded.getFlightDuration().value().toString());

    }
//
//    @Test
//    @DisplayName("Test the addition of a schedule to a flight when valid arguments are provided")
//    void invalidArgumentsCase_addSchedule() {
//        //arrange
//        var command = new AddSchedule(
//                new FlightId("Flight#001"),
//                new ScheduleId("xxxx"),
//                new InRoomDateTime(LocalDateTime.of(2022, 9, 30, 15, 30)),
//                new DepartureDateTime(LocalDateTime.of(2022, 9, 30, 15, 45)),
//                new FlightDuration(LocalTime.of(0, -130)));
//
//        var useCase = new AddScheduleUseCase();
//        Mockito.when(repository.getEventsBy(command.getScheduleId().value())).thenReturn(EventRestore());
//        useCase.addRepository(repository);
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
//
//        //act
//
//        var events = UseCaseHandler.getInstance()
//                .setIdentifyExecutor(command.getScheduleId().value())
//                .syncExecutor(useCase, new RequestCommand<>(command))
//                .orElseThrow()
//                .getDomainEvents();
//        var eventScheduleAdded = (ScheduleAdded)events.get(0);
//
//        //assert
//    }

    private List<DomainEvent> EventRestore() {
        return List.of(
                new FlightCreated(FlightId.of("Flight#001") ,new FlightStatus()));
    }
}