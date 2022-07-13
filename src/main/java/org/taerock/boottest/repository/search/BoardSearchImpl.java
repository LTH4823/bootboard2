package org.taerock.boottest.repository.search;

import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.taerock.boottest.entity.Board;
import org.taerock.boottest.entity.QBoard;

@Log4j2
public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch{

    public BoardSearchImpl() {
        super(Board.class);
    }

    @Override
    public void search1() {

        log.info("search1.........................");

        //Qdomain의 값을 선언
        QBoard board = QBoard.board;

        //QuerydslRepositorySupport의 from 메소느는 JPQLQuery 탑입을 만들어 줄 수 있음
        JPQLQuery<Board> query = from(board);

        query.fetchCount();

        //query문 가져오기
        query.fetch();



    }

}
