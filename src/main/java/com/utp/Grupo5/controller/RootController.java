package com.utp.Grupo5.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RootController {

    @GetMapping("/")
    public Map <String,String> welcome(){

        return Map.of(

                "status","online",
                    "message" , "Api de GRUPASO05  funcionando CORRECTAMENTE EN RENDER , ELLA NO TE AMAAAAA "
        );

    }
}
