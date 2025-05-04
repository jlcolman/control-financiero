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

import com.example.demo.models.TipoImpuesto;
import com.example.demo.services.TipoImpuestoService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = { "tipos-impuesto" })
@AllArgsConstructor
public class TipoImpuestoController {

	private TipoImpuestoService service;

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("tiposImpuesto", service.getAllTiposImpuesto());
		return "tipos-impuesto/listar";
	}

	@GetMapping("/form")
	public String mostrarFormulario(Model model) {
		model.addAttribute("tipoImpuesto", new TipoImpuesto());
		return "tipos-impuesto/formulario";
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute TipoImpuesto tipoimpuesto) {
		service.saveTipoImpuesto(tipoimpuesto);
		return "redirect:/tipos-impuesto";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long idTipoImpuesto, Model model) {

		Optional<TipoImpuesto> tipoImpuesto = service.getTipoImpuestoById(idTipoImpuesto);

		if (tipoImpuesto.isPresent()) {
			model.addAttribute("tipoImpuesto", tipoImpuesto.get());
			return "tipos-impuesto/formulario";
		}

		return "redirect:/tipos-impuesto";
	}

	@PostMapping("/eliminar")
	public String eliminar(@RequestParam("id") Long idTipoImpuesto) {
		service.deleteTipoImpuesto(idTipoImpuesto);
		return "redirect:/tipos-impuesto";
	}
}