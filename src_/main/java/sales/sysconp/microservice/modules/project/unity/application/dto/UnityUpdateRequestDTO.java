package sales.sysconp.microservice.modules.project.unity.application.dto;

import sales.sysconp.microservice.modules.project.unity.domain.enums.UnityStatusEnum;

import java.time.LocalDateTime;

public class UnityUpdateRequestDTO {
    private String name;

    private UnityStatusEnum unityStatus;

    private LocalDateTime updatedAt;

    public String getName() {
        return name;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public UnityStatusEnum getUnityStatus() {
        return unityStatus;
    }
}
