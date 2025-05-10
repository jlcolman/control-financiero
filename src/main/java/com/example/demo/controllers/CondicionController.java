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
<<<<<<< HEAD
@RequestMapping(path = { "condicionespago" })
=======
@RequestMapping(path = { "condiciones-pago" })
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
@AllArgsConstructor
public class CondicionController {

	private CondicionService condicionService;

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("condiciones", condicionService.getAlls());
<<<<<<< HEAD
		return "condicionespago/listar";
=======
		return "condiciones-pago/listar";
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
	}

	@GetMapping("/form")
	public String mostrarFormulario(Model model) {
		model.addAttribute("condicion", new Condicion());
<<<<<<< HEAD
		return "condicionespago/formulario";
=======
		return "condiciones-pago/formulario";
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Condicion condicion) {
		condicionService.save(condicion);
<<<<<<< HEAD
		return "redirect:/condicionespago";
=======
		return "redirect:/condiciones-pago";
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Optional<Condicion> condicion = condicionService.getById(id);

		if (condicion.isPresent()) {
			model.addAttribute("condicion", condicion.get());
<<<<<<< HEAD
			return "condicionespago/formulario";
		}

		return "redirect:/condicionespago";
=======
			return "condiciones-pago/formulario";
		}

		return "redirect:/condiciones-pago";
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
	}

	@PostMapping("/eliminar")
	public String eliminar(@RequestParam Long id) {
		condicionService.delete(id);
<<<<<<< HEAD
		return "redirect:/condicionespago";
=======
		return "redirect:/condiciones-pago";
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
	}
}
