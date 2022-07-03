package org.taerock.boottest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.taerock.boottest.entity.Board;

//JpaRepository CRUD를 포함한 기능 실행용
public interface BoardRepository extends JpaRepository<Board, Integer>{

}
