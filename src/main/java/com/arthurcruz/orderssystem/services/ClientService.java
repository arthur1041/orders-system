package com.arthurcruz.orderssystem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arthurcruz.orderssystem.domain.Category;
import com.arthurcruz.orderssystem.domain.Client;
import com.arthurcruz.orderssystem.exceptions.ObjectNotFoundException;
import com.arthurcruz.orderssystem.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	public Client find(Integer id) {
		Optional<Client> clientObj = repository.findById(id);
		return clientObj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Category.class.getName()));
	}

}
