package com.liveeasy.load.Repository;

import com.liveeasy.load.Model.Load;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoadRepository extends JpaRepository<Load, Long> {
}
