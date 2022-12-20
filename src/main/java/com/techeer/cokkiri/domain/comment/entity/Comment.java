package com.techeer.cokkiri.domain.comment.entity;

import com.techeer.cokkiri.domain.study.entity.Study;
import com.techeer.cokkiri.domain.user.entity.User;
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

/*  @Column(length = 255, nullable = false)
  private String commentAddress;*/

  @Column(nullable = false)
  private String content;

  @Column(nullable = false)
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
      //String commentAddress,
      String content,
      Integer studyWeek,
      Integer likeCount,
      Integer dislikeCount,
      Boolean isNoticed,
      User user,
      Study study) {
    //this.commentAddress = commentAddress;
    this.content = content;
    this.studyWeek = studyWeek;
    this.likeCount = likeCount;
    this.dislikeCount = dislikeCount;
    this.isNoticed = isNoticed;
    this.user = user;
    this.study = study;
  }
}
