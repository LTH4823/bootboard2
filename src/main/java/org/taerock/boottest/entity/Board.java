package org.taerock.boottest.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_board")
// 테이브명 지정
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bno;

    @Column(length = 200, nullable = false)
    //사이즈 값과 not null 여부
    private String title;

    private String content;

    private String writer;

    @CreationTimestamp
    //하이버네이트에 있는 어노테이션 - 생성 시간
    private LocalDateTime regDate;

    @UpdateTimestamp
    //하이버네이트에 있는 어노테이션
    private LocalDateTime updateDate;

}
