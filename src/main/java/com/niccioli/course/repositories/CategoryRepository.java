package com.niccioli.course.repositories;

import com.niccioli.course.entities.Category;
import com.niccioli.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
