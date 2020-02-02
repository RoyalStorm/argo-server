package com.arrayteam.argo.server.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "The file you are trying to upload is not an image")
public final class BadFileException extends RuntimeException {
}
