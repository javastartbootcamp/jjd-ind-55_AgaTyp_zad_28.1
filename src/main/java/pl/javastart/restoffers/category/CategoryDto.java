package pl.javastart.restoffers.category;

public class CategoryDto {
    private Long id;
    private String name;
    private String description;
    private Integer offers;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOffers() {
        return offers;
    }

    public void setOffers(Integer offers) {
        this.offers = offers;
    }
}
