package pi.likvidatura.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pi.likvidatura.domain.BankarskiRacun;
import pi.likvidatura.repository.BankarskiRacunRepository;
import pi.likvidatura.service.BankarskiRacunService;
import pi.likvidatura.service.dto.BankarskiRacunDTO;
import pi.likvidatura.service.mapper.BankarskiRacunMapper;

/**
 * Service Implementation for managing {@link BankarskiRacun}.
 */
@Service
@Transactional
public class BankarskiRacunServiceImpl implements BankarskiRacunService {


    private final BankarskiRacunRepository bankarskiRacunRepository;

    private final BankarskiRacunMapper bankarskiRacunMapper;

    public BankarskiRacunServiceImpl(BankarskiRacunRepository bankarskiRacunRepository, BankarskiRacunMapper bankarskiRacunMapper) {
        this.bankarskiRacunRepository = bankarskiRacunRepository;
        this.bankarskiRacunMapper = bankarskiRacunMapper;
    }

    @Override
    public BankarskiRacunDTO save(BankarskiRacunDTO bankarskiRacunDTO) {
        BankarskiRacun bankarskiRacun = bankarskiRacunMapper.toEntity(bankarskiRacunDTO);
        bankarskiRacun = bankarskiRacunRepository.save(bankarskiRacun);
        return bankarskiRacunMapper.toDto(bankarskiRacun);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BankarskiRacunDTO> findAll() {
        return bankarskiRacunRepository
            .findAll()
            .stream()
            .map(bankarskiRacunMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<BankarskiRacunDTO> findOne(Long id) {
        return bankarskiRacunRepository.findById(id).map(bankarskiRacunMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        bankarskiRacunRepository.deleteById(id);
    }
}
