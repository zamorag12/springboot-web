package org.web.controller;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.context.i18n.LocaleContextHolder.getLocale;

@Controller
public class HelloController {
    private final MessageSource messageSource;

    public HelloController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }


    @GetMapping("/hello")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        final String greeting = messageSource.getMessage("view.greeting", null, getLocale());

        final String businessMessage = messageSource.getMessage("business.test-message", null, getLocale());
        final String validationMessage = messageSource.getMessage("validation.test-message", null, getLocale());


        model.addAttribute("greeting", greeting);
        model.addAttribute("businessMessage", businessMessage);
        model.addAttribute("validationMessage", validationMessage);
        model.addAttribute("name", name);

        return name.equals("patito") ? "index" : "hello";
    }

}
