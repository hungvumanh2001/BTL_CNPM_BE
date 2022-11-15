package com.example.cnpm.service;

import com.example.cnpm.model.Receipt;
import java.util.List;


import java.sql.Date;
import java.util.Optional;

public interface ReceiptService {
    Optional<Receipt> findById(Long id);

    Iterable<Receipt> findAll();

    void save(Receipt receipt);



    Iterable<Receipt>findAllByStatus(int status);
    List<Receipt> findAllByUserId(Long userId);
}