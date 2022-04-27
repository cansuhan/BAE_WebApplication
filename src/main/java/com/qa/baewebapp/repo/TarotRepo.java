package com.qa.baewebapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.baewebapp.domain.Tarot;

@Repository
public interface TarotRepo extends JpaRepository <Tarot, Long>{

}
