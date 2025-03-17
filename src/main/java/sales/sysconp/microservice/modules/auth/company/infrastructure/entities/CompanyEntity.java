package sales.sysconp.microservice.modules.auth.company.infrastructure.entities;

import java.util.List;
import java.util.UUID;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import sales.sysconp.microservice.features.bank.infrastructure.entities.BankEntity;
import sales.sysconp.microservice.features.client.infrastructure.entities.ClientEntity;
import sales.sysconp.microservice.features.payment.infrastructure.entities.PaymentEntity;
import sales.sysconp.microservice.features.payment_method.infrastructure.entities.PaymentMethodEntity;
import sales.sysconp.microservice.features.sale.infrastructure.entities.SaleEntity;
import sales.sysconp.microservice.features.system_payment_configuration.infrastructure.entities.SystemPaymentConfigurationEntity;
import sales.sysconp.microservice.modules.auth.user.infrastructure.entities.UserEntity;

@Entity
@Table(name = "companies")
public class CompanyEntity {
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;
    
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<UserEntity> users;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<BankEntity> banks;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<ClientEntity> clients;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<PaymentEntity> payments;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<PaymentMethodEntity> paymentMethods;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<SaleEntity> sales;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "system_payment_configuration_id", referencedColumnName = "id")
    private SystemPaymentConfigurationEntity systemPaymentConfiguration;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(updatable = true)
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}