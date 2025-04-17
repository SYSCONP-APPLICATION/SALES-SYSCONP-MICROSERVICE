package sales.sysconp.microservice.config.features.payment_method.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import sales.sysconp.microservice.features.payment_method.application.dto.PaymentMethodResponseDTO;
import sales.sysconp.microservice.features.payment_method.application.dto.PaymentMethodUpdateRequestDTO;
import sales.sysconp.microservice.features.payment_method.application.services.PaymentMethodService;

@RestController
@RequestMapping("payment-method")
public class UpdatePaymentMethodController {
    public final PaymentMethodService paymentMethodService;

    public UpdatePaymentMethodController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @PutMapping("update/{id}")
    public PaymentMethodResponseDTO updatePaymentMethod(
            @PathVariable Long id,
            @RequestBody @Valid PaymentMethodUpdateRequestDTO paymentMethodUpdateRequestDTO
    ) {
        return this.paymentMethodService.updatePaymentMethod(id, paymentMethodUpdateRequestDTO);
    }
}
