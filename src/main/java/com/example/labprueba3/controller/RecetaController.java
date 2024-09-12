package com.example.labprueba3.controller;

import com.example.labprueba3.entity.Receta;
import com.example.labprueba3.repository.RecetaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/receta")
public class RecetaController {

    final RecetaRepository recetaRepository;
    public RecetaController(RecetaRepository recetaRepository) {
        this.recetaRepository = recetaRepository;
    }
    @GetMapping(value={"/list", ""})
    public String listarRecetas(Model model) {
        List<Receta> recetas = recetaRepository.findAll();
        model.addAttribute("recetas", recetas);
        return "receta/list";
    }

    @GetMapping("/new")
    public String nuevaRecetaForm(Model model) {
        model.addAttribute("receta", new Receta());
        return "receta/newFrm";
    }

    @PostMapping("/save")
    public String guardarReceta(Receta receta) {
        recetaRepository.save(receta);
        return "redirect:/receta/list";
    }
    @GetMapping("/edit")
    public String editarTransportista(Model model,
                                      @RequestParam("id") int id) {

        Optional<Receta> optReceta = recetaRepository.findById(id);

        if (optReceta.isPresent()) {
            Receta receta = optReceta.get();
            model.addAttribute("receta", receta);
            return "receta/editFrm";
        } else {
            return "redirect:/receta/list";
        }
    }

    @GetMapping("/delete")
    public String borrarTransportista(Model model,
                                      @RequestParam("id") int id) {

        Optional<Receta> optReceta = recetaRepository.findById(id);

        if (optReceta.isPresent()) {
            recetaRepository.deleteById(id);
        }
        return "redirect:/receta/list";

    }

}

