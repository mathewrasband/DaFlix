package com.daflix.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "A video does not exist with that name.")
public class VideoNotFoundException extends Exception {

}
