package br.com.js.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.js.model.Moeda;
import br.com.js.repository.MoedaRepository;

@Service
public class MoedaServiceImp implements MoedaService{

	@Autowired
	private MoedaRepository moedaRepository;
	
	@Override
	public List<Moeda> findAll() {
		return moedaRepository.findAll();
	}

	@Override
	public Moeda save(Moeda moeda) {
		return moedaRepository.save(moeda);
	}

	@Override
	public Moeda update(Moeda moeda) {
		return moedaRepository.save(moeda);
	}

	@Override
	public void delete(Moeda moeda) {
		moedaRepository.delete(moeda);		
	}
	
}
