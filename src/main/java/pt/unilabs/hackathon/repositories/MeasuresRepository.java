package pt.unilabs.hackathon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pt.unilabs.hackathon.entities.Measure;

import java.util.List;

/**
 * <Class description>
 *
 * @author Luís Alves
 */
@Repository
public interface MeasuresRepository extends JpaRepository<Measure, Integer> {

    @Query(value = "SELECT * FROM measures m where m.device_id = :deviceId order by m.created_at desc limit :limit", nativeQuery = true)
    List<Measure> getByDeviceId(@Param("deviceId") String deviceId, @Param("limit") Integer limit);
}
