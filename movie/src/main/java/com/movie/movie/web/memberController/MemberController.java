package com.movie.movie.web.memberController;

import javax.servlet.http.HttpSession;

import com.movie.movie.domain.Members;
import com.movie.movie.service.memberService.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MemberController {
	@Autowired
    MemberService service;
	@PostMapping("/api/members/login")
    public Long checkIn(@RequestBody Members member, HttpSession session){
	    Long number = service.selectOne(member);
	    
	    if(number > 0){
		    session.setAttribute("member", member);
	    }

	    return number;
    }
    	@PostMapping("/api/members/join")
    public Long signin(@RequestBody Members member){
	    Long number = service.join(member);
	    return number;
    }
}
