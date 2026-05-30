package vn.hoidanit.springsieutoc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String index() { // RestController
        return "Hello World from Spring Boot - maaitlunghau";
    }

    @GetMapping("/dev")
    public String maaitlunghau() {
        return "Hello maaitlunghau";
    }
}
