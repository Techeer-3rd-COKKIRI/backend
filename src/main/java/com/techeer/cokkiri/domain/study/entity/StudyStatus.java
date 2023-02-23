package com.techeer.cokkiri.domain.study.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StudyStatus {
    RECRUITING("모집 중"),
    IN_PROGRESS("진행 중"),
    FINISH("종료");

    private final String status;
}
