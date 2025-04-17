package sales.sysconp.microservice.featuresd.address.adapters.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.address.application.services.AddressService;

@RestController
@RequestMapping("address")
public class DeleteAddressByIdController {
    private final AddressService addressService;

    public DeleteAddressByIdController(AddressService addressService) {
        this.addressService = addressService;
    }

    @DeleteMapping("delete/{id}")
    public void deleteAddressById(
            @PathVariable("id") Long id
    ) {
        addressService.deleteAddress(id);
    }
}
