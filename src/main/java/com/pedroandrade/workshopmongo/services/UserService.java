package com.pedroandrade.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedroandrade.workshopmongo.domain.User;
import com.pedroandrade.workshopmongo.dto.UserDTO;
import com.pedroandrade.workshopmongo.repository.UserRepository;
import com.pedroandrade.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById (String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDto(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
}
