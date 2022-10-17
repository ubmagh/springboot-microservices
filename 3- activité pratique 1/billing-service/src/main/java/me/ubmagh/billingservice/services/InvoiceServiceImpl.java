package me.ubmagh.billingservice.services;

import lombok.AllArgsConstructor;
import me.ubmagh.billingservice.dtos.request.InvoiceRequestDTO;
import me.ubmagh.billingservice.dtos.responses.InvoiceResponseDTO;
import me.ubmagh.billingservice.entities.Customer;
import me.ubmagh.billingservice.entities.Invoice;
import me.ubmagh.billingservice.mappers.InvoiceMapper;
import me.ubmagh.billingservice.openfeign.CustomerRestClient;
import me.ubmagh.billingservice.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceRepository invoiceRepository;
    private InvoiceMapper invoiceMapper;
    private CustomerRestClient customerRestClient;


    @Override
    public InvoiceResponseDTO saveInvoice(InvoiceRequestDTO invoiceRequestDTO) {
        Invoice invoice = invoiceMapper.fromInvoiceRequestDTO( invoiceRequestDTO );
        Invoice savedInvoice = invoiceRepository.save( invoice );
        savedInvoice.setId(UUID.randomUUID().toString());
        savedInvoice.setDate(new Date());
        // check if customer exist !!
        return this.getInvoice(savedInvoice.getId());
    }

    @Override
    public InvoiceResponseDTO getInvoice(String Id) {
        Invoice invoice = invoiceRepository.findById( Id).orElseGet(null);
        Customer customer = customerRestClient.getCustomer( invoice.getCusomerId() );
        invoice.setCustomer(customer);
        return invoiceMapper.fromInvoice(invoice);
    }

    @Override
    public List<InvoiceResponseDTO> invoicesByCustomer(String customerId) {
        List<Invoice> invoices = invoiceRepository.findByCusomerId(customerId);
        return invoices.stream().map(inv->invoiceMapper.fromInvoice(inv)).collect(Collectors.toList());
    }
}
