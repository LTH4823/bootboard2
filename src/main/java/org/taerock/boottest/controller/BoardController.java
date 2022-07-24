package org.taerock.boottest.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.taerock.boottest.dto.BoardDTO;
import org.taerock.boottest.dto.PageRequestDTO;
import org.taerock.boottest.dto.PageResponseDTO;
import org.taerock.boottest.service.BoardService;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){

        PageResponseDTO<BoardDTO> responseDTO = boardService.list(pageRequestDTO);

        log.info("===============================================");
        log.info(responseDTO);
        log.info("===============================================");

        model.addAttribute("responseDTO" , responseDTO);

    }

}
