package br.com.fiap.movie.controller;

import br.com.fiap.movie.entity.Movie;
import br.com.fiap.movie.repository.MovieRepository;
import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    //TODO: Possibilidade de visualizar os filmes de um determinado gênero;
    @ApiOperation(
            value="Busca filme por genero",
            response= String.class,
            notes="Essa operação busca filme por genero")
    @ApiResponses(value= {
            @ApiResponse(
                    code=200,
                    message="busca feita com sucesso",
                    response= List.class
            ),
            @ApiResponse(
                    code=500,
                    message="Erro",
                    response=String.class
            )

    })
    @GetMapping("/genero/{genero}")
    public String findMoviebyGenre(@PathVariable("genero") String genero){

        return new Gson().toJson(movieRepository.findMoviebyGenre(genero));
    }


    //TODO: Possibilidade de visualizar os detalhes de cada filme;
    @ApiOperation(
            value="Busca filme por id",
            response= Movie.class,
            notes="Essa operação busca filme por id")
    @ApiResponses(value= {
            @ApiResponse(
                    code=200,
                    message="busca feita com sucesso",
                    response= Movie.class
            ),
            @ApiResponse(
                    code=500,
                    message="Erro",
                    response=Movie.class
            )

    })
    @GetMapping("/busca/{id}")
    public String findMovieById(@PathVariable("id") int id){

        return  new Gson().toJson(movieRepository.findById((long) id));
    }


    //TODO: Possibilidade de buscar um filme por palavra-chave;
    @ApiOperation(
            value="Busca filme por palavra chave",
            response= List.class,
            notes="Essa operação busca filme por palavra chave")
    @ApiResponses(value= {
            @ApiResponse(
                    code=200,
                    message="busca feita com sucesso",
                    response= List.class
            ),
            @ApiResponse(
                    code=500,
                    message="Erro",
                    response=List.class
            )

    })
    @GetMapping("/busca/palavra/{palavra}")
    public String findMovieById(@PathVariable("palavra") String palavra){

        return  new Gson().toJson(movieRepository.findMoviebyWords(palavra));
    }


    //TODO: Possibilidade de buscar um filme por palavra-chave;
    @ApiOperation(
            value="Busca filme por palavra chave",
            response= List.class,
            notes="Essa operação busca filme por palavra chave")
    @ApiResponses(value= {
            @ApiResponse(
                    code=200,
                    message="busca feita com sucesso",
                    response= List.class
            ),
            @ApiResponse(
                    code=500,
                    message="Erro",
                    response=List.class
            )

    })
    @GetMapping("/busca/categoria/{categoria}")
    public String findMoviebyViewCategoria(@PathVariable("categoria") String categoria){

        return  new Gson().toJson(movieRepository.findMoviebyViewCategoria(categoria));
    }

    //TODO: Possibilidade de buscar um filme por palavra-chave;
    @ApiOperation(
            value="insere filme ",
            response= List.class,
            notes="Essa operação insere filme")
    @ApiResponses(value= {
            @ApiResponse(
                    code=200,
                    message="Inserção feita com sucesso",
                    response= List.class
            ),
            @ApiResponse(
                    code=500,
                    message="Erro",
                    response=List.class
            )

    })
    @PostMapping("/movie/")
    public String findMoviebyViewCategoria(@RequestBody Movie movie){

        return  new Gson().toJson(movieRepository.save(movie));
    }


    @ApiOperation(
            value="Retorna array de filmes",
            response= List.class,
            notes="Essa operação retorna Array de filmes")
    @ApiResponses(value= {
            @ApiResponse(
                    code=200,
                    message="Consulta feita com sucesso",
                    response= List.class
            ),
            @ApiResponse(
                    code=500,
                    message="Erro",
                    response=List.class
            )

    })
    @PostMapping("/movie/array/")
    public String findMoviebyViewCategoria(@RequestBody List<Long> list){

        return  new Gson().toJson(movieRepository.findAllById(list));
    }


}
