package sales.sysconp.microservice.features.payment_stump.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import sales.sysconp.microservice.features.payment_configuration.infrastructure.entities.PaymentConfigurationEntity;
import sales.sysconp.microservice.features.system_payment_configuration.infrastructure.entities.SystemPaymentConfigurationEntity;

@Entity
@Table(name = "payment_stamp")
public class PaymentStampEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;

    @PrePersist
    public void generateUUID () {
        this.uuid = UUID.randomUUID();
    }
    
    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "paymentStamp")
    private List<PaymentConfigurationEntity> paymentConfigurations;

    @OneToMany(mappedBy = "paymentStamp")
    private List<SystemPaymentConfigurationEntity> systemPaymentConfigurations;

    @Column(updatable = false)  
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(updatable = true)  
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
