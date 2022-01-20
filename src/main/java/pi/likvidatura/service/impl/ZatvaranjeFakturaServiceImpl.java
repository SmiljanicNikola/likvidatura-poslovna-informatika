package pi.likvidatura.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pi.likvidatura.domain.ZatvaranjeFaktura;
import pi.likvidatura.repository.ZatvaranjeFakturaRepository;
import pi.likvidatura.service.ZatvaranjeFakturaService;

@Service
@Transactional
public class ZatvaranjeFakturaServiceImpl implements ZatvaranjeFakturaService {
	
	private final ZatvaranjeFakturaRepository zatvaranjeFakturaRepository;
	
	
	public ZatvaranjeFakturaServiceImpl(ZatvaranjeFakturaRepository zatvaranjeFakturaRepository) {
		super();
		this.zatvaranjeFakturaRepository = zatvaranjeFakturaRepository;
	}
	

	@Override
	public ZatvaranjeFaktura save(ZatvaranjeFaktura zatvaranjeFaktura) {
		return zatvaranjeFaktura = zatvaranjeFakturaRepository.save(zatvaranjeFaktura);
	}

	@Override
	public List<ZatvaranjeFaktura> findAll() {
		return zatvaranjeFakturaRepository.findAll();
	}

	@Override
	public Optional<ZatvaranjeFaktura> findOne2(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ZatvaranjeFaktura findOne(Long id) {
		return zatvaranjeFakturaRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		zatvaranjeFakturaRepository.deleteById(id);
	}

	@Override
	public Page<ZatvaranjeFaktura> findAll(Pageable pageable) {
		return zatvaranjeFakturaRepository.findAll(pageable);
	}

}
