package org.taerock.boottest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.taerock.boottest.entity.Board;
import org.taerock.boottest.repository.search.BoardSearch;

import java.util.List;

//JpaRepository CRUD를 포함한 기능 실행용
public interface BoardRepository extends JpaRepository<Board, Integer>, BoardSearch {

    //검색을 위한 선언 , 인텔리 얼티메이트이기에 자동완성식 찾기
    List<Board> findByTitleContaining(String keyword);

    Page<Board> findByTitleContaining(String keyword, Pageable pageable);

}
