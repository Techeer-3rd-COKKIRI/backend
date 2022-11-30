package com.techeer.cokkiri.domain.example.domain.entity;

import com.techeer.cokkiri.global.domain.BaseEntity;
import javax.persistence.*;
import lombok.*;

import java.sql.Date;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "STUDY")
public class Study extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDY_ID")
    private Long id;

    @Column(name = "MANAGER_ID", nullable = false)
    private Long managerId;

    @Column(name = "STUDY_NAME", nullable = false, length = 30)
    private String studyName;

    @Column(name = "STUDY_PASSWORD", nullable = false)
    private String studyPassword;

    @Column(name = "USER_LIMIT", nullable = false)
    private Integer userLimit;

    @Column(name = "INTRODUCTION", length = 255)
    private String introduction;

    @Column(name = "STUDY_CYCLE", nullable = false)
    private Integer studyCycle;

    @Column(name = "START_DATE", nullable = false)
    private Date startDate;

    @Column(name = "FINISH_DATE", nullable = false)
    private Date finishDate;

    @OneToMany(mappedBy = "STUDY")
    @JoinColumn(name = "STUDY_TAG", nullable = false)
    private StudyTag studyTag;

    @OneToMany(mappedBy = "STUDY")
    @JoinColumn(name = "USER_STUDY", nullable = false)
    private StudyTag studyTag;

    @Builder
    public Study(Long managerId, String studyName, String studyPassword, String studyTag, Integer userLimit, String introduction, Integer studyCycle,
                 Date startDate, Date finishDate) {
        this.managerId = managerId;
        this.studyName = studyName;
        this.studyPassword = studyPassword;
        this.userLimit = userLimit;
        this.introduction = introduction;
        this.studyCycle = studyCycle;
        this.startDate = startDate;
        this.finishDate = finishDate;
        super.isDeleted = false;
    }
}