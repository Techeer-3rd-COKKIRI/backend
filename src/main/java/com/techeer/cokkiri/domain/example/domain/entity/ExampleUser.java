package com.techeer.cokkiri.domain.example.domain.entity;

import com.techeer.cokkiri.global.domain.BaseEntity;
import javax.persistence.*;
import lombok.*;

@Getter
@Entity
// JPA는 기본 생성자가 필요함. but public이면 아무데서나 호출 가능
// -> 접근 제한자를 protected로 설정
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "EXAMPLE_USER")
public class ExampleUser extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "EXAMPLE_USER_ID")
  private Long id;

  @Column(name = "NAME", nullable = false, length = 30)
  private String name;

  // 모든 연관관계는 지연로딩으로 설정
  // 즉시로딩은 예측이 어렵고, JPQL실행시 n+1이슈 발생 가능
  // @ManyToOne(fetch = FetchType.LAZY)
  // @JoinColumn(name = "DEPARTMENT", nullable = false)
  // private Department department;

  @Builder
  public ExampleUser(String name) {
    this.name = name;
    super.isDeleted = false;
  }
}
