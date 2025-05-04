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

import com.example.demo.models.TipoDocumentos;
import com.example.demo.services.TipoDocumentoService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = { "tipos-documento" })
@AllArgsConstructor
public class TipoDocumentoController {

	private TipoDocumentoService tipoDocumentoService;

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("tiposDocumento", tipoDocumentoService.getAlls());
		return "tipos-documento/listar";
	}

	@GetMapping("/form")
	public String mostrarFormulario(Model model) {
		model.addAttribute("tipoDocumento", new TipoDocumentos());
		return "tipos-documento/formulario";
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute TipoDocumentos tipoDocumento) {
		tipoDocumentoService.save(tipoDocumento);
		return "redirect:/tipos-documento";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Optional<TipoDocumentos> tipoDocumento = tipoDocumentoService.getById(id);

		if (tipoDocumento.isPresent()) {
			model.addAttribute("tipoDocumento", tipoDocumento.get());
			return "tipos-documento/formulario";
		}

		return "redirect:/tipos-documento";
	}

	@PostMapping("/eliminar")
	public String eliminar(@RequestParam Long id) {
		tipoDocumentoService.delete(id);
		return "redirect:/tipos-documento";
	}
}