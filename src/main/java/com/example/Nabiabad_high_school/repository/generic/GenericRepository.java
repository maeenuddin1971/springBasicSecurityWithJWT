package com.example.Nabiabad_high_school.repository.generic;

import com.example.Nabiabad_high_school.entity.system.baseEnitiy.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericRepository <T extends BaseEntity> extends JpaRepository<T, Long> {
}
