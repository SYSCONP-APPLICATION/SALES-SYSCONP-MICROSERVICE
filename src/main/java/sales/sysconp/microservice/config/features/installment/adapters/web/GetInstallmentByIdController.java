package sales.sysconp.microservice.config.features.installment.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.installment.application.dto.InstallmentResponseDTO;
import sales.sysconp.microservice.features.installment.application.services.InstallmentService;

@RestController
@RequestMapping("installment")
public class GetInstallmentByIdController {
    private final InstallmentService installmentService;

    public GetInstallmentByIdController(InstallmentService installmentService) {
        this.installmentService = installmentService;
    }

    @GetMapping("get/{id}")
    public InstallmentResponseDTO getInstallmentById(
            @PathVariable Long id
    ) {
        return this.installmentService.getInstallmentById(id);
    }
}