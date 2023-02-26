package com.example.Nabiabad_high_school.modules.system.visitorlog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VisitorsLogRepository extends JpaRepository<VisitorsLog,Long>, JpaSpecificationExecutor<VisitorsLog> {
}
