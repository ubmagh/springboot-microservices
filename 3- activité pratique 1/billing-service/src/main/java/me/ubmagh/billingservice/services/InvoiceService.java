package me.ubmagh.billingservice.services;

import me.ubmagh.billingservice.dtos.request.InvoiceRequestDTO;
import me.ubmagh.billingservice.dtos.responses.InvoiceResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InvoiceService {

    InvoiceResponseDTO saveInvoice(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO getInvoice( String Id);
    List<InvoiceResponseDTO> invoicesByCustomer(String customerId);

}
