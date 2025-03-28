package sales.sysconp.microservice.features.system_payment_configuration.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import sales.sysconp.microservice.features.payment_stump.infrastructure.entities.PaymentStampEntity;
// import sales.sysconp.microservice.features.payment_stamp.infrastructure.entities.PaymentStampEntity;
import sales.sysconp.microservice.modules.auth.company.infrastructure.entities.CompanyEntity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
@Table(name = "payment_configurations")
public class SystemPaymentConfigurationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;

    public void generateUUID () {
        this.uuid = UUID.randomUUID();
    }
    
    @Column(nullable = false)
    private Long dayOfMonth;

    @Column(nullable = false)
    private boolean requireOnCreateSale;

    @Column(nullable = false)
    private boolean requireForAllSales;

    @ManyToOne
    @JoinColumn(name = "payment_stamp_id", nullable = false)
    private PaymentStampEntity paymentStamp;

    @OneToOne(mappedBy = "systemPaymentConfiguration", cascade = CascadeType.ALL)
    private CompanyEntity company;

    @Column(updatable = false)  
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(updatable = true)  
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}