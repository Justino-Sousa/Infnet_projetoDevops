package br.com.js.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import br.com.js.exceptions.ConversaoNaoEncontradaExeption;
import br.com.js.model.Cambio;
import br.com.js.util.Constantes;

@Service
public class CambioService {
	
	public Cambio cambiarMoeda(String iso1, String iso2) throws ConversaoNaoEncontradaExeption {
		Cambio cambio = new Cambio();
		try {
			RestTemplate restTemplate = new RestTemplate();
			String resourceUrl = Constantes.uri + iso1 + Constantes.separador + iso2;
			ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);
			String jsonString = response.getBody().replaceFirst(iso1, Constantes.NM_nestedClass);

			cambio = new Gson().fromJson(jsonString, Cambio.class);
		} catch (HttpClientErrorException e) {
			throw new ConversaoNaoEncontradaExeption();
		}
	
		return cambio;
	}
	
	
	public double calcularConversao(Double bid, double valor) {

		valor = valor * bid;
		return valor;
	}

}
