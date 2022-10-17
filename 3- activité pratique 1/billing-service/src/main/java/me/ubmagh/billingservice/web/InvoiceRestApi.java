package me.ubmagh.billingservice.web;

import lombok.AllArgsConstructor;
import me.ubmagh.billingservice.dtos.request.InvoiceRequestDTO;
import me.ubmagh.billingservice.dtos.responses.InvoiceResponseDTO;
import me.ubmagh.billingservice.services.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class InvoiceRestApi {

    private InvoiceService invoiceService;

    @GetMapping("/invoices/{id}")
    public InvoiceResponseDTO getInvoice( @PathVariable String invoiceId){
        return invoiceService.getInvoice(invoiceId);
    }

    @GetMapping("/invoicesByCustomer/{id}")
    public List<InvoiceResponseDTO> getInvoiceByCustomer(@PathVariable String customerId){
        return invoiceService.invoicesByCustomer(customerId);
    }

    @PostMapping("/invoices")
    public InvoiceResponseDTO createInvoice(@RequestBody InvoiceRequestDTO invoice){
        return invoiceService.saveInvoice(invoice);
    }


}
