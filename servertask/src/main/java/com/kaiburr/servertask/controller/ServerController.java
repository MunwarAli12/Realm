package com.kaiburr.servertask.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kaiburr.servertask.model.Server;
import com.kaiburr.servertask.repository.ServerRepository;
import com.kaiburr.servertask.utilities.ResponseMessage;

@RestController
public class ServerController {
	 
	@Autowired 
	private ServerRepository serverRepository; 
	
	
	@GetMapping("/findAllServers")
	public List<Server> getAllServers(){
		return this.serverRepository.getAllServers();
	}
	@GetMapping("/findServer/{id}")
	public Optional<Server> getServers(@PathVariable int id){
		return this.serverRepository.findById(id);
		//mapped
	}
		
	@GetMapping("/findServerByFramework/{framework}")
	public List<Server> getServersByFramework(@PathVariable String framework){
		return this.serverRepository.getServersByFramework(framework);
		//mapped
		
	}
	
	@GetMapping("/findServerByLanguage/{language}")
	public List<Server> getServersByLanguage(@PathVariable String language){
		return this.serverRepository.getServersByLanguage(language);
		//mapped
		
	}
	
	@GetMapping("/findServerByName/{name}")
	public List<Server> getServersByName(@PathVariable String name){
		return this.serverRepository.getServersByName(name);
		//mapped
	}
	
	@PutMapping("/findAllServers1")
	public List<Server> getAllServers1(){
		return this.serverRepository.findAll();
	}
	
	@PostMapping("/addServer")
	public ResponseEntity<?> saveServer(@RequestBody Server server) {
	    return serverRepository.findById(server.getId()).isPresent() ? ResponseEntity.badRequest().body("Server with ID " + server.getId() + " already exists") : ResponseEntity.ok(serverRepository.save(server) != null ? "Server saved successfully" : "Failed to save server");
	}




	@DeleteMapping("/deleteServer/{id}") 
	public String deleteServer(@PathVariable int id) {
		serverRepository.deleteById(id);
		return "Server with id " + id + " is deleted";
	}
	
}