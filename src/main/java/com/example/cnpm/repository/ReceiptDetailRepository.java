package com.example.cnpm.repository;

import com.example.cnpm.model.ReceiptDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceiptDetailRepository extends JpaRepository<ReceiptDetail, Long> {
    @Query("Select new com.example.cnpm.model.ReceiptDetail(u) from ReceiptDetail u where u.receipt.id = ?1")
    List<ReceiptDetail> findAllByReceiptId(Long receiptId);
}
