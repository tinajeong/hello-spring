package migu.spring.hellospring.service;

import migu.spring.hellospring.domain.Member;
import migu.spring.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class MemberServiceTest {

    MemoryMemberRepository memoryMemberRepository;
    MemberService memberService;


    @BeforeEach
    public void beforeEach() {
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }

    @AfterEach
    public void afterEach() {
        memoryMemberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring");
        //when
        Long saveId = memberService.join(member);
        //then
        Member member1 = memberService.findOne(saveId).get();

        assertThat(member1.getName()).isEqualTo(member.getName());
    }

    @Test
    void 중복회원예외() {
        //given
        Member member = new Member();
        member.setName("spring");
        //when
        Long saveId = memberService.join(member);
        IllegalStateException illegalStateException = Assertions.assertThrows(IllegalStateException.class, () -> {
            memberService.join(member);
        });
        assertThat(illegalStateException.getMessage()).isEqualTo("this name is already exist");
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}