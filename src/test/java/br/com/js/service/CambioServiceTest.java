package br.com.js.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.js.exceptions.ConversaoNaoEncontradaExeption;
import br.com.js.model.Cambio;

@SpringBootTest
public class CambioServiceTest {
	
	@Test
	public void cambiarMoedaTeste() throws ConversaoNaoEncontradaExeption {
	
	//cenario
		Cambio cambio = new Cambio();
		CambioService cambioService = new CambioService();
		
	//ação
		cambio = cambioService.cambiarMoeda("BRL", "CAD");
	
	//verificação
		assertTrue(cambio != null);
		
	}
	
	@Test
	public void calcularConversaoTeste() {
		//cenario
			CambioService cambioService = new CambioService();
			double valor1=2, valor2=6, valorEsperado=12;
			
		//ação
			double valorRetornado = cambioService.calcularConversao(valor1, valor2);
			
		//verificação
			assertEquals(valorEsperado, valorRetornado);
	}	
}
