package sales.sysconp.microservice.config.features.address.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import sales.sysconp.microservice.features.address.application.dto.AddressResponseDTO;
import sales.sysconp.microservice.features.address.application.dto.AddressUpdateRequestDTO;
import sales.sysconp.microservice.features.address.application.services.AddressService;

@RestController
@RequestMapping("address")
public class UpdateAddressController {
    private final AddressService addressService;

    public UpdateAddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PutMapping("update/{id}")
    public AddressResponseDTO updateAddress(
            @PathVariable("id") Long id,
            @RequestBody @Valid AddressUpdateRequestDTO addressUpdateRequestDTO
    ) {
        return addressService.updateAddress(id, addressUpdateRequestDTO);
    }
}