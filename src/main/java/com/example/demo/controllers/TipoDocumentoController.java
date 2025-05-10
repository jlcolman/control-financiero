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
<<<<<<< HEAD
@RequestMapping(path = { "tiposdocumento" })
=======
@RequestMapping(path = { "tipos-documento" })
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
@AllArgsConstructor
public class TipoDocumentoController {

	private TipoDocumentoService tipoDocumentoService;

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("tiposDocumento", tipoDocumentoService.getAlls());
<<<<<<< HEAD
		return "tiposdocumento/listar";
=======
		return "tipos-documento/listar";
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
	}

	@GetMapping("/form")
	public String mostrarFormulario(Model model) {
		model.addAttribute("tipoDocumento", new TipoDocumentos());
<<<<<<< HEAD
		return "tiposdocumento/formulario";
=======
		return "tipos-documento/formulario";
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute TipoDocumentos tipoDocumento) {
		tipoDocumentoService.save(tipoDocumento);
<<<<<<< HEAD
		return "redirect:/tiposdocumento";
=======
		return "redirect:/tipos-documento";
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Optional<TipoDocumentos> tipoDocumento = tipoDocumentoService.getById(id);

		if (tipoDocumento.isPresent()) {
			model.addAttribute("tipoDocumento", tipoDocumento.get());
<<<<<<< HEAD
			return "tiposdocumento/formulario";
		}

		return "redirect:/tiposdocumento";
=======
			return "tipos-documento/formulario";
		}

		return "redirect:/tipos-documento";
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
	}

	@PostMapping("/eliminar")
	public String eliminar(@RequestParam Long id) {
		tipoDocumentoService.delete(id);
<<<<<<< HEAD
		return "redirect:/tiposdocumento";
=======
		return "redirect:/tipos-documento";
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
	}
}