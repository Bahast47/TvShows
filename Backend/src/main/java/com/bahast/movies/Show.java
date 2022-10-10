package com.bahast.movies;

import java.util.List;

public record Show(Integer id, String name, List<String> genres, Network network, String url, String summary) {
}
