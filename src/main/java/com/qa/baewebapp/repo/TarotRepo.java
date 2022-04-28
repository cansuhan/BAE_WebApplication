package com.qa.baewebapp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.qa.baewebapp.domain.Tarot;

@Repository
public interface TarotRepo extends JpaRepository <Tarot, Long>{
	
	Optional<Tarot> findByNumber(String number);
	
	//	@Query(value = "SELECT * FROM user WHERE number = ?1", nativeQuery=true)
	//	Optional<User> findByNumber(String number);
}
