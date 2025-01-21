package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

// @Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) { // store에 넣기 전에 mamber에 id 값 세팅
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) { // store에서 꺼내기
        return Optional.ofNullable(store.get(id)); // 결과가 없을 때을 대비해 optional로 감쌈
    }

    @Override
    public Optional<Member> findByName(String name) { // store에서 member.getName이랑 name이 같은지 확인. 같은 경우에만 필터링(반환)
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // values == member
    }

    public void clearStore() {
        store.clear();
    }
}
