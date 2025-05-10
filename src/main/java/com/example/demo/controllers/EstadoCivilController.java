package com.example.demo.controllers;

import com.example.demo.models.EstadoCivil;
import com.example.demo.services.EstadoCivilService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
<<<<<<< HEAD
@RequestMapping(path = "/estadosciviles")
=======
@RequestMapping(path = "/estados-civiles")
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
@AllArgsConstructor
public class EstadoCivilController {

    private final EstadoCivilService estadoCivilService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("estadoscivil", estadoCivilService.getAllEstadoCivil());
<<<<<<< HEAD
        return "estadosciviles/listar";
=======
        return "estadosCiviles/listar";
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("estadoCivil", new EstadoCivil());
<<<<<<< HEAD
        return "estadosciviles/formulario";
=======
        return "estadosCiviles/formulario";
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute EstadoCivil estadoCivil) {
        estadoCivilService.saveEstadoCivil(estadoCivil);
<<<<<<< HEAD
        return "redirect:/estadosciviles";
=======
        return "redirect:/estados-civiles";
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<EstadoCivil> estadoCivilOptional = estadoCivilService.getEstadoCivilById(id);

        if (estadoCivilOptional.isPresent()) {
            EstadoCivil estadoCivil = estadoCivilOptional.get();
            model.addAttribute("estadoCivil", estadoCivil);
            return "estadcivil/formulario";
        }

<<<<<<< HEAD
        return "redirect:/estadosciviles";
=======
        return "redirect:/estados-civiles";
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        estadoCivilService.deleteEstadoCivil(id);
<<<<<<< HEAD
        return "redirect:/estadosciviles";
=======
        return "redirect:/estados-civiles";
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
    }
}

