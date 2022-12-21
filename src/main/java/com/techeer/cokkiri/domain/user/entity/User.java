package com.techeer.cokkiri.domain.user.entity;

import com.techeer.cokkiri.domain.comment.entity.Comment;
import com.techeer.cokkiri.global.entity.BaseEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "USERS")
public class User extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "user_id")
  private Long id;

  // 회원 아이디
  @Column(nullable = false, unique = true, length = 30)
  private String username;

  @Column(nullable = false, length = 30)
  private String nickname;

  @Column(nullable = false, length = 255)
  private String password;

  @Column(length = 255)
  private String imageUrl;

  @Column(length = 255)
  private String bio;

  // Study와의 다대다 관계 -> 1:N으로 나눠서 구현
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<UserStudy> studies = new ArrayList<>();

  // Command과의 일대다 관계
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Comment> comments = new ArrayList<>();

  @Builder
  private User(String username, String nickname, String password, String bio) {
    this.username = username;
    this.nickname = nickname;
    this.password = password;
    this.bio = bio;
  }

  public void setEncryptedPassword(String encryptedPassword) {
    this.password = encryptedPassword;
  }
}
