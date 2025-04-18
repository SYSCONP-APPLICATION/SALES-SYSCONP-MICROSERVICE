package sales.sysconp.microservice.features.sale.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.sale.application.dto.SaleResponseDTO;
import sales.sysconp.microservice.features.sale.application.services.SaleService;

@RestController
@RequestMapping("sale")
public class SaleGetByIdController {
    private final SaleService saleService;

    public SaleGetByIdController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping("get/{id}")
    public SaleResponseDTO getSaleById(
            @PathVariable("id") Long id
    ) {
        return this.saleService.getSaleById(id);
    }
}
