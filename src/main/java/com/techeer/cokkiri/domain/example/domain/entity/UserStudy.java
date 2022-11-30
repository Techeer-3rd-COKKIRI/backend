package com.techeer.cokkiri.domain.example.domain.entity;

import com.techeer.cokkiri.global.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "USER_STUDY")
public class UserStudy extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_STUDY_ID")
    private Long id;

    @Column(name = "IS_END", columnDefinition = "boolean default false")
    private boolean is_end;

    // User와 다대다를 N:1로 나눠서 구현
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID",  insertable=false, updatable=false, nullable = false)
    private User user;

    // Study와 다대다를 N:1로 나눠서 구현
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STUDY_ID",  insertable=false, updatable=false, nullable = false)
    private Study study;

    @Builder
    public UserStudy(boolean is_end) {
        this.is_end = is_end;

        super.isDeleted = false;
    }
}
