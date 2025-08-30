package com.niccioli.course.services;

import com.niccioli.course.entities.User;
import com.niccioli.course.repositories.UserRepository;
import com.niccioli.course.services.exceptions.DatabaseException;
import com.niccioli.course.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
         Optional<User> user = repository.findById(id);
         return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user){
        return repository.save(user);
    }

    public void delete(Long id) {
        try {
            if (!repository.existsById(id)) {
                System.out.println("Erro: Usuário não encontrado!");
                throw new ResourceNotFoundException(id);
            }
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User user){
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, user);
            return repository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
