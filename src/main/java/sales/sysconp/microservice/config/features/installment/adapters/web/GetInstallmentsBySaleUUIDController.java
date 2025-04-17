package sales.sysconp.microservice.config.features.installment.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.installment.application.dto.InstallmentResponseDTO;
import sales.sysconp.microservice.features.installment.application.services.InstallmentService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("installment")
public class GetInstallmentsBySaleUUIDController {
    private final InstallmentService installmentService;

    public GetInstallmentsBySaleUUIDController(InstallmentService installmentService) {
        this.installmentService = installmentService;
    }

    @GetMapping("sale/uget/{saleUUID}/all")
    public List<InstallmentResponseDTO> getInstallmentsBySaleUUID(
            @PathVariable UUID saleUUID
    ) {
        return this.installmentService.getAllInstallmentsBySaleUUID(saleUUID);
    }
}