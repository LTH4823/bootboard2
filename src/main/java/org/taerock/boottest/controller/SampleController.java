package org.taerock.boottest.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/hello")
    public void hello(Model model) {

        model.addAttribute("msg", "반갑습니다.");
        log.info("hello=======================");

    }

    @GetMapping("/ex1")
    public void ex1(Model model) {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        model.addAttribute("list", list);
    }

    @GetMapping("/ex2")
    public void ex2(Model model, RedirectAttributes rttr) {
        Map<String, String> map =
                Map.of("key1", "value1", "key2", "value2");

        model.addAttribute("result", map);

        List<String> list = IntStream.rangeClosed(10, 20).mapToObj(value -> "DATA--" + value).collect(Collectors.toList());

        model.addAttribute("list", list);
    }

}
