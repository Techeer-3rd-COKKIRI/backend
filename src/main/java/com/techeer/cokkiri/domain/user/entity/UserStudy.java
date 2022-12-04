package com.techeer.cokkiri.domain.user.entity;

import com.techeer.cokkiri.global.entity.BaseEntity;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

@Getter
@Entity
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserStudy extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "user_study_id")
  private Long id;

  @Column(columnDefinition = "boolean default false")
  private Boolean isEnd;

  // User와 다대다를 N:1로 나눠서 구현
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", insertable = false, updatable = false, nullable = false)
  private User user;

  // Study와 다대다를 N:1로 나눠서 구현
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "study_id", insertable = false, updatable = false, nullable = false)
  private Study study;

  @Builder
  private UserStudy(Boolean isEnd) {
    this.isEnd = isEnd;
  }
}
