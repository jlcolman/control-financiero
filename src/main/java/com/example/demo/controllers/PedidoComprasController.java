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
import com.example.demo.models.PedidoCompras;
import com.example.demo.models.Proveedor;
import com.example.demo.models.Sucursales;
import com.example.demo.services.CondicionService;
import com.example.demo.services.EmpleadoService;
import com.example.demo.services.PedidoComprasService;
import com.example.demo.services.ProveedorService;
import com.example.demo.services.SucursalesService;

import lombok.AllArgsConstructor;

@Controller
<<<<<<< HEAD
@RequestMapping(path = { "pedidoscompra" })
=======
@RequestMapping(path = { "pedidos-compra" })
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
@AllArgsConstructor
public class PedidoComprasController {

	private PedidoComprasService pedidoComprasService;
	private ProveedorService proveedorService;
	private EmpleadoService empleadoService;
	private SucursalesService sucursalesService;
	private CondicionService condicionService;

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("pedidos", pedidoComprasService.getAlls());
<<<<<<< HEAD
		return "pedidoscompra/listar";
=======
		return "pedidos-compra/listar";
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
	}

	@GetMapping("/form")
	public String mostrarFormulario(Model model) {
		model.addAttribute("pedidoCompra", new PedidoCompras());
		List<Proveedor> proveedor = proveedorService.getAllProveedores();
		List<Empleado> empleado = empleadoService.getAllEmpleados();
		List<Sucursales> sucursales = sucursalesService.getAlls();
		List<Condicion> condiciones = condicionService.getAlls();
		model.addAttribute("proveedores", proveedor);
		model.addAttribute("empleados", empleado);
		model.addAttribute("sucursales", sucursales);
		model.addAttribute("condiciones", condiciones);
<<<<<<< HEAD
		return "pedidoscompra/formulario";
=======
		return "pedidos-compra/formulario";
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute PedidoCompras pedidoCompra) {
		pedidoComprasService.save(pedidoCompra);
<<<<<<< HEAD
		return "redirect:/pedidoscompra";
=======
		return "redirect:/pedidos-compra";
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Optional<PedidoCompras> pedidoCompra = pedidoComprasService.getById(id);
		List<Proveedor> proveedor = proveedorService.getAllProveedores();
		List<Empleado> empleado = empleadoService.getAllEmpleados();
		List<Sucursales> sucursales = sucursalesService.getAlls();
		List<Condicion> condiciones = condicionService.getAlls();

		if (pedidoCompra.isPresent()) {
			model.addAttribute("pedidoCompra", pedidoCompra.get());
			model.addAttribute("proveedor", proveedor);
			model.addAttribute("empleado", empleado);
			model.addAttribute("sucursales", sucursales);
			model.addAttribute("condiciones", condiciones);
<<<<<<< HEAD
			return "pedidoscompra/formulario";
		}

		return "redirect:/pedidoscompra";
=======
			return "pedidos-compra/formulario";
		}

		return "redirect:/pedidos-compra";
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
	}

	@PostMapping("/eliminar")
	public String eliminar(@RequestParam Long id) {
		pedidoComprasService.delete(id);
<<<<<<< HEAD
		return "redirect:/pedidoscompra";
=======
		return "redirect:/pedidos-compra";
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
	}
}
