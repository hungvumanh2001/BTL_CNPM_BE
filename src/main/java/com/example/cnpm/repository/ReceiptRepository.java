package com.example.cnpm.repository;

import com.example.cnpm.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;


@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
    Iterable<Receipt>findAllByStatusAndDateBetween(int status,Date startDate, Date endDate);
}
