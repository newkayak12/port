package com.movie.movie.repository.memberRepository;

import com.movie.movie.domain.Members;

public interface MemberRepository {
	public Long selectOne(Members member);
	public Members selectOneMember(Members member);
	public Long join(Members member);
}
