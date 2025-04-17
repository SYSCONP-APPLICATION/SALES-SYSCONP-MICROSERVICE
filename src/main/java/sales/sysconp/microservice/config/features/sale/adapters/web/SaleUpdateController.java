package sales.sysconp.microservice.config.features.sale.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import sales.sysconp.microservice.features.sale.application.dto.SaleResponseDTO;
import sales.sysconp.microservice.features.sale.application.dto.SaleUpdateRequestDTO;
import sales.sysconp.microservice.features.sale.application.services.SaleService;

@RestController
@RequestMapping("sale")
public class SaleUpdateController {
    private final SaleService saleService;

    public SaleUpdateController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PutMapping("update/{id}")
    public SaleResponseDTO updateSale(
            @PathVariable("id") Long id,
            @RequestBody @Valid SaleUpdateRequestDTO saleUpdateRequestDTO
    ) {
        return this.saleService.updateSale(id, saleUpdateRequestDTO);
    }
}