package sales.sysconp.microservice.featuresd.address.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.address.application.dto.AddressCreateRequestDTO;
import sales.sysconp.microservice.features.address.application.dto.AddressResponseDTO;
import sales.sysconp.microservice.features.address.application.services.AddressService;

@RestController
@RequestMapping("address")
public class CreateAddressController {
    private final AddressService addressService;

    public CreateAddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("create")
    public AddressResponseDTO createAddress(
            @RequestBody @Valid AddressCreateRequestDTO addressCreateRequestDTO
    ) {
        return this.addressService.createAddress(addressCreateRequestDTO);
    }
}
