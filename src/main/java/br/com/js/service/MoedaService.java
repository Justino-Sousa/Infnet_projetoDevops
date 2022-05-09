package br.com.js.service;

import java.util.List;

import br.com.js.model.Moeda;

public interface MoedaService {
	
	public List<Moeda> findAll();
	public Moeda save(Moeda moeda);
	public Moeda update(Moeda moeda);
	public void delete(Moeda moeda);
}
