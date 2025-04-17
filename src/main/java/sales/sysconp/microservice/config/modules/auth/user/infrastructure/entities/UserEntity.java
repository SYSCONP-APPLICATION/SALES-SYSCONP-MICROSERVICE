package sales.sysconp.microservice.config.modules.auth.user.infrastructure.entities;

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
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import sales.sysconp.microservice.features.payment.infrastructure.entities.PaymentEntity;
import sales.sysconp.microservice.features.sale.infrastructure.entities.SaleEntity;
import sales.sysconp.microservice.modules.auth.company.infrastructure.entities.CompanyEntity;

@Entity
@Table(name = "users")
@SQLDelete(sql = "UPDATE users SET deleted_at = NOW() WHERE id = ?")
@SQLRestriction("deleted_at IS NULL")
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
    private LocalDateTime createdAt;

    @Column(updatable = true)
    private LocalDateTime updatedAt;

    @Column(updatable = true)
    private LocalDateTime deletedAt;

    public UserEntity() { }

    public UserEntity(Long id, UUID uuid, String name, CompanyEntity company, List<SaleEntity> sales, List<PaymentEntity> payments, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.company = company;
        this.sales = sales;
        this.payments = payments;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public List<SaleEntity> getSales() {
        return sales;
    }

    public void setSales(List<SaleEntity> sales) {
        this.sales = sales;
    }

    public List<PaymentEntity> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentEntity> payments) {
        this.payments = payments;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
