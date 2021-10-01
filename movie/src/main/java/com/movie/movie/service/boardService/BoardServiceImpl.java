package com.movie.movie.service.boardService;

import com.movie.movie.domain.MovieBoard;
import com.movie.movie.repository.boardRepository.BoardRepository;
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
    public List<MovieBoard> selectListMovieBoard(int start, Long movieId) {
        return repo.selectListMovieBoard(start, movieId);
    }

    @Override
    public long updateMovieBoard(Long movieId, Long memberId, String content) {
        return repo.updateMovieBoard(movieId, memberId, content);
    }

    @Override
    public long removeMovieBoard(Long movieId, Long memberId) {
        return repo.removeMovieBoard(movieId, memberId);
    }
}
