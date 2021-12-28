package pi.likvidatura.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import pi.likvidatura.domain.StavkaIzvoda;

/**
 * Spring Data SQL repository for the StavkaIzvoda entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StavkaIzvodaRepository extends JpaRepository<StavkaIzvoda, Long> {}
