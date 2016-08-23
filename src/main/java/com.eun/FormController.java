package com.eun;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class FormController extends WebMvcConfigurerAdapter {

    //@Override
    //public void addViewControllers(ViewControllerRegistry registry) {
    //    registry.addViewController("/result").setViewName("result");
    //}

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String displayForm(Form form) {
        return "form";
    }

    @RequestMapping (value="/", method=RequestMethod.POST)
    public String validateForm (@Valid Form form, BindingResult bindingResult) {

        if (!isValidString(form.getAddress(), "[^\\p{L}0-9. ]")) {
            //bindingResult.addError(new FieldError("form", "address", "Invalid address format"));
        }

        if (form.getApt() != null) {
            if (!isValidString(form.getApt(), "[^a-zA-Z0-9#]")) {
                bindingResult.addError(new FieldError("form", "apt", "Invalid apt/unit input"));
            }
        }

        if (!isValidString(form.getCity(), "[^\\p{L}]")) {
            bindingResult.addError(new FieldError("form", "city", "Invalid city input"));
        }

        if (bindingResult.hasErrors()) {
            return "form";
        }

        return "redirect:/result";
    }

    @RequestMapping (value="/result", method=RequestMethod.GET)
    public String getResult () {
        return "result";
    }

    private boolean isValidString (String value, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher cmp = p.matcher(value);

        if (cmp.find()) {
            return false;
        }

        return true;
    }
}
