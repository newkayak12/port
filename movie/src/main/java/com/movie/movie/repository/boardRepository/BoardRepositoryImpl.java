package com.movie.movie.repository.boardRepository;

import com.movie.movie.domain.Movie;
import com.movie.movie.domain.MovieBoard;
import com.mysema.query.jpa.impl.JPADeleteClause;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.jpa.impl.JPAUpdateClause;
import org.springframework.stereotype.Repository;
import static com.movie.movie.domain.QMovieBoard.movieBoard;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;
@Repository
public class BoardRepositoryImpl implements BoardRepository{
    @PersistenceContext
    EntityManager em;

    @Override
    public List<MovieBoard> selectListMovieBoard(int start, Long movieId) {
        JPAQuery query = new JPAQuery(em);
        List<MovieBoard> result = query.from(movieBoard).where(movieBoard.movie.movieId.eq(movieId)).orderBy(movieBoard.movieBoardWriteDate.desc()).offset(start).limit(10).list(movieBoard);
        return result;
    }

    @Override
    public long updateMovieBoard(Long movieId, Long memberId, String content) {
        JPAUpdateClause updateClause = new JPAUpdateClause(em, movieBoard);
        em.flush();
        long count = updateClause.where(movieBoard.movie.movieId.eq(movieId), movieBoard.members.membersId.eq(memberId)).set(movieBoard.movieBoardContent, content).set(movieBoard.movieBoardWriteDate, new Date()).execute();
        return count;
    }

    @Override
    public long removeMovieBoard(Long movieId, Long memberId) {
        JPADeleteClause deleteClause = new JPADeleteClause(em, movieBoard);
        em.flush();
        long count = deleteClause.where(movieBoard.members.membersId.eq(memberId), movieBoard.movie.movieId.eq(movieId)).execute();
        return count;
    }
}
