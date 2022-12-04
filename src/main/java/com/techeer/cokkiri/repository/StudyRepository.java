package com.techeer.cokkiri.repository;

import com.techeer.cokkiri.domain.example.domain.entity.Study;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudyRepository extends JpaRepository<Study, Long> {


}
