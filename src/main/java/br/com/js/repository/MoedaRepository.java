package br.com.js.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.js.model.Moeda;

@Repository
public interface MoedaRepository extends JpaRepository<Moeda, Long>{
	
}
