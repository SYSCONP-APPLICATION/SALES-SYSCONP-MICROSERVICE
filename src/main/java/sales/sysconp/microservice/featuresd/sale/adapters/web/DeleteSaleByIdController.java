package sales.sysconp.microservice.featuresd.sale.adapters.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.sale.application.services.SaleService;

@RestController
@RequestMapping("sale")
public class DeleteSaleByIdController {
    private final SaleService saleService;

    public DeleteSaleByIdController(SaleService saleService) {
        this.saleService = saleService;
    }

    @DeleteMapping("delete/{id}")
    public void deleteSaleById(
            @PathVariable("id") Long id
    ) {
        this.saleService.deleteSale(id);
    }
}