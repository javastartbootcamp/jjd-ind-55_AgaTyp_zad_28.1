package pl.javastart.restoffers.offer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    @Query("SELECT o FROM Offer o WHERE lower(o.title) like lower(concat('%', :titlePart, '%')) ")
    List<Offer> findByTitleLike(@Param("titlePart") String titlePart);
}
