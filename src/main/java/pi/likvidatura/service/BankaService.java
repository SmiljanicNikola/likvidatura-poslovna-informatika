package pi.likvidatura.service;

import java.util.List;
import java.util.Optional;
import pi.likvidatura.service.dto.BankaDTO;

/**
 * Service Interface for managing {@link pi.likvidatura.domain.Banka}.
 */
public interface BankaService {
    /**
     * Save a banka.
     *
     * @param bankaDTO the entity to save.
     * @return the persisted entity.
     */
    BankaDTO save(BankaDTO bankaDTO);

    /**
     * Get all the bankas.
     *
     * @return the list of entities.
     */
    List<BankaDTO> findAll();

    /**
     * Get the "id" banka.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<BankaDTO> findOne(Long id);

    /**
     * Delete the "id" banka.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
