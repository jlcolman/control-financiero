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

import com.example.demo.models.Ciudad;
import com.example.demo.models.Departamento; 
import com.example.demo.services.CiudadService;
import com.example.demo.services.DepartamentoService; 

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = "/ciudad")
@AllArgsConstructor
public class CiudadController {

    private CiudadService ciudadService;
    private DepartamentoService departamentoService; 

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("ciudad", ciudadService.getAllCiudades());
        return "ciudad/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("ciudad", new Ciudad());
        List<Departamento> departamentos = departamentoService.getAllDepartamentos(); 
        model.addAttribute("departamento", departamentos); 
        return "ciudad/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Ciudad ciudad) {

        ciudadService.saveCiudades(ciudad);
        return "redirect:/ciudad";
    }
    

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Ciudad> ciudadOptional = ciudadService.getCiudadById(id);

        if (ciudadOptional.isPresent()) {
            Ciudad ciudad = ciudadOptional.get();
            model.addAttribute("ciudad", ciudad);
            List<Departamento> departamentos = departamentoService.getAllDepartamentos(); 
            model.addAttribute("departamento", departamentos); 
            return "ciudad/formulario";
        }

        return "redirect:/ciudad";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        ciudadService.deleteCiudad(id);
        return "redirect:/ciudad";
    }
}
