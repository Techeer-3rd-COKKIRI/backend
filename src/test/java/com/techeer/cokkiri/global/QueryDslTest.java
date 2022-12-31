package com.techeer.cokkiri.global;

import static com.techeer.cokkiri.fixture.UserFixtures.STUDY_MANAGER_FIXTURE;
import static org.junit.jupiter.api.Assertions.*;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.techeer.cokkiri.domain.user.entity.QUser;
import com.techeer.cokkiri.domain.user.entity.User;
import com.techeer.cokkiri.domain.user.repository.UserRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class QueryDslTest {
  @Autowired private UserRepository userRepository;
  @Autowired private JPAQueryFactory jpaQueryFactory;

  @Test
  @Transactional
  void queryDslTest() {
    userRepository.save(STUDY_MANAGER_FIXTURE);
    userRepository.save(STUDY_MANAGER_FIXTURE);

    QUser qUser = new QUser("u");

    List<User> users =
        jpaQueryFactory
            .selectFrom(qUser)
            .where(qUser.username.eq(STUDY_MANAGER_FIXTURE.getUsername()))
            .fetch();
    assertEquals(STUDY_MANAGER_FIXTURE.getUsername(), users.get(0).getUsername());
  }
}
