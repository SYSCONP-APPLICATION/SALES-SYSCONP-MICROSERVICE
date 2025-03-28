package sales.sysconp.microservice.modules.project.property.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import sales.sysconp.microservice.features.client.infrastructure.entities.ClientEntity;
import sales.sysconp.microservice.modules.project.building.infrastructure.entities.BuildingEntity;
import sales.sysconp.microservice.modules.project.property.domain.enums.PropertyStatusEnum;
import sales.sysconp.microservice.modules.project.property_category.infrastructure.entities.PropertyCategoryEntity;
import sales.sysconp.microservice.modules.project.property_type.infrastructure.entities.PropertyTypeEntity;
import sales.sysconp.microservice.modules.project.zone.infrastructure.entities.ZoneEntity;

@Entity
@Table(name = "property")
public class PropertyEntity {
    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;

    @Column(nullable = false)
    private String name;

    @Column(unique = false, nullable = true)
    private String description;

    @Column(unique = false, nullable = true)
    private String area;

    @Column(unique = false, nullable = true)
    private Integer bedrooms;

    @Column(unique = false, nullable = true)
    private Integer bathrooms;

    @Column(nullable = false)
    private PropertyStatusEnum status;

    @ManyToOne
    @JoinColumn(name = "building_id") 
    private BuildingEntity building;

    @ManyToOne
    @JoinColumn(name = "property_category_id") 
    private PropertyCategoryEntity propertyCategory;

    @ManyToOne
    @JoinColumn(name = "property_type_id") 
    private PropertyTypeEntity propertyType;

    @ManyToOne
    @JoinColumn(name = "zone_id") 
    private ZoneEntity zone;

    @ManyToOne
    @JoinColumn(name = "client_id") 
    private ClientEntity client;

    @Column(updatable = false)  
    private LocalDateTime createdAt;

    @Column(updatable = true)  
    private LocalDateTime updatedAt;
}