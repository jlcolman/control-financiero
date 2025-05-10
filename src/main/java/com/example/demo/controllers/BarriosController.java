package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Barrios;
import com.example.demo.models.Ciudad;
import com.example.demo.services.BarriosService;
import com.example.demo.services.CiudadService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = { "barrios" })
@AllArgsConstructor
public class BarriosController {

	private BarriosService barriosService;
	private CiudadService ciudadService;

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("barrios", barriosService.getAlls());
		return "barrios/listar";
	}

	@GetMapping("/form")
	public String mostrarFormulario(Model model) {
		model.addAttribute("barrio", new Barrios());
		List<Ciudad> ciudades = ciudadService.getAlls();
		model.addAttribute("ciudad", ciudades);
		return "barrios/formulario";
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Barrios barrios) {
		barriosService.save(barrios);
		return "redirect:/barrios";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Optional<Barrios> barrios = barriosService.getById(id);
		List<Ciudad> ciudad = ciudadService.getAlls();
		if (barrios.isPresent()) {
			model.addAttribute("barrio", barrios.get());
			model.addAttribute("ciudad", ciudad);
			return "barrios/formulario";
		}

		return "redirect:/barrios";
	}

	@PostMapping("/eliminar")
	public String eliminar(@RequestParam Long id) {
		barriosService.delete(id);
		return "redirect:/barrios";
	}
}