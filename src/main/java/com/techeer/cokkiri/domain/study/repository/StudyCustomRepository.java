package com.techeer.cokkiri.domain.study.repository;

import com.techeer.cokkiri.domain.study.entity.Study;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudyCustomRepository {
    Page<Study> getUserStudy(Long userId, Pageable pageable);
}
