package com.TeamApi.repository;


import org.springframework.data.repository.CrudRepository;

import com.TeamApi.entity.Team;

public interface TeamRepository extends CrudRepository<Team, Integer> {

}
