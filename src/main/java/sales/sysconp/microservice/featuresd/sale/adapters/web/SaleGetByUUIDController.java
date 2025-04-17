package sales.sysconp.microservice.featuresd.sale.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.sale.application.dto.SaleResponseDTO;
import sales.sysconp.microservice.features.sale.application.services.SaleService;

import java.util.UUID;

@RestController
@RequestMapping("sale")
public class SaleGetByUUIDController {
    private final SaleService saleService;

    public SaleGetByUUIDController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping("uuid/{uuid}")
    public SaleResponseDTO getSaleById(
            @PathVariable("uuid") UUID uuid
    ) {
        return this.saleService.getSaleByUUID(uuid);
    }
}
