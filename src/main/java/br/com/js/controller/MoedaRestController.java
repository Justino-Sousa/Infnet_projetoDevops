package br.com.js.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.js.model.Moeda;
import br.com.js.service.MoedaService;

@RestController
@RequestMapping("/moeda")
public class MoedaRestController {
	
	@Autowired
	private MoedaService moeService;
	
	@GetMapping("/list")
	public List<Moeda> listar(){
		return moeService.findAll();
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Moeda adicionar(@RequestBody Moeda moeda){
		return moeService.save(moeda);
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.OK)
	public Moeda atualizar(@RequestBody Moeda moeda){
		return moeService.save(moeda);
	}
	
	@DeleteMapping("/delete")
	@ResponseStatus(HttpStatus.OK)
	public void deletar(@RequestBody Moeda moeda){
		moeService.delete(moeda);
	}
	
}
