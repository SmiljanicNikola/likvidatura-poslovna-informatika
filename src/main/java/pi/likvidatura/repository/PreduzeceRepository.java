package pi.likvidatura.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import pi.likvidatura.domain.Preduzece;

/**
 * Spring Data SQL repository for the Preduzece entity.
 */
@Repository
public interface PreduzeceRepository extends JpaRepository<Preduzece, Long> {}
