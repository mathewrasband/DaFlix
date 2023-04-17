package com.daflix.services.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.daflix.domain.Video;
import com.daflix.exceptions.VideoAlreadyExistsException;
import com.daflix.exceptions.VideoNotFoundException;
import com.daflix.repo.VideoRepo;
import com.daflix.services.VideoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VideoServiceImpl implements VideoService {
	private VideoRepo repo;

	@Override
	public Video getVideo(String name) throws VideoNotFoundException {
		if(!repo.existsByName(name)) {
			throw new VideoNotFoundException();
		}
		return repo.findByName(name);
	}

	@Override
	public void saveVideo(MultipartFile file, String name) throws IOException {
		if(repo.existsByName(name)) {
			throw new VideoAlreadyExistsException();
		}
		Video newVid = new Video(name, file.getBytes());
		repo.save(newVid);
	}

	@Override
	public List<String> getAllVideoNames() {
		return repo.getAllEntryNames();
	}

}
