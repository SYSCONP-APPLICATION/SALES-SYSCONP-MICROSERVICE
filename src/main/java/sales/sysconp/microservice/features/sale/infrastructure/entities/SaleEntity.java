package sales.sysconp.microservice.features.sale.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import sales.sysconp.microservice.features.client.infrastructure.entities.ClientEntity;
import sales.sysconp.microservice.features.installment.infrastructure.entities.InstallmentEntity;
import sales.sysconp.microservice.features.payment.infrastructure.entities.PaymentEntity;
import sales.sysconp.microservice.features.payment_configuration.infrastructure.entities.PaymentConfigurationEntity;
import sales.sysconp.microservice.features.sale.domain.models.SaleStatus;
import sales.sysconp.microservice.modules.auth.company.infrastructure.entities.CompanyEntity;
import sales.sysconp.microservice.modules.auth.user.infrastructure.entities.UserEntity;

@Entity
@Table(name = "sales")
public class SaleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;

    public void generateUUID () {
        this.uuid = UUID.randomUUID();
    }
    
    @Column(nullable = false)
    private SaleStatus status;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false, referencedColumnName = "id")
    private ClientEntity clientId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private UserEntity userId;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<PaymentEntity> payments;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<InstallmentEntity> installments;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_configuration_id", referencedColumnName = "id")
    private PaymentConfigurationEntity paymentConfigurationEntity;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private CompanyEntity company;

    @Column(updatable = false)  
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(updatable = true)  
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}