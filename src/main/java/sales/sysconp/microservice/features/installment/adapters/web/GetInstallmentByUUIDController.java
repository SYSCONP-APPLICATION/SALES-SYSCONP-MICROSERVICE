package sales.sysconp.microservice.features.installment.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.installment.application.dto.InstallmentResponseDTO;
import sales.sysconp.microservice.features.installment.application.services.InstallmentService;

import java.util.UUID;

@RestController
@RequestMapping("installment")
public class GetInstallmentByUUIDController {
    private final InstallmentService installmentService;

    public GetInstallmentByUUIDController(InstallmentService installmentService) {
        this.installmentService = installmentService;
    }

    @GetMapping("uget/{uuid}")
    public InstallmentResponseDTO getInstallmentByUUID(
            @PathVariable UUID uuid
    ) {
        return this.installmentService.getInstallmentByUUID(uuid);
    }
}