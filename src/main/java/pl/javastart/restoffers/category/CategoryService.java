package pl.javastart.restoffers.category;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryDtoMapper categoryDtoMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryDtoMapper categoryDtoMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryDtoMapper = categoryDtoMapper;
    }

    Optional<CategoryDto> getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(categoryDtoMapper::map);
    }

    List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryDtoMapper::map)
                .toList();
    }

    List<String> getAllCategoriesNames() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryDtoMapper::map)
                .map(CategoryDto::getName)
                .toList();
    }

    CategoryDto saveCategory(CategoryDto categoryDto) {
        Category category = categoryDtoMapper.map(categoryDto);
        Category savedCategory = categoryRepository.save(category);
        return categoryDtoMapper.map(savedCategory);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
