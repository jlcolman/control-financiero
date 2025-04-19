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

import com.example.demo.models.Departamento;
import com.example.demo.services.DepartamentoService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = "/departamentos")
@AllArgsConstructor
public class DepartamentosController {

	private DepartamentoService departamentoService;

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("departamentos", departamentoService.getAllDepartamentos());
		return "departamentos/listar";
	}

	@GetMapping("/form")
	public String mostrarFormulario(Model model) {
		model.addAttribute("departamento", new Departamento());
		return "departamentos/formulario";
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Departamento departamento) {
		departamentoService.saveDepartamento(departamento);
		return "redirect:/departamentos";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {

		Optional<Departamento> departamento = departamentoService.getDepartamentoById(id);

		if (departamento.isPresent()) {
			model.addAttribute("departamento", departamento.get());
			return "departamentos/formulario";
		}

		return "redirect:/departamentos";
	}

	@PostMapping("/eliminar")
	public String eliminar(@RequestParam Long id) {
		departamentoService.deleteDepartamento(id);
		return "redirect:/departamentos";
	}
}