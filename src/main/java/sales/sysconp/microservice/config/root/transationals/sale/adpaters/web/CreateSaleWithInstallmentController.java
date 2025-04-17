package sales.sysconp.microservice.config.root.transationals.sale.adpaters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.root.transationals.sale.application.dto.CreateSaleWithInstallmentCreateRequestDTO;
import sales.sysconp.microservice.root.transationals.sale.application.dto.CreateSaleWithInstallmentResponseDTO;
import sales.sysconp.microservice.root.transationals.sale.application.service.CreateSaleWithInstallmentService;

@RestController
@RequestMapping("sale")
public class CreateSaleWithInstallmentController {
    private final CreateSaleWithInstallmentService createSaleWithInstallmentService;

    public CreateSaleWithInstallmentController(CreateSaleWithInstallmentService createSaleWithInstallmentService) {
        this.createSaleWithInstallmentService = createSaleWithInstallmentService;
    }

    @PostMapping("create-with-installment")
    public CreateSaleWithInstallmentResponseDTO createSaleWithInstallment(
            @RequestBody @Valid CreateSaleWithInstallmentCreateRequestDTO createSaleWithInstallmentCreateRequestDTO
    ) {
        return this.createSaleWithInstallmentService.execute(createSaleWithInstallmentCreateRequestDTO);
    }
}