package sales.sysconp.microservice.featuresd.installment.adapters.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.installment.application.services.InstallmentService;

@RestController
@RequestMapping("installment")
public class DeleteInstallmentByIdController {
    private final InstallmentService installmentService;

    public DeleteInstallmentByIdController(InstallmentService installmentService) {
        this.installmentService = installmentService;
    }

    @DeleteMapping("delete/{id}")
    public void deleteInstallmentById(
            @PathVariable Long id
    ) {
        this.installmentService.deleteInstallmentById(id);
    }
}