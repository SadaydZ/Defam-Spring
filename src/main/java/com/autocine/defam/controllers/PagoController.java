package com.autocine.defam.controllers;

import com.autocine.defam.model.Pago;
import com.autocine.defam.repositories.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/pago")
public class PagoController {

    @Autowired
    private PagoRepository pagoRepository;

    // Este método se llama al acceder a la página de pago
    @RequestMapping("")
    public String mostrarFormularioPago(Model model) {
        model.addAttribute("pago", new Pago());
        return "pago"; // Asegúrate de que el nombre coincida con tu archivo HTML
    }

    // Este método se llama cuando se envía el formulario de pago
    @PostMapping("")
    public String procesarPago(Pago pago, RedirectAttributes redirectAttributes) {
        // Aquí puedes realizar la lógica de procesamiento de pagos
        boolean pagoExitoso = true; // Cambia esto a la lógica real de pago

        if (pagoExitoso) {
            pagoRepository.save(pago); // Guarda el pago en la base de datos
            redirectAttributes.addFlashAttribute("mensaje", "Pago realizado con éxito!");
            return "redirect:/confirmacion-pago"; // Redirige a la página de confirmación
        } else {
            redirectAttributes.addFlashAttribute("error", "Error al procesar el pago.");
            return "redirect:/pago"; // Redirige a la página de pago en caso de error
        }
    }

    // Este método se llama para mostrar la página de confirmación
    @RequestMapping("/confirmacion-pago")
    public String mostrarConfirmacionPago(Model model) {
        // Aquí puedes agregar cualquier atributo que quieras mostrar en la página de confirmación
        return "pagina-confirmacion"; // Asegúrate de que el nombre coincida con tu archivo HTML
    }
}
