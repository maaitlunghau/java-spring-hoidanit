package vn.hoidanit.springsieutoc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${maaitlunghau.secret:default-value}")
    public String mySecret;

    @GetMapping("/")
    public String index() { // RestController
        return "Hello World from Spring Boot - " + this.mySecret;
    }

    @GetMapping("/dev")
    public String maaitlunghau() {
        return "Hello maaitlunghau";
    }
}
