package br.com.fiap.movie.repository;

import br.com.fiap.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    @Async
    @Query(value = "SELECT * FROM movie WHERE genero = :genero",nativeQuery=true)
    List<Movie> findMoviebyGenre(@Param("genero") String genero);

    @Async
    @Query(value = "SELECT * FROM movie WHERE nome LIKE %:words%",nativeQuery=true)
    List<Movie> findMoviebyWords(@Param("words") String words);

    @Async
    @Query(value = "SELECT * FROM movie WHERE categoria = :categoria ORDER BY VIEW DESC ",nativeQuery=true)
    List<Movie> findMoviebyViewCategoria(@Param("categoria") String categorua);

}
