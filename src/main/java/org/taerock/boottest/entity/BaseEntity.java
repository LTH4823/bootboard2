package org.taerock.boottest.entity;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {

    private LocalDateTime regDate;
    private LocalDateTime modDate;


}
