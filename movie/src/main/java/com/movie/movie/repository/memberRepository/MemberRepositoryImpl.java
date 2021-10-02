package com.movie.movie.repository.memberRepository;

import java.lang.reflect.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.movie.movie.domain.Members;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Projections;

import org.springframework.data.jpa.repository.support.Querydsl;
import static com.movie.movie.domain.QMembers.members;
import org.springframework.stereotype.Repository;
@Repository
public class MemberRepositoryImpl implements MemberRepository {
	@PersistenceContext
	EntityManager em;

	
	@Override
	public Long selectOne(Members member) {
		Long result = em.createQuery("select COUNT(m) from Members m where m.membersUserId = :userId and m.membersUserPassword = :userPassword", Long.class).setParameter("userId", member.getMembersUserId()).setParameter("userPassword", member.getMembersUserPassword()).getSingleResult();
		return result;
	}

	@Override
	public Long join(Members member) {
		Members m = member;
		em.persist(m);
		return m.getMembersId();
	}

	@Override
	public Members selectOneMember(Members member) {
		JPAQuery query = new JPAQuery(em);
		return query.from(members).where(members.membersUserId.eq(member.getMembersUserId()), members.membersUserPassword.eq(member.getMembersUserPassword())).singleResult(members);
	}
	
}
