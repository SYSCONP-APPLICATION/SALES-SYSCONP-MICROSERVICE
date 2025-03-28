package sales.sysconp.microservice.modules.auth.user.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import sales.sysconp.microservice.features.payment.infrastructure.entities.PaymentEntity;
import sales.sysconp.microservice.features.sale.infrastructure.entities.SaleEntity;
import sales.sysconp.microservice.modules.auth.company.infrastructure.entities.CompanyEntity;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;

    @Column(unique = false, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "company_id")
    private CompanyEntity company;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<SaleEntity> sales;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PaymentEntity> payments;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(updatable = true)
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
