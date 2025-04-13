package sales.sysconp.microservice.features.client.application.dto;

import sales.sysconp.microservice.features.address.domain.models.AddressModel;
import sales.sysconp.microservice.features.contact.domain.models.ContactModel;
import sales.sysconp.microservice.features.sale.domain.models.SaleModel;
import sales.sysconp.microservice.modules.auth.company.domain.models.CompanyModel;
import sales.sysconp.microservice.modules.project.property.domain.models.PropertyModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ClientResponseDTO {
    private Long id;
    private UUID uuid;
    private String name;
    private String identityCardNumber;
    private List<ContactModel> contacts;
    private List<SaleModel> sales;
    private AddressModel address;
    private CompanyModel company;
    private List<PropertyModel> properties;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ClientResponseDTO() {
    }

    public ClientResponseDTO(Long id, UUID uuid, String name, String identityCardNumber, List<ContactModel> contacts, List<SaleModel> sales, AddressModel address, CompanyModel company, List<PropertyModel> properties, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.identityCardNumber = identityCardNumber;
        this.contacts = contacts;
        this.sales = sales;
        this.address = address;
        this.company = company;
        this.properties = properties;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}