package com.exercise1.exercise1.repo;

import com.exercise1.exercise1.entity.aop.ExceptionLogger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExceptionLoggerRepo extends JpaRepository<ExceptionLogger, Long> {
}
