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

import com.example.demo.models.Cajas;
import com.example.demo.services.CajasService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = { "cajas" })
@AllArgsConstructor
public class CajasController {

	private CajasService cajasService;

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("cajas", cajasService.getAlls());
		return "cajas/listar";
	}

	@GetMapping("/form")
	public String mostrarFormulario(Model model) {
		model.addAttribute("caja", new Cajas());
		return "cajas/formulario";
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Cajas caja) {
		cajasService.save(caja);
		return "redirect:/cajas";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Optional<Cajas> caja = cajasService.getById(id);

		if (caja.isPresent()) {
			model.addAttribute("caja", caja.get());
			return "cajas/formulario";
		}

		return "redirect:/cajas";
	}

	@PostMapping("/eliminar")
	public String eliminar(@RequestParam Long id) {
		cajasService.delete(id);
		return "redirect:/cajas";
	}
}
