package com.arthurcruz.orderssystem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arthurcruz.orderssystem.domain.Category;
import com.arthurcruz.orderssystem.exceptions.ObjectNotFoundException;
import com.arthurcruz.orderssystem.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	public Category find(Integer id) {
		Optional<Category> categoryObj = repository.findById(id);
		return categoryObj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Category.class.getName()));
	}

}
