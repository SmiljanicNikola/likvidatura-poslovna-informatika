package pi.likvidatura.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pi.likvidatura.domain.Preduzece;
import pi.likvidatura.repository.PreduzeceRepository;
import pi.likvidatura.service.PreduzeceService;
import pi.likvidatura.service.dto.PreduzeceDTO;
import pi.likvidatura.service.mapper.PreduzeceMapper;

/**
 * Service Implementation for managing {@link Preduzece}.
 */
@Service
@Transactional
public class PreduzeceServiceImpl implements PreduzeceService {

    private final Logger log = LoggerFactory.getLogger(PreduzeceServiceImpl.class);

    private final PreduzeceRepository preduzeceRepository;

    private final PreduzeceMapper preduzeceMapper;

    public PreduzeceServiceImpl(PreduzeceRepository preduzeceRepository, PreduzeceMapper preduzeceMapper) {
        this.preduzeceRepository = preduzeceRepository;
        this.preduzeceMapper = preduzeceMapper;
    }

    @Override
    public PreduzeceDTO save(PreduzeceDTO preduzeceDTO) {
        log.debug("Request to save Preduzece : {}", preduzeceDTO);
        Preduzece preduzece = preduzeceMapper.toEntity(preduzeceDTO);
        preduzece = preduzeceRepository.save(preduzece);
        return preduzeceMapper.toDto(preduzece);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PreduzeceDTO> findAll() {
        log.debug("Request to get all");
        return preduzeceRepository.findAll().stream().map(preduzeceMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PreduzeceDTO> findOne(Long id) {
        log.debug("Request to get Preduzece : {}", id);
        return preduzeceRepository.findById(id).map(preduzeceMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Preduzece : {}", id);
        preduzeceRepository.deleteById(id);
    }
}
