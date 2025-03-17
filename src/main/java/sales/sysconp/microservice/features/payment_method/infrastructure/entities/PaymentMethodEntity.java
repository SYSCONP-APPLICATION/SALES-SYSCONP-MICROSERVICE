package sales.sysconp.microservice.features.payment_method.infrastructure.entities;

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
import jakarta.persistence.Table;
import sales.sysconp.microservice.features.payment.infrastructure.entities.PaymentEntity;
import sales.sysconp.microservice.modules.auth.company.infrastructure.entities.CompanyEntity;

@Entity
@Table(name = "payment_methods")
public class PaymentMethodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;

    public void generateUUID () {
        this.uuid = UUID.randomUUID();
    }

    @Column(unique = false, nullable = false)
    private String name;

    @OneToMany(mappedBy = "paymentMethod", cascade = CascadeType.ALL)
    private List<PaymentEntity> employees;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false, referencedColumnName = "id")
    private CompanyEntity company;

    @Column(updatable = false)  
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(updatable = true)  
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
