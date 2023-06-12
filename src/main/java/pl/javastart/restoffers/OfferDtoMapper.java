package pl.javastart.restoffers;

import org.springframework.stereotype.Service;

@Service
public class OfferDtoMapper {
    OfferDto map(Offer offer) {
        OfferDto dto = new OfferDto();
        dto.setId(offer.getId());
        dto.setTitle(offer.getTitle());
        dto.setDescription(offer.getDescription());
        dto.setPrice(offer.getPrice());
        dto.setImgUrl(offer.getImgUrl());
        dto.setCategoryName(offer.getCompany().getName());
        return dto;
    }
}
