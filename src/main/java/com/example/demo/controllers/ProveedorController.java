package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
=======
import org.springframework.web.bind.annotation.*;
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78

import com.example.demo.models.Proveedor;
import com.example.demo.models.Barrios;
import com.example.demo.services.ProveedorService;
import com.example.demo.services.BarriosService;

<<<<<<< HEAD

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = "/proveedores") 
=======
import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = "/proveedor")
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
@AllArgsConstructor
public class ProveedorController {

    private final ProveedorService proveedorService;
    private final BarriosService barriosService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("proveedores", proveedorService.getAllProveedores());
<<<<<<< HEAD
        return "proveedores/listar"; 
=======
        return "proveedor/listar";
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        List<Barrios> barrios = barriosService.getAlls();
        model.addAttribute("barrios", barrios);
<<<<<<< HEAD
        return "proveedores/formulario"; 
=======
        return "proveedor/formulario";
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Proveedor proveedor) {
        proveedorService.saveProveedor(proveedor);
<<<<<<< HEAD
        return "redirect:/proveedores"; 
=======
        return "redirect:/proveedor";
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Proveedor> proveedorOptional = proveedorService.getProveedorById(id);

        if (proveedorOptional.isPresent()) {
            model.addAttribute("proveedor", proveedorOptional.get());
            List<Barrios> barrios = barriosService.getAlls();
            model.addAttribute("barrios", barrios);
<<<<<<< HEAD
            return "proveedor/formulario"; 
        }

        return "redirect:/proveedores"; 
=======
            return "proveedor/formulario";
        }

        return "redirect:/proveedor";
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        proveedorService.deleteProveedor(id);
<<<<<<< HEAD
        return "redirect:/proveedores"; 
    }
}
=======
        return "redirect:/proveedor";
    }
}

>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
