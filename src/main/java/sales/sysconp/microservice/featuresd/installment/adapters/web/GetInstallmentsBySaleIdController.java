package sales.sysconp.microservice.featuresd.installment.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.installment.application.dto.InstallmentResponseDTO;
import sales.sysconp.microservice.features.installment.application.services.InstallmentService;

import java.util.List;

@RestController
@RequestMapping("installment")
public class GetInstallmentsBySaleIdController {
    private final InstallmentService installmentService;

    public GetInstallmentsBySaleIdController(InstallmentService installmentService) {
        this.installmentService = installmentService;
    }

    @GetMapping("sale/{saleId}/all")
    public List<InstallmentResponseDTO> getInstallmentsBySaleId(
            @PathVariable Long saleId
    ) {
        return this.installmentService.getAllInstallmentsBySaleId(saleId);
    }
}