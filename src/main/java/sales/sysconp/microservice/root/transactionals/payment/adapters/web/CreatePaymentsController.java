package sales.sysconp.microservice.root.transactionals.payment.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.root.transactionals.payment.application.dto.CreatePaymentsRequestDTO;
import sales.sysconp.microservice.root.transactionals.payment.application.service.PaymentsService;

@RestController
@RequestMapping("payment")
public class CreatePaymentsController {
    private final PaymentsService paymentsService;

    public CreatePaymentsController(PaymentsService paymentsService) {
        this.paymentsService = paymentsService;
    }

    @PostMapping("mul/create")
    public void createPayments(
            @RequestBody @Valid CreatePaymentsRequestDTO requestDTO
    ) {
        paymentsService.createPayments(requestDTO);
    }
}