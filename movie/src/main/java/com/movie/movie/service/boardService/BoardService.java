package com.movie.movie.service.boardService;

import com.movie.movie.domain.MovieBoard;

import java.util.List;

public interface BoardService {
    public List<MovieBoard> selectListMovieBoard(int start, Long movieId);
    public long updateMovieBoard(Long movieId, Long memberId, String content);
    public long removeMovieBoard(Long movieId, Long memberId);
}
