package co.com.sofka.easy_fly.usecase;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.easy_fly.domain.flight.Flight;
import co.com.sofka.easy_fly.domain.flight.values.FlightId;

import java.util.List;

public class createFlightUseCase extends UseCase<createFlightUseCase.Request, createFlightUseCase.Response> {

    @Override
    public void executeUseCase(Request request) {

        //en est espacio se recrea el objeto a crear, creando uno nuevo
        // y asignandole los atributos traidos por el Request, pero como en mi caso solo es el ID.

        var flight = new Flight(request.getId());
        List<DomainEvent> eventList=
    }

    public static class Request implements UseCase.RequestValues{
        private final String id;

        public Request(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
    public static class Response implements  UseCase.ResponseValues{
        private final List<DomainEvent> eventList;

        public Response(List<DomainEvent> eventList) {
            this.eventList=eventList;
        }
        public List<DomainEvent> getEventList(){
            return eventList;
        }
            }

}
