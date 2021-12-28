package pi.likvidatura.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import pi.likvidatura.domain.PoslovnaGodina;

/**
 * Spring Data SQL repository for the PoslovnaGodina entity.
 */
@Repository
public interface PoslovnaGodinaRepository extends JpaRepository<PoslovnaGodina, Long> {}
