package com.canasta.controller;

import com.canasta.model.Mensaje;
import com.canasta.repository.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
public class ContactoController {

    @Autowired
    private MensajeRepository mensajeRepository;

    @GetMapping("/contacto")
    public String mostrarFormulario(Model model) {
        model.addAttribute("mensaje", new Mensaje());
        return "contacto";
    }

    @PostMapping("/contacto")
    public String enviarMensaje(@Valid @ModelAttribute("mensaje") Mensaje mensaje,
                                BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            return "contacto"; // vuelve al formulario con errores
        }

        mensajeRepository.save(mensaje);
        model.addAttribute("exito", "Tu mensaje fue enviado correctamente.");
        model.addAttribute("mensaje", new Mensaje()); // limpia el formulario
        return "contacto";
    }
}
