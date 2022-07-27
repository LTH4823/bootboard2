package org.taerock.boottest.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.taerock.boottest.dto.BoardDTO;
import org.taerock.boottest.dto.PageRequestDTO;
import org.taerock.boottest.dto.PageResponseDTO;
import org.taerock.boottest.service.BoardService;

import javax.validation.Valid;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/read")
    public void read(Integer bno, PageRequestDTO pageRequestDTO, Model model) {

        log.info("read bno: " + bno);
        log.info("read page: " + pageRequestDTO);

        BoardDTO boardDTO = boardService.readOne(bno);

        log.info("boardDTO: " + boardDTO);

        model.addAttribute("dto", boardDTO);

    }


    @GetMapping("register")
    public void registerGET() {

    }

    @PostMapping("register")
    //@Valid -> 검증 annotation , Binding -> 검증 결과 확인
    public String registerPost(@Valid BoardDTO boardDTO
            , BindingResult bindingResult
            , RedirectAttributes rttr) {

        log.info("board register: " + boardDTO);

        //hasErrors -> 결과에 대하여 어떠한 에러가 1개라도 나타난다면면
        if (bindingResult.hasErrors()) {
            log.info("has errors.....");
            rttr.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/board/register";
        }

        Integer bno = boardService.register(boardDTO);

        rttr.addFlashAttribute("result", bno);

        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {

        PageResponseDTO<BoardDTO> responseDTO = boardService.list(pageRequestDTO);

        log.info("===============================================");
        log.info(responseDTO);
        log.info("===============================================");

        model.addAttribute("responseDTO", responseDTO);

    }

}
