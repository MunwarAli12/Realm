package com.kaiburr.servertask.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.kaiburr.servertask.model.Server;

@Repository
public interface ServerRepository extends MongoRepository<Server, Integer>{

	
 
	@Query(value="{'framework' : ?0}")
	List<Server> getServersByFramework(String framework);

	
	@Query(value="{'language' : ?0}")
	List<Server> getServersByLanguage(String language);

	@Query(value="{'name' : ?0}")
	List<Server> getServersByName(String name);
	
	@Query(value="{'id' : ?0}")
	Optional<Server> findById(int id);
	
	
	@Query(value="{}")
	List<Server> findAll();

	@Query(value="{}")
	List<Server> getAllServers();
}
