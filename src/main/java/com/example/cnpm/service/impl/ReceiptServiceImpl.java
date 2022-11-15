package com.example.cnpm.service.Impl;

import com.example.cnpm.model.Receipt;
import com.example.cnpm.model.ReceiptDetail;
import com.example.cnpm.repository.ReceiptRepository;
import com.example.cnpm.repository.UserRepository;
import com.example.cnpm.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReceiptServiceImpl implements ReceiptService {
    @Autowired
    ReceiptRepository receiptRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<Receipt> findById(Long id) {
       return receiptRepository.findById(id);

    }

    @Override
    public Iterable<Receipt> findAll() {
        return receiptRepository.findAll();
    }

    @Override
    public void save(Receipt model) {
        Receipt receipt = new Receipt();
        if(model.getUser()!=null && model.getUser().getId()!=null){
            receipt.setUser(userRepository.getOne(model.getUser().getId()));
        }
        receipt.setFullname(model.getFullname());
        receipt.setStatus(model.getStatus());
        receipt.setSdt(model.getSdt());
        receipt.setAddress(model.getAddress());
        receipt.setPriceTotal(model.getPriceTotal());
        receipt.setDate(new Date());
        if(model.getReceiptDetails()!=null){
            Iterator<ReceiptDetail> iters = model.getReceiptDetails().iterator();
            HashSet<ReceiptDetail> receiptDetails = new HashSet<ReceiptDetail>();
            while (iters.hasNext()){
                ReceiptDetail receiptDetailIters = iters.next();
                ReceiptDetail receiptDetail = new ReceiptDetail();
                receiptDetail.setReceipt(receipt);
                if(receiptDetailIters.getProduct()!=null){
                    receiptDetail.setProduct(receiptDetailIters.getProduct());
                }
                receiptDetail.setNumber(receiptDetailIters.getNumber());
                receiptDetail.setStatus(receiptDetailIters.getStatus());
                receiptDetails.add(receiptDetail);
            }
            receipt.setReceiptDetails(receiptDetails);
        }
        receiptRepository.save(receipt);
    }

    @Override
    public Iterable<Receipt> findAllByStatus(int status) {
        return receiptRepository.findAllByStatus(status);
    }

    @Override
    public List<Receipt> findAllByUserId(Long userId) {
        return receiptRepository.findAllByUserId(userId);
    }
}
