package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class TeamController {

	@Autowired TeamRepository teamRepo;
	
	@RequestMapping("/teams")
	public Iterable<Team> getTeams(){
		return teamRepo.findAll();
	}
	
	@RequestMapping("/teams/{id}")
	public Team getTeam(@PathVariable Long id) {
		return teamRepo.findOne(id);
	}
}
