package com.example.pi.impakto.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Modifying;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
// import com.example.pi.impakto.demo.dto.outdoor.OutdoorUpdateDTO;
import com.example.pi.impakto.demo.model.Outdoor;

// import jakarta.transaction.Transactional;


@Repository
public interface OutdoorRepository extends JpaRepository<Outdoor,Long> {
    
    // @Transactional
    // @Modifying
    // @Query("UPDATE Outdoor c SET c = :novoOutdoor WHERE c.outdoor = :outdoor")
    // public void updateByCliente(@Param("fotoOutdoor") Outdoor outdoor, @Param("novoOutdoor") OutdoorUpdateDTO novoOutdoor);


    Optional<Outdoor> findByFiguraOutdoor(String figura);

  
    Optional<Outdoor> findByStatusUso(Boolean statusUso);
    
}
