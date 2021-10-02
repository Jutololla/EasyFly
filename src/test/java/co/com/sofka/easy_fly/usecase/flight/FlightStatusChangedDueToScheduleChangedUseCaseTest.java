//package co.com.sofka.easy_fly.usecase.flight;
//
//import co.com.sofka.business.generic.UseCase;
//import co.com.sofka.business.generic.UseCaseHandler;
//import co.com.sofka.business.repository.DomainEventRepository;
//import co.com.sofka.business.support.RequestCommand;
//import co.com.sofka.domain.generic.DomainEvent;
//import co.com.sofka.easy_fly.domain.flight.event.FlightCreated;
//import co.com.sofka.easy_fly.domain.flight.event.FlightStatusChangedDueToScheduleChanged;
//import co.com.sofka.easy_fly.domain.flight.event.ScheduleAdded;
//import co.com.sofka.easy_fly.domain.flight.event.ScheduledChanged;
//import co.com.sofka.easy_fly.domain.flight.values.*;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(MockitoExtension.class)
//class FlightStatusChangedDueToScheduleChangedUseCaseTest {
//
//    @Mock
//    private DomainEventRepository repository;
//
//    @Test
//    @DisplayName("Test the change of status triggered by a change in schedule")
//    void FlightStatusChangedDueToScheduleChanged() {
//        var event = new FlightStatusChangedDueToScheduleChanged(
//                new FlightId("2323"),
//                new FlightStatus()
//        );
//        var useCase = new FlightStatusChangedDueToScheduleChangedUseCase();
//        Mockito.when(repository.getEventsBy(Mockito.any())).thenReturn(EventRestore());
//        useCase.addRepository(repository);
//
//        var events = UseCaseHandler.getInstance()
//                .setIdentifyExecutor(event.getFlightId().value())
//                .syncExecutor(useCase, new RequestCommand<>(event))
//                .orElseThrow()
//                .getDomainEvents();
//
//    }
//
//    private List<DomainEvent> EventRestore() {
//        return List.of(
//                new FlightCreated(FlightId.of("Flight#001"), new FlightStatus()),
//                new ScheduleAdded(
//                        new ScheduleId("xxxx"),
//                        new InRoomDateTime(LocalDateTime.of(2022, 9, 30, 15, 30)),
//                        new DepartureDateTime(LocalDateTime.of(2022, 9, 30, 15, 45)),
//                        new FlightDuration(LocalTime.of(0, 30))),
//                new ScheduledChanged(
//                        new ScheduleId("xx15"),
//                        new InRoomDateTime(LocalDateTime.of(2022, 10, 30, 15, 30)),
//                        new DepartureDateTime(LocalDateTime.of(2022, 10, 30, 16, 45)),
//                        new FlightDuration(LocalTime.of(0, 45)))
//        );
//    }
//    }