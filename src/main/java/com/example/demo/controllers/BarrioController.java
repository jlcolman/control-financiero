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

import com.example.demo.models.Barrio;
import com.example.demo.services.BarrioService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = "/barrios")
@AllArgsConstructor
public class BarrioController {

    private BarrioService barrioService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("barrios", barrioService.getAllBarrios());
        return "barrios/listar"; // Asegúrate de tener esta vista
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("barrio", new Barrio());
        return "barrios/formulario"; // Asegúrate de tener esta vista
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Barrio barrio) {
        barrioService.saveBarrio(barrio);
        return "redirect:/barrios";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Barrio> barrio = barrioService.getBarrioById(id);
        if (barrio.isPresent()) {
            model.addAttribute("barrio", barrio.get());
            return "barrios/formulario"; // Asegúrate de tener esta vista
        }
        return "redirect:/barrios";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        barrioService.deleteBarrio(id);
        return "redirect:/barrios";
    }
}
