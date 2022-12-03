package com.techeer.cokkiri.domain.user.entity;

import javax.persistence.*;
import com.techeer.cokkiri.global.entity.BaseEntity;
import lombok.*;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserStudy extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "USER_STUDY_ID")
  private Long id;

  @Column(name = "IS_END", columnDefinition = "boolean default false")
  private Boolean isEnd;

  // User와 다대다를 N:1로 나눠서 구현
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "USER_ID", insertable = false, updatable = false, nullable = false)
  private User user;

  // Study와 다대다를 N:1로 나눠서 구현
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "STUDY_ID", insertable = false, updatable = false, nullable = false)
  private Study study;

  @Builder
  private UserStudy(Boolean isEnd) {
    this.isEnd = isEnd;
  }
}
