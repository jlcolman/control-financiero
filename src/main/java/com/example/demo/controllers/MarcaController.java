package com.example.demo.controllers;

import com.example.demo.models.Marca;
import com.example.demo.services.MarcaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/marcas")
@AllArgsConstructor
public class MarcaController {

    private final MarcaService marcaService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("marcas", marcaService.getAllMarcas());
        return "marcas/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("marca", new Marca());
        return "marcas/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Marca marca) {
        marcaService.saveMarca(marca);
        return "redirect:/marcas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Marca> marcaOptional = marcaService.getMarcaById(id);

        if (marcaOptional.isPresent()) {
            Marca marca = marcaOptional.get();
            model.addAttribute("marca", marca);
            return "marcas/formulario";
        }

        return "redirect:/marcas";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        marcaService.deleteMarca(id);
        return "redirect:/marcas";
    }
}
