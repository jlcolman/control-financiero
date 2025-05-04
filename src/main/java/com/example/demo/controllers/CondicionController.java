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

import com.example.demo.models.Condicion;
import com.example.demo.services.CondicionService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = { "condiciones-pago" })
@AllArgsConstructor
public class CondicionController {

	private CondicionService condicionService;

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("condiciones", condicionService.getAlls());
		return "condiciones-pago/listar";
	}

	@GetMapping("/form")
	public String mostrarFormulario(Model model) {
		model.addAttribute("condicion", new Condicion());
		return "condiciones-pago/formulario";
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Condicion condicion) {
		condicionService.save(condicion);
		return "redirect:/condiciones-pago";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Optional<Condicion> condicion = condicionService.getById(id);

		if (condicion.isPresent()) {
			model.addAttribute("condicion", condicion.get());
			return "condiciones-pago/formulario";
		}

		return "redirect:/condiciones-pago";
	}

	@PostMapping("/eliminar")
	public String eliminar(@RequestParam Long id) {
		condicionService.delete(id);
		return "redirect:/condiciones-pago";
	}
}
