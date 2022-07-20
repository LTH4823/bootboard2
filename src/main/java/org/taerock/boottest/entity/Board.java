package org.taerock.boottest.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_board")
// 테이블명 지정
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
public class Board extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bno;

    @Column(length = 200, nullable = false)
    //사이즈 값과 not null 여부
    private String title;

    private String content;

    private String writer;

//    @CreationTimestamp
//    //하이버네이트에 있는 어노테이션 - 생성 시간
//    private LocalDateTime regDate;
//
//    @UpdateTimestamp
//    //하이버네이트에 있는 어노테이션
//    private LocalDateTime updateDate;

    //직접 선언해서 수정하는 방식  -> 문제 DB의 데이터와 객체 값이 불일치 되는 상황이 생길 수 있음 (주류 방식)
    public void changeTitle(String title){
        this.title = title;
    }

    public void changeContent(String content){
        this.content = content;
    }


}
