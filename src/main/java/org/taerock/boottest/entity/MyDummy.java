package org.taerock.boottest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MyDummy {

    @Id
    // @Entity 선언 시 반드시 id가 하나 필요 = 기본키 보면 된다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // autoincrement 적용
    private int mno;

    private String valueText;

}
