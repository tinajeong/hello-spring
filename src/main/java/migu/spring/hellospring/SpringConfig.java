package migu.spring.hellospring;

import migu.spring.hellospring.repository.MemberRepository;
import migu.spring.hellospring.repository.MemoryMemberRepository;
import migu.spring.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
