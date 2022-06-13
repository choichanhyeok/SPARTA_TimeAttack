package com.spring01.spring_0611.Repository;


import com.spring01.spring_0611.entity.Gender;
import com.spring01.spring_0611.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Member, Long> {
    List<Member> findAllByUserAgeEqualsAndGenderNot(int userAge, Gender gender);
}
