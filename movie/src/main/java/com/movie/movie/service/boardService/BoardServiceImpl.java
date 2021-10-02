package com.movie.movie.service.boardService;

import com.movie.movie.domain.MovieBoard;
import com.movie.movie.repository.boardRepository.BoardRepository;
import com.mysema.query.SearchResults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class BoardServiceImpl implements BoardService{
    @Autowired
    BoardRepository repo;

    @Override
    public SearchResults<MovieBoard> selectListMovieBoard(int start, Long movieId) {
        return repo.selectListMovieBoard(start, movieId);
    }

    @Override
    public long updateMovieBoard(Long movieId, Long memberId, String content , String password) {
        return repo.updateMovieBoard(movieId, memberId, content, password);
    }

    @Override
    public long removeMovieBoard(Long movieId, Long memberId , String password) {
        return repo.removeMovieBoard(movieId, memberId, password);
    }

    @Override
    public long insertMovieBoard(Long movieId, Long memberId, String content , String password) {
        return repo.insertMovieBoard(movieId, memberId, content, password);
    }
}
