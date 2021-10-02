package com.movie.movie.service.memberService;

import com.movie.movie.domain.Members;

public interface MemberService {
	public Long selectOne(Members member);
	public Members selectOneMember(Members member);
	public Long join(Members meber);
}
