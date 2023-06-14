package pl.javastart.restoffers.category;

import org.springframework.stereotype.Service;

@Service
public class CategoryDtoMapper {
    CategoryDto map(Category category) {
        CategoryDto dto = new CategoryDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        dto.setOffers(category.getOffers().size());
        return dto;
    }

    Category map(CategoryDto dto) {
        Category category = new Category();
        category.setId(dto.getId());
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
//        dto.setOffers(category.getOffers().size());
        return category;
    }
}
