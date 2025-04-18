package sales.sysconp.microservice.features.payment.adapters.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.payment.application.dto.PaymentResponseDTO;
import sales.sysconp.microservice.features.payment.application.services.PaymentService;

import java.util.List;

@RestController
@RequestMapping("payment")
public class GetPaymentsBySaleIdController {
    private final PaymentService paymentService;

    @Autowired
    public GetPaymentsBySaleIdController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("sale/{saleId}/all")
    public List<PaymentResponseDTO> getPaymentsBySaleId(
            @PathVariable Long saleId
    ) {
        return paymentService.getPaymentsBySaleId(saleId);
    }
}