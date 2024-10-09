package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired //faz a injeção de dependência de forma transparente
	private UserRepository repository;
	
	public List<User> findAll(){
		return this.repository.findAll();
	}
	
	
	public User findById(Long id) {
		Optional<User> obj = this.repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return this.repository.save(obj);
	}
	
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
		
	}
	
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
