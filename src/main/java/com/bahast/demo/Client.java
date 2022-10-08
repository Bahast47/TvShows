package com.bahast.demo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Client {

    private List<String> getShows() throws IOException, URISyntaxException {
        return Files.readAllLines(Path.of(ClassLoader.getSystemResource("shows.txt").toURI()));
    }
}
