package com.example.cnpm.controller;

import com.example.cnpm.model.Receipt;
import com.example.cnpm.model.ReceiptDetail;

import com.example.cnpm.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Date;
import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/receipt")
public class ReceiptController {

    @Autowired
    private ReceiptService service;
//    @PersistenceContext
//    public EntityManager em;

    @GetMapping("/all")
    public ResponseEntity getId()
    {
        return new ResponseEntity(service.findAll(),HttpStatus.OK);
    }
    @PutMapping("/confirm")
    public ResponseEntity confirmOrder(@RequestParam Long id) {
        Optional<Receipt> receipt =service.findById(id);
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

    @GetMapping("/sum")
    public ResponseEntity<Float> sum(@RequestParam Date start, @RequestParam Date end) {
//        float sum=0;
//        Iterable<Receipt>receipts=service.findAllByStatusAndDateBetween(start,end);
//        for(Receipt receipt:receipts)
//        {
//            ReceiptDetail receiptDetail=em.createQuery("Select o from ReceiptDetail o where o.receipt.id=:id",ReceiptDetail.class).
//                    setParameter("id",receipt.getId()).getSingleResult();
//            sum+=receiptDetail.getNumber()*receiptDetail.getProduct().getPrice();
//        }

                /**em.createQuery("Select o from Receipt o where o.status=3 and o.date between :start and :end")
                .setParameter("start",start)
                .setParameter("end",end)
                .getResultList();*/
        return new ResponseEntity(null,HttpStatus.NO_CONTENT);
    }
}
