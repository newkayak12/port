package com.movie.movie.web.boardController;

import java.util.List;
import java.util.OptionalInt;

import com.google.common.base.Optional;
import com.movie.movie.domain.MovieBoard;
import com.movie.movie.service.boardService.BoardService;
import com.mysema.query.SearchResults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class BoardController {
	@Autowired
    BoardService service;

    @GetMapping("/api/members/{movieId}/{cPage}")
    public Object[] pagingMovieBoard(@PathVariable(name = "movieId") String movieId, @PathVariable(name = "cPage") int cPage){
	// Integer temp = 1;
	// if(cPages.isPresent()){
	// 	temp=cPages.get();
	// }
	// int cPage = temp.intValue();
        int numPerPage =10;
        int pageBarSize = 5;
        int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
        log.error("{}", pageNo);
        SearchResults<MovieBoard> board = service.selectListMovieBoard(10*(cPage-1)+1, Long.parseLong(movieId));
        int totaldata = (int)board.getTotal();
        int totalPage = (int)Math.ceil((double)totaldata/numPerPage);
        int pageEnd = pageNo+pageBarSize-1;
        log.error("offset"+board.getOffset() +"   limit" +board.getLimit());
        //     // 
            StringBuilder pageBar = new StringBuilder();
            if(pageNo==1){
                pageBar.append("<span class='m-2'>&nbsp;&nbsp;</span>");
            } else {
                pageBar.append("<span class='m-2 cursor' onclick = 'board.paging("+(pageNo-1)+","+(movieId)+")'>[이전]</span>");
            }
	    log.warn(pageNo + " : " + pageEnd+ " : " +totalPage);
            while(!(pageNo>pageEnd||pageNo>totalPage)){
		    if(cPage == pageNo){
                    pageBar.append("<span class='m-2 '><b>"+pageNo+"</b></span>");
                } else {
                    pageBar.append("<span class='m-2 cursor' onclick = 'board.paging("+(pageNo)+","+(movieId)+")'>"+pageNo+"</span>");
                }
                pageNo++;
            }
            
            if(pageNo>totalPage){
                pageBar.append("<span class='m-2'>&nbsp;&nbsp;</span>");
            } else {
                pageBar.append("<span class='m-2 cursor' onclick = 'board.paging("+pageNo+","+(movieId)+")'>[다음]</span>");
            }
        //// 
	Object[] result = {board.getResults(), pageBar.toString()};

	return result;
    }
}
