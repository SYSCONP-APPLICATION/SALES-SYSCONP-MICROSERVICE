package sales.sysconp.microservice.modules.project.zone.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import sales.sysconp.microservice.modules.project.building.infrastructure.entities.BuildingEntity;
import sales.sysconp.microservice.modules.project.project.infrastructure.entities.ProjectEntity;
import sales.sysconp.microservice.modules.project.property.infrastructure.entities.PropertyEntity;

@Entity
@Table(name = "zones")
public class ZoneEntity {
    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;

    @Column(unique = false, nullable = false)
    private String name;
    
    @Column(unique = false, nullable = false)
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "zone_id", referencedColumnName = "id") 
    private ProjectEntity project;

    @OneToMany(mappedBy = "zone", cascade = CascadeType.ALL)
    private List<PropertyEntity> properties;

    @OneToMany(mappedBy = "zone", cascade = CascadeType.ALL)
    private List<BuildingEntity> buildings;

    @Column(updatable = false)  
    private LocalDateTime createdAt;

    @Column(updatable = true)  
    private LocalDateTime updatedAt;
}
