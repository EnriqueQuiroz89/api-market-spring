package com.mexicode.market;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludar")  //Bajo que Path va a responder
public class HolaMundoController {

    @GetMapping("/hola")
public String saludar(){
        return "Nunca pares de aprender";
}

}
