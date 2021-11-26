package pt.unilabs.hackathon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.unilabs.hackathon.entities.Device;

import java.util.Optional;

/**
 * <Class description>
 *
 * @author Luís Alves
 */
@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {

    Optional<Device> findByMacId(String deviceId);
}
