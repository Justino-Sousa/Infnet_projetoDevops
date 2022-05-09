package br.com.js.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.js.exceptions.ConversaoNaoEncontradaExeption;
import br.com.js.model.Moeda;
import br.com.js.repository.MoedaRepository;
import br.com.js.service.CambioService;

@Controller
public class CambioController {

	@Autowired
	private MoedaRepository moedaRepository;

	@Autowired
	private CambioService cambioService;

	@GetMapping("/")
	public ModelAndView listaMoedas(ModelMap model, @ModelAttribute("moeda") Moeda moeda) {
		model.addAttribute("moedas", moedaRepository.findAll());
		return new ModelAndView("home", model);
	}

	@PostMapping("/converter")
	public String cambiar(@RequestParam("codIso1") String codIso1, @RequestParam("codIso2") String codIso2,
			@RequestParam("valor1") double valor, RedirectAttributes attr) {
		
		try {
			valor = cambioService.calcularConversao(Double.valueOf(cambioService.cambiarMoeda(codIso1, codIso2).getNestedClass().getBid()), valor);
		} catch (ConversaoNaoEncontradaExeption e) {
			attr.addFlashAttribute("erro", "Erro, impossivel fazer converção!");
			return "redirect:/";
		}
		
		BigDecimal bd = new BigDecimal(valor);
		bd = bd.setScale(4, RoundingMode.HALF_EVEN);
		
		attr.addFlashAttribute("valor", bd.doubleValue());
		return "redirect:/";
	}
}
