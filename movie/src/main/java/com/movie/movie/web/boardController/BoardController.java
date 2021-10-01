package com.movie.movie.web.boardController;

import com.movie.movie.service.boardService.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
	@Autowired
    BoardService service;
}
