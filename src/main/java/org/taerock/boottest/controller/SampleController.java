package org.taerock.boottest.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/hello")
    public void hello(Model model){

        model.addAttribute("msg", "반갑습니다.");
        log.info("hello=======================");

    }

}
