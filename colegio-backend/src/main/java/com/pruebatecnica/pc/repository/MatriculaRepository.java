package com.pruebatecnica.pc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.pruebatecnica.pc.model.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
	
	 @Modifying
	 @Query(nativeQuery = true,value = "update user set name = ?1  where id = ?2 ")
	 int updateUserNameById(String name,Integer id);
}
