package com.example.demo.controllers;

import com.example.demo.models.Nacionalidad;
import com.example.demo.services.NacionalidadService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/nacionalidades")
@AllArgsConstructor
public class NacionalidadController {

    private final NacionalidadService nacionalidadService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("nacionalidades", nacionalidadService.getAllNacionalidades());
        return "nacionalidades/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("nacionalidad", new Nacionalidad());
        return "nacionalidades/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Nacionalidad nacionalidad) {
        nacionalidadService.saveNacionalidad(nacionalidad);
        return "redirect:/nacionalidades";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Nacionalidad> nacionalidadOptional = nacionalidadService.getNacionalidadById(id);

        if (nacionalidadOptional.isPresent()) {
            Nacionalidad nacionalidad = nacionalidadOptional.get();
            model.addAttribute("nacionalidad", nacionalidad);
            return "nacionalidades/formulario";
        }

        return "redirect:/nacionalidades";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        nacionalidadService.deleteNacionalidad(id);
        return "redirect:/nacionalidades";
    }
}

