package com.example.demo.controllers;

import com.example.demo.models.Mercaderia;
import com.example.demo.models.Marca;
import com.example.demo.models.TipoImpuesto;
import com.example.demo.services.MercaderiaService;
import com.example.demo.services.MarcaService;
import com.example.demo.services.TipoImpuestoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/mercaderias")
@AllArgsConstructor
public class MercaderiaController {

    private final MercaderiaService mercaderiaService;
    private final MarcaService marcaService;
    private final TipoImpuestoService tipoImpuestoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("mercaderias", mercaderiaService.getAllMercaderias());
        return "mercaderias/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("mercaderia", new Mercaderia());
        List<Marca> marcas = marcaService.getAllMarcas();
        List<TipoImpuesto> tipoImpuesto = tipoImpuestoService.getAllTiposImpuesto();
        model.addAttribute("marcas", marcas);
        model.addAttribute("tiposImpuesto", tipoImpuesto);
        return "mercaderias/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Mercaderia mercaderia) {
        mercaderiaService.saveMercaderia(mercaderia);
        return "redirect:/mercaderias";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Mercaderia> mercaderiaOptional = mercaderiaService.getMercaderiaById(id);

        if (mercaderiaOptional.isPresent()) {
            Mercaderia mercaderia = mercaderiaOptional.get();
            model.addAttribute("mercaderia", mercaderia);
            List<Marca> marcas = marcaService.getAllMarcas();
            List<TipoImpuesto> tipoImpuesto = tipoImpuestoService.getAllTiposImpuesto();
            model.addAttribute("marcas", marcas);
            model.addAttribute("tiposImpuesto", tipoImpuesto);
            return "mercaderias/formulario";
        }

        return "redirect:/mercaderias";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        mercaderiaService.deleteMercaderia(id);
        return "redirect:/mercaderias";
    }
}
