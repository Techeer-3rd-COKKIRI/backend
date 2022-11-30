package com.techeer.cokkiri.domain.example.domain.entity;

import com.techeer.cokkiri.global.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "USER")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    // 회원 아이디
    @Column(name = "USERNAME", nullable = false, length = 30)
    private String username;

    @Column(name = "NICKNAME", nullable = false, length = 30)
    private String nickname;

    @Column(name = "USER_PASSWORD", nullable = false, length = 255)
    private String password;

    @Column(name = "USER_IMAGE_URL", length = 255)
    private String imageUrl;

    @Column(name = "USER_BIO", length = 255)
    private String bio;


    // Study와의 다대다 관계 -> 1:N으로 나눠서 구현
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Study> study = new ArrayList<>();

    // Command과의 일대다 관계
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Command> command = new ArrayList<>();



    @Builder
    public User(String username, String nickname, String password, String imageUrl, String bio) {
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.imageUrl = imageUrl;
        this.bio = bio;

        super.isDeleted = false;
    }
}