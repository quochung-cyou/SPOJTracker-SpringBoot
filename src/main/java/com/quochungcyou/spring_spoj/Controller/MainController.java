package com.quochungcyou.spring_spoj.Controller;

import com.quochungcyou.spring_spoj.MainApp;
import com.quochungcyou.spring_spoj.Models.Player;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class MainController {


    @RequestMapping(value = "/")
    public String getUserData(Model model) {
        List<Player> players = MainApp.jsoupHelper.getData();
        model.addAttribute("players", players);
        return "home";

    }


}
