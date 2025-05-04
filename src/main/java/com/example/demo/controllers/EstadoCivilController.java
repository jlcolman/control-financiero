package com.example.demo.controllers;

import com.example.demo.models.EstadoCivil;
import com.example.demo.services.EstadoCivilService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/estados-civiles")
@AllArgsConstructor
public class EstadoCivilController {

    private final EstadoCivilService estadoCivilService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("estadoscivil", estadoCivilService.getAllEstadoCivil());
        return "estadosCiviles/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("estadoCivil", new EstadoCivil());
        return "estadosCiviles/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute EstadoCivil estadoCivil) {
        estadoCivilService.saveEstadoCivil(estadoCivil);
        return "redirect:/estados-civiles";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<EstadoCivil> estadoCivilOptional = estadoCivilService.getEstadoCivilById(id);

        if (estadoCivilOptional.isPresent()) {
            EstadoCivil estadoCivil = estadoCivilOptional.get();
            model.addAttribute("estadoCivil", estadoCivil);
            return "estadcivil/formulario";
        }

        return "redirect:/estados-civiles";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        estadoCivilService.deleteEstadoCivil(id);
        return "redirect:/estados-civiles";
    }
}

