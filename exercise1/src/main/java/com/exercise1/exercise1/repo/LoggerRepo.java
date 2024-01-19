package com.exercise1.exercise1.repo;

import com.exercise1.exercise1.entity.aop.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerRepo extends JpaRepository<Logger, Long> {
}
