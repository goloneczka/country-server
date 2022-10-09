package server.infrastructure.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface LocationRepository extends JpaRepository<LocationEntity, Long> {

    List<LocationEntity> findAll();

    Optional<LocationEntity> findById(Long id);

}
