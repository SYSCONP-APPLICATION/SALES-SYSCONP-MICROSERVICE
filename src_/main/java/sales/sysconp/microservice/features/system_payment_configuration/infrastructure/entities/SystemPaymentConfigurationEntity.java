package sales.sysconp.microservice.features.system_payment_configuration.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;

import sales.sysconp.microservice.modules.auth.company.infrastructure.entities.CompanyEntity;

@Entity
@Table(name = "system_payment_configurations")
@SQLDelete(sql = "UPDATE system_payment_configurations SET deleted_at = NOW() WHERE id = ?")
@SQLRestriction("deleted_at IS NULL")
public class SystemPaymentConfigurationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;

    @PrePersist()
    public void generateUUID () {
        this.uuid = UUID.randomUUID();
    }
    
    @Column(nullable = false)
    private Long dayOfMonth;

    @Column(nullable = false)
    private Long applyDebtAfter;

    @Column(nullable = false)
    private boolean requireOnCreateSale;

    @Column(nullable = false)
    private boolean requireForAllSales;

    @Column(nullable = false)
    private Long newMonthAfterDate;

    @OneToOne()
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private CompanyEntity company;

    @Column(updatable = false)  
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(updatable = true)  
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(updatable = true)
    private LocalDateTime deletedAt;

    public SystemPaymentConfigurationEntity() {
    }

    public SystemPaymentConfigurationEntity(Long id, UUID uuid, Long dayOfMonth, Long applyDebtAfter, Long newMonthAfterDate, boolean requireOnCreateSale, boolean requireForAllSales, CompanyEntity company, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.id = id;
        this.uuid = uuid;
        this.dayOfMonth = dayOfMonth;
        this.requireOnCreateSale = requireOnCreateSale;
        this.requireForAllSales = requireForAllSales;
        this.newMonthAfterDate = newMonthAfterDate;
        this.company = company;
        this.applyDebtAfter = applyDebtAfter;
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

    public Long getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(Long dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public Long getApplyDebtAfter() {
        return applyDebtAfter;
    }

    public void setApplyDebtAfter(Long applyDebtAfter) {
        this.applyDebtAfter = applyDebtAfter;
    }

    public boolean isRequireOnCreateSale() {
        return requireOnCreateSale;
    }

    public void setRequireOnCreateSale(boolean requireOnCreateSale) {
        this.requireOnCreateSale = requireOnCreateSale;
    }

    public boolean isRequireForAllSales() {
        return requireForAllSales;
    }

    public void setRequireForAllSales(boolean requireForAllSales) {
        this.requireForAllSales = requireForAllSales;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
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

    public Long getNewMonthAfterDate() {
        return newMonthAfterDate;
    }

    public void setNewMonthAfterDate(Long newMonthAfterDate) {
        this.newMonthAfterDate = newMonthAfterDate;
    }
}