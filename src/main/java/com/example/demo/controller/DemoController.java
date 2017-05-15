package com.example.demo.controller;

import com.example.demo.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Administrator on 2017/5/14 0014.
 */
@Controller
@RequestMapping("/")
public class DemoController {

    @GetMapping
    public String home() {
        return "home";
    }

    @PostMapping("/save")
    @ResponseBody
    public String save(@Valid Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            String errorMessage = allErrors.get(0).getDefaultMessage();
            return errorMessage;
        }
        return "ok";
    }
}
