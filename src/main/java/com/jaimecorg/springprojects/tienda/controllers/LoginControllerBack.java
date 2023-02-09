/*
package com.jaimecorg.springprojects.tienda.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jaimecorg.springprojects.tienda.model.Usuario;

@Controller
public class LoginControllerBack {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(value = "/signin")
    public ModelAndView list(Model model){

        ModelAndView modelAndView = new ModelAndView("signin");

        return modelAndView;
    }

    @GetMapping(value = "/login")
    public String login(Model model, Usuario usuario, HttpSession session){

        usuario = new Usuario();
        usuario.setUsuario("Jaime");
        usuario.setPassword("hola");

        String message = messageSource.getMessage("saludar.usuario", new String[]{usuario.getUsuario()}, LocaleContextHolder.getLocale());
        model.addAttribute("greetings", message);
        
        session.setAttribute("usuario", usuario);

        return "login";
    }

    @GetMapping(value = {"/logout"})
    public String logout(Usuario usuario, HttpSession session){

        session.invalidate();

        return "signin";
    }

    @GetMapping(value = "/welcome")
    public ModelAndView welcome(Model model){
        ModelAndView modelAndView = new ModelAndView("welcome");

        return modelAndView;
    }

}
*/