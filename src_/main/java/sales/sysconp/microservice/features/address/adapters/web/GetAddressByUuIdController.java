package sales.sysconp.microservice.features.address.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.address.application.dto.AddressResponseDTO;
import sales.sysconp.microservice.features.address.application.services.AddressService;

import java.util.UUID;

@RestController
@RequestMapping("address")
public class GetAddressByUuIdController {
    private final AddressService addressService;

    public GetAddressByUuIdController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("uuid/{uuid}")
    public AddressResponseDTO getAddressByUUID(
            @PathVariable("uuid") UUID uuid
    ) {
        return this.addressService.getAddressByUUID(uuid);
    }
}
