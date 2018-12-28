package com.joshua.addressbook.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joshua.addressbook.model.CarriersCode;
import com.joshua.addressbook.repository.CarrierCodeRepository;
import com.joshua.addressbook.service.ICarrierCodeService;

@Service
public class CarrierCodeService implements ICarrierCodeService {

	@Autowired
	private CarrierCodeRepository carrierRepo;

	@Override
	public void create(CarriersCode carrierCode) {
		carrierRepo.save(carrierCode);
	}

	@Override
	public List<CarriersCode> findAll() {
		return carrierRepo.findAll();
	}

	@Override
	public CarriersCode findOne(String idCarrier) {
		Optional<CarriersCode> optional = carrierRepo.findById(idCarrier);
		CarriersCode carriersCode = optional.get();
		return carriersCode;
	}

	@Override
	public List<CarriersCode> findName(String name) {
		return carrierRepo.findByName(name);
	}

	@Override
	public void update(CarriersCode carriersCode) {
		carrierRepo.save(carriersCode);

	}

	@Override
	public void deleteCode(String idCarrier) {
		carrierRepo.deleteById(idCarrier);
	}

	@Override
	public boolean verifyCode(String idCarrier) {
		return carrierRepo.existsById(idCarrier);
	}

}
