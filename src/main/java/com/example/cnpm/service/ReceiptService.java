package com.example.cnpm.service;

import com.example.cnpm.model.Receipt;

import java.util.List;

public interface ReceiptService {
    void save(Receipt receipt);
    List<Receipt> findAllByUserId(Long userId);
}
