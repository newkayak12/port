package com.movie.movie.repository.boardRepository;

import com.movie.movie.domain.MovieBoard;
import com.mysema.query.SearchResults;

import java.util.List;

public interface BoardRepository {
    public SearchResults<MovieBoard> selectListMovieBoard(int start, Long movieId);
    public long updateMovieBoard(Long movieId, Long memberId,Long movieBoardId, String content, String password);
    public long removeMovieBoard(Long movieId, Long memberId ,Long movieBoardId, String password);
    public long insertMovieBoard(Long movieId, Long memberId, String content , String password);
}
