package sales.sysconp.microservice.features.payment.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.payment.application.dto.PaymentResponseDTO;
import sales.sysconp.microservice.features.payment.application.services.PaymentService;

@RestController
@RequestMapping("payment")
public class GetPaymentByIdController {
    
    private final PaymentService paymentService;

    public GetPaymentByIdController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("get/{id}")
    public PaymentResponseDTO getPaymentById(
            @PathVariable("id") Long id
    ) {
        return paymentService.getPaymentById(id);
    }
}