package com.example.cnpm.controller;

import com.example.cnpm.model.Receipt;
import com.example.cnpm.service.ReceiptDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/receipt-details")
@CrossOrigin("*")
public class ReceiptDetailController {
    @Autowired
    ReceiptDetailService receiptDetailService;

    @GetMapping("/find-all-by-receipt")
    public ResponseEntity<List<Receipt>> findAllByUser(@RequestParam Long receiptId) {
        return new ResponseEntity(receiptDetailService.findAllByReceiptId(receiptId), HttpStatus.OK);
    }
}
