package pi.likvidatura.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import pi.likvidatura.domain.StavkaIzvoda;

@Repository
public interface StavkaIzvodaRepositoryPaging extends PagingAndSortingRepository<StavkaIzvoda, Long> {

}
