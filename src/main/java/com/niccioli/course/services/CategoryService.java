package com.niccioli.course.services;

import com.niccioli.course.entities.Category;
import com.niccioli.course.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Long id){
         Optional<Category> category = repository.findById(id);
         return category.get();
    }
}
