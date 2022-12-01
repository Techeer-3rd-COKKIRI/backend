package com.techeer.cokkiri.domain.comment.domain.entity;

import com.techeer.cokkiri.global.domain.BaseEntity;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Getter
@Entity
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table
public class Comment extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Long userId;

  @Column(nullable = false)
  private Long studyId;

  @Column(name = "COMMENT_ADDRESS", length = 255, nullable = false)
  private String commentAddress;

  @Column(name = "STUDY_WEEK")
  private Integer studyWeek;

  @Column(name = "LIKE")
  @ColumnDefault("0")
  private Integer likeCount;

  @Column(name = "DISLIKE")
  @ColumnDefault("0")
  private Integer dislikeCount;

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
      Integer likeCount,
      Integer dislikeCount,
      Boolean isNoticed) {
    this.userId = userId;
    this.studyId = studyId;
    this.commentAddress = commentAddress;
    this.studyWeek = studyWeek;
    this.likeCount = likeCount;
    this.dislikeCount = dislikeCount;
    this.isNoticed = isNoticed;
  }
}
