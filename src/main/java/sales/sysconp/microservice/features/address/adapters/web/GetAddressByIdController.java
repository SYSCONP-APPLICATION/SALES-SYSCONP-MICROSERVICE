package sales.sysconp.microservice.features.address.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.address.application.dto.AddressResponseDTO;
import sales.sysconp.microservice.features.address.application.services.AddressService;

@RestController
@RequestMapping("address")
public class GetAddressByIdController {
    private final AddressService addressService;

    public GetAddressByIdController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("get/{id}")
    public AddressResponseDTO getAddressById(
            @PathVariable("id") Long id
    ) {
        return this.addressService.getAddressById(id);
    }
}
