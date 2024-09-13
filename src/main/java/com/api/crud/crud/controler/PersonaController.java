package com.api.crud.crud.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.api.crud.crud.interfaceService.IpersonaService;
import com.api.crud.crud.modelo.Persona;

@Controller
public class PersonaController {

    @Autowired
    private IpersonaService service;

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Persona> personas = service.listar();
        model.addAttribute("personas", personas);
        return "index";
    }

    @GetMapping("/new")
    public String agregar(Model model) {
        model.addAttribute("persona", new Persona());
        return "/form";
    }

    @PostMapping("/save")
    public String save(Persona p, Model model) {
        service.save(p);
        return "redirect:/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<Persona> persona = service.listarId(id);
        if (persona.isPresent()) {
            model.addAttribute("persona", persona.get());
        } else {
            // Manejo del caso cuando la persona no se encuentra, redirige o muestra un mensaje de error
            model.addAttribute("error", "Persona no encontrada");
            return "redirect:/listar";
        }
        return "/form";
    }
    

    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "redirect:/listar";
    }
    

    
}
