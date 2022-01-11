package pi.likvidatura.service;

import java.util.List;
import java.util.Optional;


import pi.likvidatura.domain.BankarskiRacun;
import pi.likvidatura.service.dto.BankarskiRacunDTO;

/**
 * Service Interface for managing {@link pi.likvidatura.domain.BankarskiRacun}.
 */
public interface BankarskiRacunService {
    /**
     * Save a bankarskiRacun.
     *
     * @param bankarskiRacunDTO the entity to save.
     * @return the persisted entity.
     */
    BankarskiRacunDTO save(BankarskiRacunDTO bankarskiRacunDTO);

    /**
     * Get all the bankarskiRacuns.
     *
     * @return the list of entities.
     */
    List<BankarskiRacun> findAll();

    /**
     * Get the "id" bankarskiRacun.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<BankarskiRacunDTO> findOne(Long id);
    
    Optional<BankarskiRacun> findOne2(Long id);
    
    public BankarskiRacun findOne3(Long id);

    /**
     * Delete the "id" bankarskiRacun.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
