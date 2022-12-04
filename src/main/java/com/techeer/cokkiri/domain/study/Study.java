package com.techeer.cokkiri.domain.study;

import javax.persistence.*;
import com.techeer.cokkiri.global.entity.BaseEntity;
import lombok.*;
import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "STUDIES")
public class Study extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "study_id")
    private Long id;

    @Column(nullable = false)
    private Long managerId;

    @Column(nullable = false, length = 30)
    private String studyName;

    @Column(nullable = false)
    private String studyPassword;

    @Column(nullable = false)
    private Integer userLimit;

    @Column(length = 255)
    private String introduction;

    @Column(nullable = false)
    private Integer studyCycle;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate finishDate;


    @Builder
    public Study(
            Long managerId,
            String studyName,
            String studyPassword,
            Integer userLimit,
            String introduction,
            Integer studyCycle,
            LocalDate startDate,
            LocalDate finishDate) {
        this.managerId = managerId;
        this.studyName = studyName;
        this.studyPassword = studyPassword;
        this.userLimit = userLimit;
        this.introduction = introduction;
        this.studyCycle = studyCycle;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }
}