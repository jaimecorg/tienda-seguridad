package com.jaimecorg.springprojects.tienda.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jaimecorg.springprojects.tienda.model.Nota;
import com.jaimecorg.springprojects.tienda.services.NotasService;

@Controller
@RequestMapping("/notas")
public class NotaController {

    @Autowired
    NotasService notasService;

    @GetMapping(value = "/list")
    public ModelAndView listPage(Model model) {

        List<Nota> notas = notasService.findAll();

        ModelAndView modelAndView = new ModelAndView("notas/list");
        modelAndView.addObject("notas", notas);

        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView create(Nota notas) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("nota", new Nota());
        modelAndView.setViewName("notas/create");

        return modelAndView;
    }

    @PostMapping(path = "/save")
    public ModelAndView save(Nota notas) throws IOException {

        Nota ca = notasService.insert(notas);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + ca.getId());

        return modelAndView;
    }

    @GetMapping(path = { "/edit/{id}" })
    public ModelAndView edit(@PathVariable(name = "id", required = true) int id) {

        Nota notas = notasService.findByID(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("notas", notas);
        modelAndView.setViewName("notas/edit");

        return modelAndView;
    }

    @PostMapping(path = { "/update" })
    public ModelAndView update(Nota notas) {

        notasService.update(notas);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + notas.getId());

        return modelAndView;
    }

    @GetMapping(path = { "/delete/{id}" })
    public ModelAndView delete(
            @PathVariable(name = "id", required = true) int id) {

        notasService.delete(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/notas/list");

        return modelAndView;
    }

    @GetMapping(value="/buscar")
    public ModelAndView findByTituloYFecha(@RequestParam("titulo") String titulo,
        @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") Date fecha) {

        List<Nota> notasEncontradas = notasService.findByTituloYFecha(titulo, fecha);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("notas", notasEncontradas);
        modelAndView.setViewName("notas/list");
        
        return modelAndView;
    }
}
