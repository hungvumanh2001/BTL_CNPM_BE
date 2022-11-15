package com.example.cnpm.repository;

import com.example.cnpm.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
    Iterable<Receipt> findAllByStatusAndDateBetween(int status, Date startDate, Date endDate);

    @Query("select new com.example.cnpm.model.Receipt(u) from Receipt u where u.user.id = ?1")
    List<Receipt> findAllByUserId(Long userId);
    Iterable<Receipt>findAllByStatus(int status);
}