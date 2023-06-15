package pl.javastart.restoffers.offer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/offers")
public class OfferController {
    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/{id}")
    ResponseEntity<OfferDto> getOfferById(@PathVariable Long id) {
        return offerService.getOfferById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("")
    ResponseEntity<List<OfferDto>> getOffer(@RequestParam(required = false) String title) {
        if (title != null) {
            if (offerService.getOffersByTitlePart(title).isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(offerService.getOffersByTitlePart(title));
        } else {
            if (offerService.getAllOffers().isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(offerService.getAllOffers());
        }

    }

    @GetMapping("/count")
    ResponseEntity<Integer> getOffersCounter() {
        return ResponseEntity.ok(offerService.getOffersCounter());

    }

    @PostMapping
    ResponseEntity<OfferDto> saveOffer(@RequestBody OfferDto offerDto) {
        OfferDto savedOffer = offerService.saveOffer(offerDto);
        URI savedOfferUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedOffer.getId())
                .toUri();
        return ResponseEntity.created(savedOfferUri).body(savedOffer);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteOffer(@PathVariable Long id) {
        offerService.deleteOffer(id);
        return ResponseEntity.noContent().build();
    }
}
