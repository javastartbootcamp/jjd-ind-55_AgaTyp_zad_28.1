package pl.javastart.restoffers.offer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferService {
    private final OfferRepository offerRepository;
    private final OfferDtoMapper offerDtoMapper;

    public OfferService(OfferRepository offerRepository, OfferDtoMapper offerDtoMapper) {
        this.offerRepository = offerRepository;
        this.offerDtoMapper = offerDtoMapper;
    }

    Optional<OfferDto> getOfferById(Long id) {
        return offerRepository.findById(id)
                .map(offerDtoMapper::map);
    }

    List<OfferDto> getAllOffers() {
        return offerRepository.findAll()
                .stream()
                .map(offerDtoMapper::map)
                .toList();
    }

    List<OfferDto> getOffersByTitlePart(String titlePart) {
        return offerRepository.findByTitleLike(titlePart)
                .stream()
                .map(offerDtoMapper::map)
                .toList();
    }

    int getOffersCounter() {
        return getAllOffers().size();
    }

    OfferDto saveOffer(OfferDto offerDto) {
        Offer offerToSave = offerDtoMapper.map(offerDto);
        Offer savedOffer = offerRepository.save(offerToSave);
        return offerDtoMapper.map(savedOffer);
    }

    public void deleteOffer(Long id) {
        offerRepository.deleteById(id);
    }
}
