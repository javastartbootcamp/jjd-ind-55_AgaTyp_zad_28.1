package pl.javastart.restoffers;

import org.springframework.stereotype.Service;

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
}
