package org.taerock.boottest.repository.search;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.taerock.boottest.entity.Board;
import org.taerock.boottest.entity.QBoard;

import java.util.List;

@Log4j2
public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch {

    public BoardSearchImpl() {
        super(Board.class);
    }

    @Override
    public void search1(Pageable pageable) {

        log.info("search1.........................");

        //Qdomain의 값을 선언
        QBoard board = QBoard.board;

        //QuerydslRepositorySupport의 from 메소느는 JPQLQuery 탑입을 만들어 줄 수 있음
        JPQLQuery<Board> query = from(board);

        getQuerydsl().applyPagination(pageable, query);

        query.fetchCount();

        //query문 가져오기
        query.fetch();


    }

    @Override
    public Page<Board> searchAll(String[] types, String keyword, Pageable pageable) {

        QBoard board = QBoard.board;
        JPQLQuery<Board> query = from(board);

        // 검색 시 필수 조건 1 검색 대상
        if (types != null) {
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            for (String type : types) {
                if (type.equals("t")) {
                    booleanBuilder.or(board.title.contains(keyword));
                } else if (type.equals("c")) {
                    booleanBuilder.or(board.content.contains(keyword));
                } else if (type.equals("w")) {
                    booleanBuilder.or(board.writer.contains(keyword));
                }
            }//end for
            query.where(booleanBuilder);
        }//end if
        // 검색 시 필수 조건 2 bno>0
        query.where(board.bno.gt(0));

        //페이징 처리
        getQuerydsl().applyPagination(pageable, query);

        List<Board> list = query.fetch();

        long count = query.fetchCount();

        return new PageImpl<>(list,pageable,count);
    }

}
