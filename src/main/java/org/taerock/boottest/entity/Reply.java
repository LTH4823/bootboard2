package org.taerock.boottest.entity;

import lombok.*;

import javax.persistence.*;

//독립적 entity
@Entity
@Table(name = "t_reply")
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reply extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    private String replyText;

    private String replyer;

    @ManyToOne
    //단방향 참조
    private Board board;

}
