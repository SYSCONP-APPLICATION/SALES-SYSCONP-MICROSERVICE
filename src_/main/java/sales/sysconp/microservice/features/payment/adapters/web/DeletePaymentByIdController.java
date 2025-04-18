package sales.sysconp.microservice.features.payment.adapters.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.payment.application.services.PaymentService;

@RestController
@RequestMapping("payment")
public class DeletePaymentByIdController {
    private final PaymentService paymentService;

    public DeletePaymentByIdController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @DeleteMapping("/delete/{id}")
    public void deletePaymentById(
            @PathVariable("id") Long id
    ) {
        paymentService.deleteById(id);
    }
}