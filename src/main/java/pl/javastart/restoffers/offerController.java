package pl.javastart.restoffers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class offerController {
    private final OfferService offerService;

    public offerController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/offers/{id}")
    Optional<OfferDto> getOfferById(@PathVariable Long id) {
        return offerService.getOfferById(id);
    }
}
