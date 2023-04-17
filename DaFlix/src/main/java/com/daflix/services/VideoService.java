package com.daflix.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.daflix.domain.Video;

public interface VideoService {
	Video getVideo(String name);
	
	void saveVideo(MultipartFile file, String name) throws IOException;
	
	List<String> getAllVideoNames();
}
