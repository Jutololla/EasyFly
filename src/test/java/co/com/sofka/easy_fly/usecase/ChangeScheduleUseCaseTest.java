package co.com.sofka.easy_fly.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.easy_fly.domain.flight.command.ChangeSchedule;
import co.com.sofka.easy_fly.domain.flight.event.FlightCreated;
import co.com.sofka.easy_fly.domain.flight.event.ScheduleAdded;
import co.com.sofka.easy_fly.domain.flight.event.ScheduledChanged;
import co.com.sofka.easy_fly.domain.flight.values.*;
import co.com.sofka.easy_fly.usecase.flight.ChangeScheduleUseCase;
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
class ChangeScheduleUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test the change of a schedule when valid arguments are provided")
    void validArgumentsCase_ChangeSchedule(){
        //arrange
        var command = new ChangeSchedule(
                new FlightId("Flight#001"),
                new ScheduleId("xx15"),
                new InRoomDateTime(LocalDateTime.of(2022, 10, 30, 15, 30)),
                new DepartureDateTime(LocalDateTime.of(2022, 10, 30, 15, 45)),
                new FlightDuration(LocalTime.of(0, 45)));
        var useCase = new ChangeScheduleUseCase();
        Mockito.when(repository.getEventsBy(Mockito.any())).thenReturn(EventRestore());
        useCase.addRepository(repository);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");


        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getFlightId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventChangedSchedule = (ScheduledChanged) events.get(0);
        Assertions.assertEquals("xx15", eventChangedSchedule.getScheduleId().value());
        Assertions.assertEquals("30-10-2022 15:30", dateTimeFormatter.format(eventChangedSchedule.getInRoomDateTime().value()));
        Assertions.assertEquals("30-10-2022 15:45", dateTimeFormatter.format(eventChangedSchedule.getDepartureDateTime().value()));
        Assertions.assertEquals("00:45", eventChangedSchedule.getFlightDuration().value().toString());








    }

    private List<DomainEvent> EventRestore() {
        return List.of(
                new FlightCreated(FlightId.of("Flight#001") ,new FlightStatus()),
                new ScheduleAdded(
                        new ScheduleId("xxxx"),
                        new InRoomDateTime(LocalDateTime.of(2022, 9, 30, 15, 30)),
                        new DepartureDateTime(LocalDateTime.of(2022, 9, 30, 15, 45)),
                        new FlightDuration(LocalTime.of(0, 30))
                ));
    }

}