package sales.sysconp.microservice.featuresd.installment.application.dto;

import sales.sysconp.microservice.features.installment.domain.enums.InstallmentTypeEnum;
import sales.sysconp.microservice.features.installment.domain.enums.MonthEnum;

import java.time.LocalDateTime;

public class InstallmentCreatedResponseDTO {
    private Integer numInstallments;
    private LocalDateTime lastInstallmentDate;
    private InstallmentTypeEnum installmentType;
    private MonthEnum month;
    private Integer year;

    public InstallmentCreatedResponseDTO() {
    }

    public InstallmentCreatedResponseDTO(Integer numInstallments, LocalDateTime lastInstallmentDate, InstallmentTypeEnum installmentType, MonthEnum month, Integer year) {
        this.numInstallments = numInstallments;
        this.lastInstallmentDate = lastInstallmentDate;
        this.installmentType = installmentType;
        this.month = month;
        this.year = year;
    }

    public Integer getNumInstallments() {
        return numInstallments;
    }

    public void setNumInstallments(Integer numInstallments) {
        this.numInstallments = numInstallments;
    }

    public LocalDateTime getLastInstallmentDate() {
        return lastInstallmentDate;
    }

    public void setLastInstallmentDate(LocalDateTime lastInstallmentDate) {
        this.lastInstallmentDate = lastInstallmentDate;
    }

    public InstallmentTypeEnum getInstallmentType() {
        return installmentType;
    }

    public void setInstallmentType(InstallmentTypeEnum installmentType) {
        this.installmentType = installmentType;
    }

    public MonthEnum getMonth() {
        return month;
    }

    public void setMonth(MonthEnum month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
