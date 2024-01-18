package com.ReactiveMusicApp.UI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowUiController {

    @GetMapping("/home")
        String showHome(){
        return "SZUKANIE";
    }

    @GetMapping("/search")
        String showSearch(){
        return "Search";
    }
}
