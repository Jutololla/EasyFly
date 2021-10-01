package co.com.sofka.easy_fly.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.easy_fly.domain.flight.command.CreateFlight;
import co.com.sofka.easy_fly.domain.flight.event.FlightCreated;
import co.com.sofka.easy_fly.domain.flight.values.FlightId;
import co.com.sofka.easy_fly.domain.flight.values.FlightStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class createFlightUseCaseTest {

    @Test
    void validValuesCase_CreateFlight(){
        //arrange
        var command = new CreateFlight(
                FlightId.of("xxxxx"),
                new FlightStatus("Confirmed") );
        var useCase = new CreateFlightUseCase();
        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event = (FlightCreated)events.get(0);
        Assertions.assertEquals("xxxxx", event.aggregateRootId());
        Assertions.assertEquals("Confirmed", event.getFlightStatus().value());

    }
    @Test
    void NoDataCase_CreateFlight(){
        //arrange
        var command = new CreateFlight(
                new FlightId(),
                new FlightStatus());
        var useCase = new CreateFlightUseCase();
        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event = (FlightCreated)events.get(0);
        Assertions.assertFalse(event.aggregateRootId().isBlank()||event.aggregateRootId().isEmpty());
        Assertions.assertEquals("Pending", event.getFlightStatus().value());

    }

}