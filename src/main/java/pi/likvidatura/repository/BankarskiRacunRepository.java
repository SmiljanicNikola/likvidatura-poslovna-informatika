package pi.likvidatura.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import pi.likvidatura.domain.BankarskiRacun;

/**
 * Spring Data SQL repository for the BankarskiRacun entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BankarskiRacunRepository extends JpaRepository<BankarskiRacun, Long> {}
