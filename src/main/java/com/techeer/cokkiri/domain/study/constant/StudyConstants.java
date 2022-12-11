package com.techeer.cokkiri.domain.study.constant;

import java.time.LocalDate;

public class StudyConstants {
    public static final String DEFAULT_PASSWORD = "";
    public static final Integer DEFAULT_USER_LIMIT = 5;
    public static final String DEFAULT_INTRODUCTION = "";
    public static final Integer DEFAULT_STUDY_CYCLE = 7;
    public static final LocalDate DEFAULT_START_DATE = LocalDate.now();
    public static final LocalDate DEFAULT_FINISH_DATE = LocalDate.now().plusDays(28);
}
