package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Banco;
import com.example.demo.services.BancoService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = { "bancos" })
@AllArgsConstructor
public class BancoController {

	private BancoService bancoService;

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("bancos", bancoService.getAlls());
		return "bancos/listar";
	}

	@GetMapping("/form")
	public String mostrarFormulario(Model model) {
		model.addAttribute("banco", new Banco());
		return "bancos/formulario";
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Banco banco) {
		bancoService.save(banco);
		return "redirect:/bancos";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Optional<Banco> banco = bancoService.getById(id);

		if (banco.isPresent()) {
			model.addAttribute("banco", banco.get());
			return "bancos/formulario";
		}

		return "redirect:/bancos";
	}

	@PostMapping("/eliminar")
	public String eliminar(@RequestParam Long id) {
		bancoService.delete(id);
		return "redirect:/bancos";
	}
}