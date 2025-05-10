package com.example.demo.controllers;

<<<<<<< HEAD
import com.example.demo.models.Ajustes;
import com.example.demo.models.Empleado;
import com.example.demo.models.Sucursales;
import com.example.demo.services.AjustesService;
import com.example.demo.services.EmpleadoService;
import com.example.demo.services.SucursalesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

=======
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.models.Ajustes;
import com.example.demo.models.AjustesDetalle;
import com.example.demo.services.AjustesService;
import com.example.demo.services.SucursalesService;
import com.example.demo.services.EmpleadoService;
import com.example.demo.services.MercaderiaService;

import lombok.AllArgsConstructor;

>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
@Controller
@RequestMapping(path = "/ajustes")
@AllArgsConstructor
public class AjustesController {

<<<<<<< HEAD
    private final AjustesService ajusteService;
    private final SucursalesService sucursalesService;
    private final EmpleadoService empleadoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("ajustes", ajusteService.getAll());
=======
    private AjustesService ajusteService; 
    private SucursalesService sucursalService; 
    private EmpleadoService empleadosService;
    private MercaderiaService mercaderiasService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("ajustes", ajusteService.findAll()); 
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
        return "ajustes/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
<<<<<<< HEAD
        model.addAttribute("ajuste", new Ajustes());
        List<Sucursales> sucursales = sucursalesService.getAlls();
        List<Empleado> empleados = empleadoService.getAllEmpleados();

        model.addAttribute("sucursales", sucursales);
        model.addAttribute("empleados", empleados);
        return "ajustes/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Ajustes ajuste) {
        ajusteService.save(ajuste);
        return "redirect:/ajustes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Ajustes> ajusteOptional = ajusteService.getById(id);

        if (ajusteOptional.isPresent()) {
            Ajustes ajuste = ajusteOptional.get();
            model.addAttribute("ajuste", ajuste);

            List<Sucursales> sucursales = sucursalesService.getAlls();
            List<Empleado> empleados = empleadoService.getAllEmpleados();

            model.addAttribute("sucursales", sucursales);
            model.addAttribute("empleados", empleados);
            return "ajustes/formulario";
=======

    	model.addAttribute("ajuste", new Ajustes()); 
        model.addAttribute("sucursales", sucursalService.findAll()); 
        model.addAttribute("empleados", empleadosService.findAll()); 
        model.addAttribute("detalleAjuses", new AjustesDetalle()); 

        return "ajustes/form"; 
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Ajustes ajuste) { 

        ajusteService.save(ajuste);

        return "redirect:/ajustes/editar/" + ajuste.getIdAjuste().toString(); 
    }


    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {

    	Optional<Ajustes> ajuste = ajusteService.findById(id); 

        if (ajuste.isPresent()) {

            model.addAttribute("ajuste", ajuste.get());
            model.addAttribute("sucursales", sucursalService.findAll()); 
            model.addAttribute("empleados", empleadosService.findAll()); 

            return "ajustes/form"; 
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
        }

        return "redirect:/ajustes";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        ajusteService.delete(id);
<<<<<<< HEAD
        return "redirect:/ajustes";
    }
=======

        return "redirect:/ajustes";

    }
    @PostMapping("/detalle")
    @ResponseBody
    public String guardarDetalle(@RequestParam(name = "id") Long idAjuste, @RequestBody List<AjusteDetalle> detalles)  {

    	Optional<Ajustes> ajusteOptional = this.ajusteService.findById(idAjuste); // Corrected method name
    	if (ajusteOptional.isPresent()) {
    		Ajustes ajuste = ajusteOptional.get();
    		
    		ajuste.agregarDetalles(detalles);
    		this.ajusteService.save(ajuste); 
    		return "Detalle guardado con exito";
    	} else {
    		return "Error: Ajuste no encontrado";
    	}
}
    @DeleteMapping("/detalle")
    @ResponseBody
    public String eliminarDetalle(@RequestParam Long ajusteId, @RequestParam Long mercaderiaId) {

    	ajusteService.deleteDetails(ajusteId, mercaderiaId); 

    	return "Proceso realizado con exito";
    }

>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
}