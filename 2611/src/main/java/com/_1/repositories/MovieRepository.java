package com._1.repositories;

import com._1.dto.MovieMinDTO;
import com._1.entities.Movie;
import com._1.projections.MovieMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(nativeQuery = true, value = "SELECT movies.id, movies.name "
            + "FROM movies "
            + "INNER JOIN genres ON movies.id_genres = genres.id "
            + "WHERE genres.description = :genreName")
    List<MovieMinProjection> search1(@Param("genreName") String genreName);


    @Query("SELECT new com._1.dto.MovieMinDTO(obj.id, obj.name) "
            + "FROM Movie obj "
            + "WHERE obj.genre.description = :genreName")
    List<MovieMinDTO> search2(@Param("genreName") String genreName);

}
