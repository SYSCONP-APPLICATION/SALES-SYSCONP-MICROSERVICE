package sales.sysconp.microservice.config.features.installment.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.installment.application.dto.InstallmentCreateRequestDTO;
import sales.sysconp.microservice.features.installment.application.dto.InstallmentCreatedResponseDTO;
import sales.sysconp.microservice.features.installment.application.services.InstallmentService;

@RestController
@RequestMapping("installment")
public class InstallmentCreateController {
    private final InstallmentService installmentService;

    public InstallmentCreateController(InstallmentService installmentService) {
        this.installmentService = installmentService;
    }
    
    @PostMapping("create")
    public InstallmentCreatedResponseDTO createInstallment(
            @RequestBody @Valid InstallmentCreateRequestDTO request
    ) {
        return installmentService.createInstallment(request);
    }
}