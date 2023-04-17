package com.daflix.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.daflix.domain.Video;

public interface VideoRepo extends JpaRepository<Video, Long> {
	Video findByName(String name);
	
	boolean existsByName(String name);
	
	@Query(nativeQuery = true, value = "SELECT name FROM video")
	List<String> getAllEntryNames();
}
