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
<<<<<<< HEAD
@RequestMapping(path = { "tiposimpuesto" })
=======
@RequestMapping(path = { "tipos-impuesto" })
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
@AllArgsConstructor
public class TipoImpuestoController {

	private TipoImpuestoService service;

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("tiposImpuesto", service.getAllTiposImpuesto());
<<<<<<< HEAD
		return "tipoimpuesto/listar";
=======
		return "tipos-impuesto/listar";
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
	}

	@GetMapping("/form")
	public String mostrarFormulario(Model model) {
		model.addAttribute("tipoImpuesto", new TipoImpuesto());
<<<<<<< HEAD
		return "tipoimpuesto/formulario";
=======
		return "tipos-impuesto/formulario";
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute TipoImpuesto tipoimpuesto) {
		service.saveTipoImpuesto(tipoimpuesto);
<<<<<<< HEAD
		return "redirect:/tiposimpuesto";
=======
		return "redirect:/tipos-impuesto";
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long idTipoImpuesto, Model model) {

		Optional<TipoImpuesto> tipoImpuesto = service.getTipoImpuestoById(idTipoImpuesto);

		if (tipoImpuesto.isPresent()) {
			model.addAttribute("tipoImpuesto", tipoImpuesto.get());
<<<<<<< HEAD
			return "tiposimpuesto/formulario";
		}

		return "redirect:/tiposimpuesto";
=======
			return "tipos-impuesto/formulario";
		}

		return "redirect:/tipos-impuesto";
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
	}

	@PostMapping("/eliminar")
	public String eliminar(@RequestParam("id") Long idTipoImpuesto) {
		service.deleteTipoImpuesto(idTipoImpuesto);
<<<<<<< HEAD
		return "redirect:/tiposimpuesto";
=======
		return "redirect:/tipos-impuesto";
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
	}
}