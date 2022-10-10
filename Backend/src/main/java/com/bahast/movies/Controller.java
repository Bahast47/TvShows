package com.bahast.movies;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class Controller {


    @GetMapping("/shows")
    public List<Show> getShows() throws IOException, URISyntaxException {
        Client client = new Client();
        return client.getSummary();
    }

    @GetMapping("/best-episode")
    public List<Episode> getEpisodes() throws IOException, URISyntaxException {
        Client client = new Client();
        return client.getBestEpisodes();
    }




}
