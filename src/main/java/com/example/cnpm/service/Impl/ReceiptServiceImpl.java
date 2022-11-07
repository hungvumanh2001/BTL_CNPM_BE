package com.example.cnpm.service.Impl;

import com.example.cnpm.model.Receipt;
import com.example.cnpm.repository.ReceiptRepository;
import com.example.cnpm.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public class ReceiptServiceImpl implements ReceiptService {
    @Autowired
    private ReceiptRepository repository;
    @Override
    public Optional<Receipt> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Receipt> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Receipt receipt) {
        repository.save(receipt);
    }

    @Override
    public Iterable<Receipt> findAllByStatusAndDateBetween(Date start, Date end) {
        return repository.findAllByStatusAndDateBetween(3,start,end);
    }
}
