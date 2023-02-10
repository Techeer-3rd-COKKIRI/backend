package com.techeer.cokkiri.domain.study.repository;

import static com.techeer.cokkiri.domain.user.entity.QUserStudy.userStudy;
import static com.techeer.cokkiri.domain.user.entity.QUser.user;
import static com.techeer.cokkiri.domain.study.entity.QStudy.study;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.techeer.cokkiri.domain.study.entity.Study;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudyCustomRepositoryImpl implements StudyCustomRepository {

  private final JPAQueryFactory queryFactory;

  @Override
  public Page<Study> getUserStudy(Long userId, Pageable pageable) {
    List<Study> studies = queryFactory
        .select(study)
        .from(userStudy)
        .leftJoin(userStudy.user, user)
        .leftJoin(userStudy.study, study)
        .where(user.id.eq(userId))
        .offset(pageable.getOffset())
        .limit(pageable.getPageSize())
        .fetch();
    return new PageImpl<>(studies, pageable, studies.size());
  }
}
