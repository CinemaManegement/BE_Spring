package com.example.be_spring.repository.invoice;

import com.example.be_spring.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInvoiceRepo extends JpaRepository<Invoice, Integer> {
}
