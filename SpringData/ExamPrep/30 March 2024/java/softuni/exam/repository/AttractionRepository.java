package softuni.exam.repository;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Attraction;

import java.util.Optional;
import java.util.Set;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, Long> {

    Optional<Attraction> findByName(String name);

    //    @Query("SELECT a FROM Attraction AS a " +
//            "WHERE a.elevation >= :el " +
//            "AND a.type = :type1 OR a.type = :type2 " +
//            "ORDER BY a.name, a.country.name")
    Set<Attraction> findByElevationGreaterThanEqualAndTypeOrTypeAndElevationGreaterThanEqualOrderByNameAscCountryName(int el, String type1, String type2, int elevation);
}