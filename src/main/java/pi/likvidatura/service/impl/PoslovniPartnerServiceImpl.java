package pi.likvidatura.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import pi.likvidatura.domain.PoslovniPartner;
import pi.likvidatura.repository.PoslovniPartnerRepository;
import pi.likvidatura.service.PoslovniPartnerService;

@Service
@Transactional
public class PoslovniPartnerServiceImpl implements PoslovniPartnerService {
	
	private final PoslovniPartnerRepository poslovniPartnerRepository;
	

	public PoslovniPartnerServiceImpl(PoslovniPartnerRepository poslovniPartnerRepository) {
		super();
		this.poslovniPartnerRepository = poslovniPartnerRepository;
	}

	@Override
	public PoslovniPartner save(PoslovniPartner poslovniPartner) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PoslovniPartner> findAll() {
		return poslovniPartnerRepository.findAll();
	}

	@Override
	public PoslovniPartner get(Long id) {
		return poslovniPartnerRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<PoslovniPartner> findAll(Pageable pageable) {
		return poslovniPartnerRepository.findAll(pageable);

	}

}
