package com.bahast.demo;

import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Client {

    RestTemplate restTemplate = new RestTemplate();
    List<String> shows = getShows();

    public Client() throws IOException, URISyntaxException {
    }


    List<Show> getSummary() {
        List<Show> result = Arrays.stream(Objects.requireNonNull(restTemplate.getForObject("https://api.tvmaze.com/shows", Show[].class))).toList();
        return result.stream().filter(show -> shows.contains(show.name())).toList();
    }


    List<Episode> getBestEpisodes() {
        List<Show> summary = getSummary();

        return summary.stream().map(show -> {
            List<Episode> episodes = Arrays.stream(Objects.requireNonNull(restTemplate.getForObject("https://api.tvmaze.com/shows/" + show.id() + "/episodes", Episode[].class))).toList();
            Optional<Episode> max = episodes.stream().filter(episode -> episode.rating().average() != null).max(Comparator.comparing(o -> o.rating().average()));

            return max.orElse(null);
        }).toList();
    }

    private List<String> getShows() throws IOException, URISyntaxException {
        return Files.readAllLines(Path.of(ClassLoader.getSystemResource("shows.txt").toURI()));
    }
}
