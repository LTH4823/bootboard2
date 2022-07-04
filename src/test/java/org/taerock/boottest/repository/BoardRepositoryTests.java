package org.taerock.boottest.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.taerock.boottest.entity.Board;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
//기존 Spring 방식에 비하여 간단한 설정
@Log4j2
public class BoardRepositoryTests {

    //의존성 주입
    @Autowired
    private BoardRepository repository;

    @Test
    public void testInsert() {

        //log
        log.info("====================================");
        log.info("====================================");
        log.info(repository);
        log.info("====================================");

        //테스트 데이터 생성
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Board board = Board.builder()
                    .title("Title..." + i)
                    .content("Content..." + i)
                    .writer("User..." + (i % 10))
                    .build();

            //실행되는 테스트 쿼리문 적용
            repository.save(board);
        });

    }


    @Test
    public void testRead(){

        Integer bno = 100;

        //NPE 방지를 위해 사용하는 타입
        Optional<Board> result = repository.findById(bno);

        Board board = result.get();

        log.info(board);

    }




}
