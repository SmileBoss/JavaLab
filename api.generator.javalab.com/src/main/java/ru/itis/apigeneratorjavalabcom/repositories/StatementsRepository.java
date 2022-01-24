package ru.itis.apigeneratorjavalabcom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.apigeneratorjavalabcom.models.dao.Statements;

@Repository
public interface StatementsRepository extends JpaRepository<Statements, Long> {
//    Page<Statements> getAllByFAndFirstname(Pageable pageable);

}
