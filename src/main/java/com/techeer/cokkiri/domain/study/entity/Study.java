package com.techeer.cokkiri.domain.study.entity;

import com.techeer.cokkiri.domain.user.entity.User;
import com.techeer.cokkiri.domain.user.entity.UserStudy;
import com.techeer.cokkiri.global.entity.BaseEntity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "STUDIES")
public class Study extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "study_id")
  private Long id;

  @OneToOne
  @JoinColumn(name = "manager_id", nullable = false)
  private User manager;

  // User와의 다대다 관계 -> 1:N으로 나눠서 구현
  @OneToMany(mappedBy = "study", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<UserStudy> users = new ArrayList<>();

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
      User manager,
      String studyName,
      String studyPassword,
      Integer userLimit,
      String introduction,
      Integer studyCycle,
      LocalDate startDate,
      LocalDate finishDate) {
    this.manager = manager;
    this.studyName = studyName;
    this.studyPassword = studyPassword;
    this.userLimit = userLimit;
    this.introduction = introduction;
    this.studyCycle = studyCycle;
    this.startDate = startDate;
    this.finishDate = finishDate;
  }

  public Integer getStudyUserCount() {
    return users.size();
  }
}
