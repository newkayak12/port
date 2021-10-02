package com.movie.movie.member;

import com.movie.movie.domain.Members;
import com.movie.movie.repository.memberRepository.MemberRepository;
import com.movie.movie.repository.memberRepository.MemberRepositoryImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;
import javax.persistence.EntityManager;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@PropertySource("classpath:application.properties")
@EnableAutoConfiguration
public class MemberTest {
    @Autowired
    MemberRepositoryImpl repo;


    @Test
    public void join(){
        Members member = Members.builder().membersUserId("t1").membersUserPassword("t1").build();
        Long result = repo.join(member);
        Assertions.assertEquals(result, 1L);
    }
}
