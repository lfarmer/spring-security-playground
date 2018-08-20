package uk.co.leafdevelopment.edge.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.leafdevelopment.edge.client.BeerClient;
import uk.co.leafdevelopment.edge.dto.Beer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class GoodBeerRestController {

    private final BeerClient beerClient;

    public GoodBeerRestController(BeerClient beerClient) {
        this.beerClient = beerClient;
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/good-beers")
    public Collection<Beer> goodBeers() {
        return beerClient.readBeers()
                .getContent()
                .stream()
                .filter(this::isGreat)
                .collect(Collectors.toList());
    }

    public Collection<Beer> fallback() {
        return new ArrayList<>();
    }

    private boolean isGreat(Beer beer) {
        return !beer.getName().equals("Budweiser") &&
                !beer.getName().equals("Coors Light") &&
                !beer.getName().equals("PBR");
    }
}
