package sales.sysconp.microservice.features.payment.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.payment.application.dto.PaymentResponseDTO;
import sales.sysconp.microservice.features.payment.application.services.PaymentService;

import java.util.List;

@RestController
@RequestMapping("payment")
public class GetPaymentsByCompanyIdController {
    private final PaymentService paymentService;

    public GetPaymentsByCompanyIdController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("company/{companyId}/all")
    public List<PaymentResponseDTO> getPaymentsByCompanyId(
            @PathVariable Long companyId
    ) {
        return paymentService.getPaymentsByCompanyId(companyId);
    }
}