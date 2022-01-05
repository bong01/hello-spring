package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//JpaRepository 상속받으면 자동으로 빈에 등록
public interface SpringDataJpaRepository extends JpaRepository<Member, Long>, MemberRepository {


    //select m from Member m where m.name = ?
    Optional<Member> findByName(String name);
    Optional<Member> findByNameAndId(String name, String id);
}
