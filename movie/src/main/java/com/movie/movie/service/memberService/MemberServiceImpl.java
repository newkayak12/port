package com.movie.movie.service.memberService;

import javax.transaction.Transactional;

import com.movie.movie.domain.Members;
import com.movie.movie.repository.memberRepository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberRepository repo;

	@Override
	public Long selectOne(Members member) {
		return repo.selectOne(member);
	}

	@Override
	public Long join(Members meber) {
		return repo.join(meber);
	}

	@Override
	public Members selectOneMember(Members member) {
		return repo.selectOneMember(member);
	}
	
}
