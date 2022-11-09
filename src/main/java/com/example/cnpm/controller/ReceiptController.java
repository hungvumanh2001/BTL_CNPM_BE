package com.example.cnpm.controller;

import com.example.cnpm.model.Receipt;


import com.example.cnpm.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/receipt")
public class ReceiptController {

    @Autowired
    private ReceiptService service;

    @GetMapping("/all")
    public ResponseEntity getId() {
        return new ResponseEntity(service.findAll(), HttpStatus.OK);
    }

    @PutMapping("/confirm")
    public ResponseEntity confirmOrder(@RequestParam Long id) {
        Optional<Receipt> receipt = service.findById(id);
        //jpql  Optional.of(em.createQuery("SELECT o from Receipt o where o.id=:id",Receipt.class).setParameter("id",id).getSingleResult());
        if (receipt.isPresent()) {
            //nếu đã thêm vào giỏ thì chuyển thành đặt hàng
            //còn k thì chuyển thành xác nhận đơn hàng
            //1 bt
            //2 mua
            //3 đã xác nhận

            receipt.get().setStatus(3);
            service.save(receipt.get());
            return new ResponseEntity(HttpStatus.OK);
        }
        throw new NullPointerException("null cart id");
    }
    @GetMapping("/find-all-by-StatusAndUserId")
    public ResponseEntity findAllByStatusAndUserId(@RequestParam int status, @RequestParam Long userId) {
        service.findAllByStatusAndUserId(status,userId);
        return new ResponseEntity(HttpStatus.OK);
    }


    @PostMapping("/add-receipt")
    public ResponseEntity save(@RequestBody Receipt receipt) {
        service.save(receipt);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/find-all-by-user")
    public ResponseEntity<List<Receipt>> findAllByUser(@RequestParam Long userId) {
        return new ResponseEntity(service.findAllByUserId(userId), HttpStatus.OK);
    }
}


