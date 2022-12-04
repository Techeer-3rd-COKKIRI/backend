package com.techeer.cokkiri.domain.comment.domain.entity;

import com.techeer.cokkiri.global.entity.BaseEntity;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

@Getter
@Entity
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
@Table(name = "comments")
public class Comment extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "comment_id")
  private Long id;

  @Column(nullable = false)
  private Long userId;

  @Column(nullable = false)
  private Long studyId;

  @Column(length = 255, nullable = false)
  private String commentAddress;

  private Integer studyWeek;

  @Column(columnDefinition = "int default 0")
  private Integer likeCount;

  @Column(columnDefinition = "int default 0")
  private Integer dislikeCount;

  private Boolean isNoticed;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "study_id", nullable = false)
  private Study study;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Builder
  private Comment(
      String commentAddress,
      Integer studyWeek,
      Integer likeCount,
      Integer dislikeCount,
      Boolean isNoticed) {
    this.commentAddress = commentAddress;
    this.studyWeek = studyWeek;
    this.likeCount = likeCount;
    this.dislikeCount = dislikeCount;
    this.isNoticed = isNoticed;
  }
}
