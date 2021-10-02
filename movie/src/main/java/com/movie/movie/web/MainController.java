package com.movie.movie.web;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthToolTipUI;

import com.movie.movie.domain.Movie;
import com.movie.movie.domain.MovieBoard;
import com.movie.movie.service.boardService.BoardService;
import com.movie.movie.service.movieService.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.java.Log;
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
    public String gotoMovieDetail( String movieId, Model model){
        Movie movie =movieService.selectOne(Long.parseLong(movieId));
        List<MovieBoard> board = boardService.selectListMovieBoard(0, Long.parseLong(movieId));
        model.addAttribute("movie",movie);
        for(MovieBoard b : board){
            log.error("{}",b);
        }
        model.addAttribute("board", board);
        return "moviepage";
    }


}
