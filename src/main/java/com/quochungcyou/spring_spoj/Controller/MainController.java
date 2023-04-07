package com.quochungcyou.spring_spoj.Controller;

import com.quochungcyou.spring_spoj.APiUtils.JsoupHelper;
import com.quochungcyou.spring_spoj.Models.Player;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    List<Player> players = new ArrayList<>();

    @RequestMapping(value = "/")
    public List<Player> getUserData() {
        JsoupHelper jsoupHelper = new JsoupHelper();
        players = jsoupHelper.getData();
        return ResponseEntity.ok(players).getBody();
    }


}
