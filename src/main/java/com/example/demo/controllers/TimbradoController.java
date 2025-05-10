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

import com.example.demo.models.Cajas;
import com.example.demo.models.Sucursales;
import com.example.demo.models.Timbrado;
import com.example.demo.models.TipoDocumentos;
import com.example.demo.services.CajasService;
import com.example.demo.services.SucursalesService;
import com.example.demo.services.TimbradoService;
import com.example.demo.services.TipoDocumentoService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = { "timbrados" })
@AllArgsConstructor
public class TimbradoController {

	private TimbradoService timbradoService;
	private TipoDocumentoService tipoDocumentoService;
	private SucursalesService sucursalesService;
	private CajasService cajasService;

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("timbrados", timbradoService.getAlls());
		return "timbrados/listar";
	}

	@GetMapping("/form")
	public String mostrarFormulario(Model model) {
		model.addAttribute("timbrado", new Timbrado());
		List<TipoDocumentos> tiposDocumento = tipoDocumentoService.getAlls();
		List<Sucursales> sucursales = sucursalesService.getAlls();
		List<Cajas> cajas = cajasService.getAlls();
		model.addAttribute("tiposDocumento", tiposDocumento);
		model.addAttribute("sucursales", sucursales);
		model.addAttribute("cajas", cajas);
		return "timbrados/formulario";
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Timbrado timbrado) {
		timbradoService.save(timbrado);
		return "redirect:/timbrados";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Optional<Timbrado> timbrado = timbradoService.getById(id);
		List<TipoDocumentos> tiposDocumento = tipoDocumentoService.getAlls();
		List<Sucursales> sucursales = sucursalesService.getAlls();
		List<Cajas> cajas = cajasService.getAlls();

		if (timbrado.isPresent()) {
			model.addAttribute("timbrado", timbrado.get());
			model.addAttribute("tiposDocumento", tiposDocumento);
			model.addAttribute("sucursales", sucursales);
			model.addAttribute("cajas", cajas);
			return "timbrados/formulario";
		}

		return "redirect:/timbrados";
	}

	@PostMapping("/eliminar")
	public String eliminar(@RequestParam Long id) {
		timbradoService.delete(id);
		return "redirect:/timbrados";
	}
}
