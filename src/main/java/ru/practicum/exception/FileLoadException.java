package ru.practicum.exception;

public class FileLoadException extends RuntimeException {
    public FileLoadException(String message) {
        super(message);
    }
}
