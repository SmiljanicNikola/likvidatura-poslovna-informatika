package pi.likvidatura.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import pi.likvidatura.domain.IzlaznaFaktura;
import pi.likvidatura.domain.StavkaIzvoda;
import pi.likvidatura.service.dto.IzlaznaFakturaDTO;

/**
 * Service Interface for managing {@link pi.likvidatura.domain.IzlaznaFaktura}.
 */
public interface IzlaznaFakturaService {
    /**
     * Save a izlaznaFaktura.
     *
     * @param izlaznaFakturaDTO the entity to save.
     * @return the persisted entity.
     */
    IzlaznaFakturaDTO save(IzlaznaFakturaDTO izlaznaFakturaDTO);
    
    IzlaznaFaktura save(IzlaznaFaktura izlaznaFaktura);

    /**
     * Get all the izlaznaFakturas.
     *
     * @return the list of entities.
     */
    List<IzlaznaFaktura> findAll();
    


    /**
     * Get the "id" izlaznaFaktura.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<IzlaznaFakturaDTO> findOne(Long id);
    IzlaznaFaktura findOne2(Long id);


    /**
     * Delete the "id" izlaznaFaktura.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
    
    Page<IzlaznaFaktura> findAll(Pageable pageable);
    
  


}
