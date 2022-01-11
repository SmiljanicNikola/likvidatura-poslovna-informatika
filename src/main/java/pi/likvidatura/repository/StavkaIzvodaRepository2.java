package pi.likvidatura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pi.likvidatura.domain.StavkaIzvoda;

@Repository
public interface StavkaIzvodaRepository2 extends CrudRepository<StavkaIzvoda, Long> {

}
