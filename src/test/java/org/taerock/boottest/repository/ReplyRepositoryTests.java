package org.taerock.boottest.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.taerock.boottest.entity.Board;
import org.taerock.boottest.entity.Reply;

import java.util.Optional;

@SpringBootTest
@Log4j2
public class ReplyRepositoryTests {

    @Autowired
    ReplyRepository replyRepository;

    @Test
    public void testInsert() {

        //JPA DB에서 제일 중요한 것은 PK
        Board board = Board.builder().bno(100).build();

        for (int i = 0; i < 100; i++) {

            Reply reply = Reply.builder()
                    .board(board)
                    .replyText(i+"번의 댓글 입니다.")
                    .replyer("replyer00")
                    .build();

            replyRepository.save(reply);

        }

    }

    @Test
    public void testRead(){

        Long rno = 99L;

        Optional<Reply> result = replyRepository.findById(rno);

        Reply reply = result.orElseThrow();

        log.info(reply);

    }


}
