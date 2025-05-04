package com.example.demo.controllers;

import com.example.demo.models.Empleado;
import com.example.demo.services.EmpleadoService;
import com.example.demo.models.Barrios;
import com.example.demo.models.Nacionalidad;
import com.example.demo.models.Usuarios;
import com.example.demo.models.EstadoCivil;

import com.example.demo.services.BarriosService;
import com.example.demo.services.NacionalidadService;
import com.example.demo.services.UsuariosService;
import com.example.demo.services.EstadoCivilService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/empleados")
@AllArgsConstructor
public class EmpleadoController {

    private final EmpleadoService empleadoService;
    private final BarriosService barriosService;
    private final NacionalidadService nacionalidadService;
    private final UsuariosService usuariosService;
    private final EstadoCivilService estadoCivilService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("empleados", empleadoService.getAllEmpleados());
        return "empleados/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("empleado", new Empleado());
        List<Barrios> barrios = barriosService.getAlls();
        List<Nacionalidad> nacionalidades = nacionalidadService.getAllNacionalidades();
        List<Usuarios> usuarios = usuariosService.getAllUsuarios();
        List<EstadoCivil> estadosCiviles = estadoCivilService.getAllEstadoCivil();

        model.addAttribute("barrios", barrios);
        model.addAttribute("nacionalidades", nacionalidades);
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("estadosCiviles", estadosCiviles);

        return "empleados/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Empleado empleado) {
        empleadoService.saveEmpleado(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Empleado> empleadoOptional = empleadoService.getEmpleadoById(id);

        if (empleadoOptional.isPresent()) {
            Empleado empleado = empleadoOptional.get();
            model.addAttribute("empleado", empleado);

            List<Barrios> barrios = barriosService.getAlls();
            List<Nacionalidad> nacionalidades = nacionalidadService.getAllNacionalidades();
            List<Usuarios> usuarios = usuariosService.getAllUsuarios();
            List<EstadoCivil> estadosCiviles = estadoCivilService.getAllEstadoCivil();

            model.addAttribute("barrios", barrios);
            model.addAttribute("nacionalidades", nacionalidades);
            model.addAttribute("usuarios", usuarios);
            model.addAttribute("estadosCiviles", estadosCiviles);
            return "empleados/formulario";
        }

        return "redirect:/empleados";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        empleadoService.deleteEmpleado(id);
        return "redirect:/empleados";
    }
}
