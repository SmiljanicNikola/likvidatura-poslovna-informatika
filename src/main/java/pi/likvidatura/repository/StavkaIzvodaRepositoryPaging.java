package pi.likvidatura.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pi.likvidatura.domain.StavkaIzvoda;

@Repository
public interface StavkaIzvodaRepositoryPaging extends PagingAndSortingRepository<StavkaIzvoda, Long> {
	
	 @Query("FROM StavkaIzvoda s WHERE s.pozivNaBroj LIKE %:searchText% OR s.racunDuznika LIKE %:searchText% OR s.svrhaPlacanja LIKE %:searchText% OR s.primalac LIKE %:searchText%")
	 Page<StavkaIzvoda> findAllStavke(Pageable pageable, @Param("searchText") String searchText);

}
