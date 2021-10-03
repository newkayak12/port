package com.movie.movie.repository.boardRepository;

import com.movie.movie.domain.Members;
import com.movie.movie.domain.Movie;
import com.movie.movie.domain.MovieBoard;
import com.mysema.query.SearchResults;
import com.mysema.query.jpa.impl.JPADeleteClause;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.jpa.impl.JPAUpdateClause;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

import static com.movie.movie.domain.QMovieBoard.movieBoard;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;
@Repository
@Slf4j
public class BoardRepositoryImpl implements BoardRepository{
    @PersistenceContext
    EntityManager em;

    @Override
    public SearchResults<MovieBoard> selectListMovieBoard(int start, Long movieId) {
        JPAQuery query = new JPAQuery(em);
        // SearchResults<MovieBoard> result = query.from(movieBoard).where(movieBoard.movie.movieId.eq(movieId)).orderBy(movieBoard.movieBoardWriteDate.asc())).offset(start).limit(10).listResults(movieBoard);
        SearchResults<MovieBoard> result = query.from(movieBoard).where(movieBoard.movie.movieId.eq(movieId)).orderBy(movieBoard.movieBoardWriteDate.desc()).offset(start).limit(10).listResults(movieBoard);
        return result;
    }

    @Override
    public long updateMovieBoard(Long movieId, Long memberId,Long movieBoardId, String content, String password) {
        JPAUpdateClause updateClause = new JPAUpdateClause(em, movieBoard);
        em.flush();
        JPAQuery query = new JPAQuery(em);
        log.error("movieId"+movieId+" : memberId"+memberId+" : movieBoardId"+movieBoardId+" : "+content+" : "+password);
        Long status = query.from(movieBoard).where(movieBoard.members.membersId.eq(memberId), movieBoard.movie.movieId.eq(movieId), movieBoard.movieBoardId.eq(movieBoardId), movieBoard.movieBoardPassword.eq(password)).singleResult(movieBoard.movieBoardId.count());
        log.error("{}",status);
        if(status>0){
            long count = updateClause.where(movieBoard.movie.movieId.eq(movieId), movieBoard.members.membersId.eq(memberId), movieBoard.movieBoardId.eq(movieBoardId)).set(movieBoard.movieBoardContent, content).set(movieBoard.movieBoardWriteDate, new Date()).execute();
            return movieId;
        }
        return 0;
    }

    @Override
    public long removeMovieBoard(Long movieId, Long memberId ,Long movieBoardId, String password) {
        JPADeleteClause deleteClause = new JPADeleteClause(em, movieBoard);
        em.flush();
        JPAQuery query = new JPAQuery(em);
        Long status = query.from(movieBoard).where(movieBoard.members.membersId.eq(memberId), movieBoard.movie.movieId.eq(movieId), movieBoard.movieBoardId.eq(movieBoardId), movieBoard.movieBoardPassword.eq(password)).singleResult(movieBoard.movieBoardId.count());
        if(status>0){
            long count = deleteClause.where(movieBoard.members.membersId.eq(memberId), movieBoard.movie.movieId.eq(movieId), movieBoard.movieBoardId.eq(movieBoardId)).execute();
            return movieId;
        }
        return 0;
    }

    @Override
    public long insertMovieBoard(Long movieId, Long memberId, String content , String password) {
        MovieBoard mb = MovieBoard.builder().movieBoardContent(content).movie(Movie.builder().movieId(movieId).build()).members(Members.builder().membersId(memberId).build()).movieBoardPassword(password).movieBoardWriteDate(new Date()).build();
        log.error("{}", mb);
        em.persist(mb);
        if(mb.getMovieBoardId()!=null){
            return movieId;
        }
        return 0;

    }
}
