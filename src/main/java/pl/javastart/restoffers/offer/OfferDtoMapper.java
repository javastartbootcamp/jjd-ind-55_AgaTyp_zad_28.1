package pl.javastart.restoffers.offer;

import org.springframework.stereotype.Service;
import pl.javastart.restoffers.category.Category;
import pl.javastart.restoffers.category.CategoryRepository;

@Service
public class OfferDtoMapper {
    private final CategoryRepository categoryRepository;

    public OfferDtoMapper(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    OfferDto map(Offer offer) {
        OfferDto dto = new OfferDto();
        dto.setId(offer.getId());
        dto.setTitle(offer.getTitle());
        dto.setDescription(offer.getDescription());
        dto.setPrice(offer.getPrice());
        dto.setImgUrl(offer.getImgUrl());
        dto.setCategory(offer.getCategory().getName());
        return dto;
    }

    Offer map(OfferDto dto) {
        Offer offer = new Offer();
        offer.setId(dto.getId());
        offer.setTitle(dto.getTitle());
        offer.setDescription(dto.getDescription());
        offer.setPrice(dto.getPrice());
        offer.setImgUrl(dto.getImgUrl());
        Category category = categoryRepository.findByTitle(dto.getCategory());
        offer.setCategory(category);
        return offer;
    }
}
