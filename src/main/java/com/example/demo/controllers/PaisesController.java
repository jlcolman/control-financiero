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

import com.example.demo.models.Paises;
import com.example.demo.services.PaisesService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = "/paises")
@AllArgsConstructor
public class PaisesController {

    private PaisesService paisesService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("paises", paisesService.getAllPaises());
        return "paises/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("pais", new Paises()); // Corrección: Usar "pais" en singular
        return "paises/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Paises pais) { // Corrección: Usar "pais" en singular
        paisesService.savePais(pais);
        return "redirect:/paises";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Paises> pais = paisesService.getPaisById(id);
        if (pais.isPresent()) {
            model.addAttribute("pais", pais.get()); // Corrección: Usar "pais" en singular
            return "paises/formulario";
        }
        return "redirect:/paises";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        paisesService.deletePais(id);
        return "redirect:/paises";
    }
}