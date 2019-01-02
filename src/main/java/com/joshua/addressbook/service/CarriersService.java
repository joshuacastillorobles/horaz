package com.joshua.addressbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joshua.addressbook.entity.Carrier;
import com.joshua.addressbook.repository.CarriersRepository;

@Service
public class CarriersService {

	@Autowired
	private CarriersRepository carriersRepository;

	public void create(Carrier carrierCode) {
		carriersRepository.save(carrierCode);
	}

	public List<Carrier> findAll() {
		return carriersRepository.findAll();
	}

	public Carrier findOne(String idCarrier) {
		Optional<Carrier> optional = carriersRepository.findById(idCarrier);
		Carrier carrier = optional.get();
		return carrier;
	}

	public List<Carrier> findName(String name) {
		return carriersRepository.findByName(name);
	}

	public void update(Carrier carrier) {
		carriersRepository.save(carrier);

	}

	public void deleteCode(String idCarrier) {
		carriersRepository.deleteById(idCarrier);
	}

	public boolean verifyCode(String idCarrier) {
		return carriersRepository.existsById(idCarrier);
	}

}
