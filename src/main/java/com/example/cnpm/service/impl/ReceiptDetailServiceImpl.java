package com.example.cnpm.service.impl;

import com.example.cnpm.model.ReceiptDetail;
import com.example.cnpm.repository.ReceiptDetailRepository;
import com.example.cnpm.service.ReceiptDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptDetailServiceImpl implements ReceiptDetailService {
    @Autowired
    ReceiptDetailRepository receiptDetailRepository;

    @Override
    public List<ReceiptDetail> findAllByReceiptId(Long receiptId) {
        return receiptDetailRepository.findAllByReceiptId(receiptId);
    }
}
