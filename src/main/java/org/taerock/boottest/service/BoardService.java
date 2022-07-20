package org.taerock.boottest.service;

import org.taerock.boottest.dto.BoardDTO;
import org.taerock.boottest.dto.PageRequestDTO;
import org.taerock.boottest.dto.PageResponseDTO;

public interface BoardService {

    Integer register(BoardDTO boardDTO);

    BoardDTO readOne(Integer bno);

    void modify(BoardDTO boardDTO);

    void remove(Integer bno);

    PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);

}
