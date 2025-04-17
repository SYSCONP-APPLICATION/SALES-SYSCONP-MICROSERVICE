package sales.sysconp.microservice.config.features.sale.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.sale.application.dto.SaleCreateRequestDTO;
import sales.sysconp.microservice.features.sale.application.dto.SaleResponseDTO;
import sales.sysconp.microservice.features.sale.application.services.SaleService;

@RestController
@RequestMapping("sale")
public class SaleCreateController {
    private final SaleService saleService;

    public SaleCreateController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping("create")
    public SaleResponseDTO createSale(
            @RequestBody @Valid SaleCreateRequestDTO dto
    ) {
        return this.saleService.createSale(dto);
    }
}
