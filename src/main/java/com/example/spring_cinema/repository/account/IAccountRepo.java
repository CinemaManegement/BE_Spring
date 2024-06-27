package com.example.spring_cinema.repository.account;

import com.example.spring_cinema.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IAccountRepo extends JpaRepository<Account, Integer> {
    @Modifying
    @Transactional
    @Query(value = "insert into Account (username,password,email,status,role_id) values (:#{#account.username}, :#{#account.password}, :#{#account.email}, :#{#account.status}, :#{#account.role.id})", nativeQuery = true)
    void createAccount(@Param("account") Account account);

    @Query("select a from Account a where a.username like :username")
    Account findIdAccountByUserName(@Param("username") String username);

    Boolean existsByUsername(String username);

    @Modifying
    @Transactional
    @Query("update Account a set a.status = :status where a.id = :id")
    void updateStatusAccount(@Param("status") boolean status,@Param("id") int id);
}
