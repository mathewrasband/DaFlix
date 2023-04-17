package com.daflix.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.daflix.services.VideoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("video")
@AllArgsConstructor
public class VideoController {
	
	private VideoService videoService;
	
	@PostMapping()
	public ResponseEntity<String> saveVideo(@RequestParam("file") MultipartFile file, @RequestParam("name") String name) throws IOException{
		videoService.saveVideo(file, name);
		return ResponseEntity.ok("Video saved successfully.");
	}
	
	@GetMapping("{name}")
	public ResponseEntity<List<String>> getAllVideoNames(){
		return ResponseEntity.ok(videoService.getAllVideoNames());
	}

}
