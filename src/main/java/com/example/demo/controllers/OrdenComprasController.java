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

import com.example.demo.models.Condicion;
import com.example.demo.models.Empleado;
import com.example.demo.models.OrdenCompras;
import com.example.demo.models.PresupuestoCompras;
import com.example.demo.models.Proveedor;
import com.example.demo.models.Sucursales;
import com.example.demo.services.CondicionService;
import com.example.demo.services.EmpleadoService;
import com.example.demo.services.OrdenComprasService;
import com.example.demo.services.PresupuestoComprasService;
import com.example.demo.services.ProveedorService;
import com.example.demo.services.SucursalesService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = { "ordenes-compra" })
@AllArgsConstructor
public class OrdenComprasController {

	private OrdenComprasService ordenComprasService;
	private PresupuestoComprasService presupuestoComprasService;
	private ProveedorService proveedorService;
	private EmpleadoService empleadoService;
	private SucursalesService sucursalesService;
	private CondicionService condicionService;

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("ordenes", ordenComprasService.getAlls());
		return "ordenes-compra/listar";
	}

	@GetMapping("/form")
	public String mostrarFormulario(Model model) {
		model.addAttribute("ordenCompra", new OrdenCompras());
		List<PresupuestoCompras> presupuestosCompra = presupuestoComprasService.getAlls();
		List<Proveedor> proveedor = proveedorService.getAllProveedores();
		List<Empleado> empleado = empleadoService.getAllEmpleados();
		List<Sucursales> sucursales = sucursalesService.getAlls();
		List<Condicion> condiciones = condicionService.getAlls();
		model.addAttribute("presupuestosCompra", presupuestosCompra);
		model.addAttribute("proveedores", proveedor);
		model.addAttribute("empleados", empleado);
		model.addAttribute("sucursales", sucursales);
		model.addAttribute("condiciones", condiciones);
		return "ordenes-compra/formulario";
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute OrdenCompras ordenCompra) {
		ordenComprasService.save(ordenCompra);
		return "redirect:/ordenes-compra";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Optional<OrdenCompras> ordenCompra = ordenComprasService.getById(id);
		List<PresupuestoCompras> presupuestosCompra = presupuestoComprasService.getAlls();
		List<Proveedor> proveedores = proveedorService.getAllProveedores();
		List<Empleado> empleados = empleadoService.getAllEmpleados();
		List<Sucursales> sucursales = sucursalesService.getAlls();
		List<Condicion> condiciones = condicionService.getAlls();

		if (ordenCompra.isPresent()) {
			model.addAttribute("ordenCompra", ordenCompra.get());
			model.addAttribute("presupuestosCompra", presupuestosCompra);
			model.addAttribute("proveedores", proveedores);
			model.addAttribute("empleados", empleados);
			model.addAttribute("sucursales", sucursales);
			model.addAttribute("condiciones", condiciones);
			return "ordenes-compra/formulario";
		}

		return "redirect:/ordenes-compra";
	}

	@PostMapping("/eliminar")
	public String eliminar(@RequestParam Long id) {
		ordenComprasService.delete(id);
		return "redirect:/ordenes-compra";
	}
}
