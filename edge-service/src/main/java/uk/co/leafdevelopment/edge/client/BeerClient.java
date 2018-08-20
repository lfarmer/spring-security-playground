package uk.co.leafdevelopment.edge.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import uk.co.leafdevelopment.edge.dto.Beer;

@FeignClient("beer-catalog-service")
public interface BeerClient {

    @GetMapping("/beers")
    Resources<Beer> readBeers();

}
