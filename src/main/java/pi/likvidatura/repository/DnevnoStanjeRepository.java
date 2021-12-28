package pi.likvidatura.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import pi.likvidatura.domain.DnevnoStanje;

/**
 * Spring Data SQL repository for the DnevnoStanje entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DnevnoStanjeRepository extends JpaRepository<DnevnoStanje, Long> {}
