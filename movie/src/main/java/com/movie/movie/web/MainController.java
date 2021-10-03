package com.movie.movie.web;

import javax.servlet.http.HttpSession;

import com.movie.movie.domain.Movie;
import com.movie.movie.domain.MovieBoard;
import com.movie.movie.service.boardService.BoardService;
import com.movie.movie.service.movieService.MovieService;
import com.mysema.query.SearchResults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import antlr.collections.List;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class MainController {
	@Autowired
    MovieService movieService;
    @Autowired
    BoardService boardService;
    @RequestMapping("/")
    public String gotoMain(){
        return "index";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("member");
        return "redirect:/";
    }
    @RequestMapping("/movieDetail")
    public String gotoMovieDetail( String movieId, @RequestParam(defaultValue = "1", name = "cPage") int cPages, Model model){
        Movie movie =movieService.selectOne(Long.parseLong(movieId));
        int cPage = cPages;
        SearchResults<MovieBoard> board = boardService.selectListMovieBoard(10*(cPage-1), Long.parseLong(movieId));
        int numPerPage =10;
        int pageBarSize = 5;
        int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
        log.error("{}", pageNo);
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
        
        model.addAttribute("pageBar", pageBar);
        model.addAttribute("board", board.getResults());
        model.addAttribute("movie",movie);

        
        return "moviepage";
    }


}
