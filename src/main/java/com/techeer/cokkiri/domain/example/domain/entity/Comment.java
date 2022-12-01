package com.techeer.cokkiri.domain.example.domain.entity;

import com.techeer.cokkiri.global.domain.BaseEntity;
import javax.persistence.*;
import lombok.*;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "COMMENT")
public class Comment extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "COMMENT_ID")
  private Long id;

  @Column(name = "USER_ID", nullable = false)
  private Long userId;

  @Column(name = "STUDY_ID", nullable = false)
  private Long studyId;

  @Column(name = "COMMENT_ADDRESS", length = 255, nullable = false)
  private String commentAddress;

  @Column(name = "STUDY_WEEK")
  private Integer studyWeek;

  @Column(name = "LIKE")
  private Boolean likeCount;

  @Column(name = "DISLIKE")
  private Boolean dislikeCount;

  @Column(name = "IS_NOTICED")
  private Boolean isNoticed;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "STUDY_ID", nullable = false)
  private Study study;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "USER_ID", nullable = false)
  private User user;

  @Builder
  public Comment(
      Long userId,
      Long studyId,
      String commentAddress,
      Integer studyWeek,
      Boolean likeCount,
      Boolean dislikeCount) {
    this.userId = userId;
    this.studyId = studyId;
    this.commentAddress = commentAddress;
    this.studyWeek = studyWeek;
    this.likeCount = likeCount;
    this.dislikeCount = dislikeCount;

    super.isDeleted = false;
  }
}
