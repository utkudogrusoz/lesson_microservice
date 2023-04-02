package com.utkudogrusoz.libraryservice.client;

public record ExceptionMessage(
        String timestamp,
        int status,
        String error,
        String message,
        String path
) {
}
