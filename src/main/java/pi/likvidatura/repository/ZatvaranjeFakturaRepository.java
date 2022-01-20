package pi.likvidatura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pi.likvidatura.domain.ZatvaranjeFaktura;

@Repository
public interface ZatvaranjeFakturaRepository extends JpaRepository<ZatvaranjeFaktura, Long> {

}
