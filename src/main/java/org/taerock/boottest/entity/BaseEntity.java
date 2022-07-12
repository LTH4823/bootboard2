package org.taerock.boottest.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
//더티체킹을 위한 설정
@EntityListeners(value = {AuditingEntityListener.class})
//엔티티는 Getter 위주로 설정한다.
@Getter
public class BaseEntity {

    //JPA 어노테이션

    @CreatedDate
    // 갱신 제한
    @Column(name = "regDate", updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    private LocalDateTime modDate;



}
