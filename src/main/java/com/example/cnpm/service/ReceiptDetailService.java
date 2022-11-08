package com.example.cnpm.service;

import com.example.cnpm.model.ReceiptDetail;

import java.util.List;

public interface ReceiptDetailService {
    List<ReceiptDetail> findAllByReceiptId(Long receiptId);
}
