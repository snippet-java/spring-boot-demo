package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

	@Autowired TeamRepository teamRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		
		return builder.sources(DemoApplication.class);
	}

	@PostConstruct
	public void init() {
		List<Team> list = new ArrayList<>();

	      Team team = new Team();
	      team.setLocation("Dallas");
	      team.setName("Digital1");
	      list.add(team);

	      team = new Team();
	      team.setLocation("KL team");
	      team.setName("Digital 2");

	      List<Player> addPlayers = new ArrayList<>();
	      addPlayers.add(new Player("Cheok", "Java"));
	      addPlayers.add(new Player("Aiman", "nodeJs"));
	      addPlayers.add(new Player("Zainal", "php"));
	      team.setPlayers(addPlayers);
	      
	      list.add(team);

	      teamRepo.save(list);
	}
}
