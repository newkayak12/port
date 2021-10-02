package com.movie.movie.service.boardService;

import com.movie.movie.domain.MovieBoard;
import com.mysema.query.SearchResults;

import java.util.List;

public interface BoardService {
    public SearchResults<MovieBoard> selectListMovieBoard(int start, Long movieId);
    public long updateMovieBoard(Long movieId, Long memberId, String content, String password);
    public long removeMovieBoard(Long movieId, Long memberId , String password);
    public long insertMovieBoard(Long movieId, Long memberId, String content , String password);
}
