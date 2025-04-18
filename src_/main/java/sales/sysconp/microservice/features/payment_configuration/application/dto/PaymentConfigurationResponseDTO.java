package sales.sysconp.microservice.features.payment_configuration.application.dto;

import sales.sysconp.microservice.features.sale.domain.models.SaleModel;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentConfigurationResponseDTO {
    private Long id;
    private UUID uuid;
    private Long dayOfMonth;
    private SaleModel sale;
    private Long applyDebtAfter;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PaymentConfigurationResponseDTO () {}

    public PaymentConfigurationResponseDTO(Long id, UUID uuid, Long dayOfMonth, SaleModel sale, Long applyDebtAfter, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.uuid = uuid;
        this.dayOfMonth = dayOfMonth;
        this.sale = sale;
        this.applyDebtAfter = applyDebtAfter;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public SaleModel getSale() {
        return sale;
    }

    public void setSale(SaleModel sale) {
        this.sale = sale;
    }

    public Long getApplyDebtAfter() {
        return applyDebtAfter;
    }

    public void setApplyDebtAfter(Long applyDebtAfter) {
        this.applyDebtAfter = applyDebtAfter;
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
}