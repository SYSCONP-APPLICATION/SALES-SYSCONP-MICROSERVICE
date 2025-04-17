package sales.sysconp.microservice.featuresd.sale.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.sale.application.dto.SaleResponseDTO;
import sales.sysconp.microservice.features.sale.application.services.SaleService;

import java.util.List;

@RestController
@RequestMapping("sale")
public class GetSaleByCompanyIdController {
    private final SaleService saleService;

    public GetSaleByCompanyIdController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping("company/{id}/all")
    public List<SaleResponseDTO> getAllSalesByCompany(
            @PathVariable("id") Long id
    ) {
        return this.saleService.getAllSalesByCompany(id);
    }
}