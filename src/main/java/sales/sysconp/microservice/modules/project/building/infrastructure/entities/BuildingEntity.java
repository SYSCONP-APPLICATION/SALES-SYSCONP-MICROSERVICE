package sales.sysconp.microservice.modules.project.building.infrastructure.entities;

import java.util.List;
import java.util.UUID;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import sales.sysconp.microservice.modules.project.project.infrastructure.entities.ProjectEntity;
import sales.sysconp.microservice.modules.project.property.infrastructure.entities.PropertyEntity;
import sales.sysconp.microservice.modules.project.zone.infrastructure.entities.ZoneEntity;

@Entity
@Table(name = "buildings")
public class BuildingEntity {
    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;

    @Column(nullable = false)
    private String name;

    @Column(unique = false, nullable = true)
    private String description;

    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL)
    private List<PropertyEntity> properties;

    @ManyToOne
    @JoinColumn(name = "zone_id") 
    private ZoneEntity zone;

    @ManyToOne
    @JoinColumn(name = "project_id") 
    private ProjectEntity project;

    @Column(updatable = false)  
    private LocalDateTime createdAt;

    @Column(updatable = true)  
    private LocalDateTime updatedAt;
}
