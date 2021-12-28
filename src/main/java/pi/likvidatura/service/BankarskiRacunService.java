package pi.likvidatura.service;

import java.util.List;
import java.util.Optional;
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
    List<BankarskiRacunDTO> findAll();

    /**
     * Get the "id" bankarskiRacun.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<BankarskiRacunDTO> findOne(Long id);

    /**
     * Delete the "id" bankarskiRacun.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
