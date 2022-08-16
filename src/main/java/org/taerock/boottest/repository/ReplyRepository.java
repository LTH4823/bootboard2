package org.taerock.boottest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.taerock.boottest.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {



}
