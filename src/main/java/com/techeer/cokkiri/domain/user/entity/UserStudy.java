package com.techeer.cokkiri.domain.user.entity;

import com.techeer.cokkiri.domain.study.entity.Study;
import com.techeer.cokkiri.global.entity.BaseEntity;
import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

@Getter
@Entity
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@IdClass(UserStudyId.class)
public class UserStudy extends BaseEntity {
  // User와 다대다를 N:1로 나눠서 구현
  @Id
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", insertable = false, updatable = false, nullable = false)
  private User user;

  // Study와 다대다를 N:1로 나눠서 구현
  @Id
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "study_id", insertable = false, updatable = false, nullable = false)
  private Study study;

  @Column(columnDefinition = "boolean default false")
  private Boolean isEnd;

  @Builder
  private UserStudy(Boolean isEnd, User user, Study study) {
    this.isEnd = isEnd;
    this.user = user;
    this.study = study;
  }
}
