package com.kiit.supplychain.p2p_backend.repository;
import com.kiit.supplychain.p2p_backend.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
    List<Material> findByCurrentStockLessThanEqual(Integer minimumThreshold);
}