package br.com.fiap.movie;

import br.com.fiap.movie.entity.Movie;
import br.com.fiap.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;

@SpringBootApplication
@EnableJpaAuditing
public class MovieApplication implements CommandLineRunner {

    @Autowired
    MovieRepository movieRepository;

    public static void main(String[] args) {
        SpringApplication.run(MovieApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

      ArrayList<Movie> movieArrayList = new ArrayList<>();

        Movie movie1 = new Movie();
        movie1.setNome("Circulo de fogo");
        movie1.setCategoria("luta");
        movie1.setGenero("ação");
        movie1.setView(10);
        movieArrayList.add(movie1);

        Movie movie2 = new Movie();
        movie2.setNome("Punhos de  aço");
        movie2.setCategoria("luta");
        movie2.setGenero("ação");
        movie2.setView(101);
        movieArrayList.add(movie2);

        Movie movie3 = new Movie();
        movie3.setNome("Branca de neve");
        movie3.setCategoria("infantil");
        movie3.setGenero("fantasia");
        movie3.setView(15);
        movieArrayList.add(movie3);

        Movie movie4 = new Movie();
        movie4.setNome("Bela e a fera");
        movie4.setCategoria("infantil");
        movie4.setGenero("fantasia");
        movie4.setView(5);
        movieArrayList.add(movie4);

        movieRepository.saveAll(movieArrayList);

    }
}
