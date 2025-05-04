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
import com.example.demo.models.Cliente;
import com.example.demo.services.BarriosService;
import com.example.demo.services.ClienteService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = { "clientes" })
@AllArgsConstructor
public class ClienteController {

	private ClienteService clienteService;
	private BarriosService barriosService;

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("clientes", clienteService.getAlls());
		return "clientes/listar";
	}

	@GetMapping("/form")
	public String mostrarFormulario(Model model) {
		model.addAttribute("cliente", new Cliente());
		List<Barrios> barrios = barriosService.getAlls();
		model.addAttribute("barrios", barrios);
		return "clientes/formulario";
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Cliente cliente) {
		clienteService.save(cliente);
		return "redirect:/clientes";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Optional<Cliente> cliente = clienteService.getById(id);
		List<Barrios> barrios = barriosService.getAlls();

		if (cliente.isPresent()) {
			model.addAttribute("cliente", cliente.get());
			model.addAttribute("barrios", barrios);
			return "clientes/formulario";
		}

		return "redirect:/clientes";
	}

	@PostMapping("/eliminar")
	public String eliminar(@RequestParam Long id) {
		clienteService.delete(id);
		return "redirect:/clientes";
	}
}
