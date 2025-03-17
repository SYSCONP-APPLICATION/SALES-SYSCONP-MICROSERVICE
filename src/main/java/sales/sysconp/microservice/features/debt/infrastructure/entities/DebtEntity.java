package sales.sysconp.microservice.features.debt.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import sales.sysconp.microservice.features.installment.infrastructure.entities.InstallmentEntity;

@Entity
@Table(name = "debts")
public class DebtEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;

    public void generateUUID () {
        this.uuid = UUID.randomUUID();
    }
    
    @Column(nullable = false)
    private Double debtPercentage;
    
    @Column(nullable = false)
    private Double debtValue;
    
    @Column(nullable = true)
    private String debtDescription;

    @Column(nullable = true)
    private Long debtAppliedBy;

    @Column(nullable = true)
    private Long debtPayedOrForgivedBy;

    @Column(nullable = true)
    private LocalDateTime debtPayedAt;

    @Column(nullable = true)
    private LocalDateTime forgivedAt;

    @OneToOne(mappedBy = "debt")
    private InstallmentEntity installment;

    @Column(updatable = false)  
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(updatable = true)  
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
