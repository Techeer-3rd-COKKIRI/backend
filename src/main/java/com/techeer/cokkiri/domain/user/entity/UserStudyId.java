package com.techeer.cokkiri.domain.user.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserStudyId implements Serializable {
  private Long user;
  private Long study;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserStudyId userStudyId = (UserStudyId) o;
    return Objects.equals(getUser(), userStudyId.getUser())
        && Objects.equals(getStudy(), userStudyId.getStudy());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getUser(), getStudy());
  }
}
