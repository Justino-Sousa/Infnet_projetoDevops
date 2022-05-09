package br.com.js.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.js.model.Moeda;
import br.com.js.repository.MoedaRepository;

@SpringBootTest
public class MoedaServiceTest {
	
	@InjectMocks
	private MoedaServiceImp service;
	
	@Mock
	private MoedaRepository repository;
	
	private Moeda moeda;
	
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		this.moeda = new Moeda(1L, "Real","BRL");
	}
	
	
	@Test
	public void whenFindallThenListAllMoedas(){
		Mockito.when(repository.findAll()).thenReturn(List.of(moeda));
		List<Moeda> response = service.findAll();
		
		assertNotNull(response);
		assertEquals(1,response.size());
		assertEquals(Moeda.class, response.get(0).getClass());
		assertEquals(1L, response.get(0).getId());
	}
	
	@Test
	public void whenSaveThenReturnMoeda(){
		Mockito.when(repository.save(this.moeda)).thenReturn(moeda);
		Moeda response = service.save(moeda);
		
		assertNotNull(response);
	}
	
	@Test
	public void whenUpdateThenReturnMoeda(){
		Mockito.when(repository.save(this.moeda)).thenReturn(moeda);
		Moeda response = service.update(moeda);
		
		assertNotNull(response);
	}
	
	@Test
	public void delete(){

		service.delete(this.moeda);
		Optional<Moeda> optionalMoeda2 = repository.findById(this.moeda.getId());
			assertTrue(optionalMoeda2.isEmpty());
	}
}
