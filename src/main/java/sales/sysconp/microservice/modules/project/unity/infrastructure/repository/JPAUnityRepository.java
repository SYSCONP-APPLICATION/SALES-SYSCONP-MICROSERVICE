package sales.sysconp.microservice.modules.project.unity.infrastructure.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sales.sysconp.microservice.modules.project.unity.domain.enums.UnityStatusEnum;
import sales.sysconp.microservice.modules.project.unity.infrastructure.entities.UnityEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JPAUnityRepository extends JpaRepository<UnityEntity, Long> {
    Optional<UnityEntity> findByIdAndPropertyId(Long id, Long propertyId);

    Optional<UnityEntity> findByUuid(UUID uuid);

    List<UnityEntity> findByStatusAndPropertyId(UnityStatusEnum status, Long propertyId);

    Optional<UnityEntity> findByUuidAndPropertyId(UUID uuid, Long propertyId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE unities SET status = :status WHERE id IN (:unityIds)", nativeQuery = true)
    int updateStatusesByIds(@Param("status") UnityStatusEnum status, @Param("unityIds") List<Long> unityIds);

    @Query("SELECT u FROM UnityEntity u WHERE u.id IN :ids")
    List<UnityEntity> findAllByIds(@Param("ids") List<Long> ids);

    List<UnityEntity> findByPropertyId(Long propertyId);

    @Query(value = "SELECT u FROM UnityEntity u WHERE u.id IN (:unitiesArray) AND u.status = :status")
    List<UnityEntity> findUnitiesInArrayAndStatus(@Param("unitiesArray") List<Long> unitiesArray, @Param("status") UnityStatusEnum status);

    List<UnityEntity> findBySaleId(Long saleId);
}
