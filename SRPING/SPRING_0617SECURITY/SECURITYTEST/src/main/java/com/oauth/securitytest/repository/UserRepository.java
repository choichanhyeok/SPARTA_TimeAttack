package com.oauth.securitytest.repository;

import com.oauth.securitytest.entity.Gender;
import com.oauth.securitytest.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Member, Long> {
    List<Member> findAllByUserAgeEqualsAndGenderNot(int userAge, Gender gender);
}
