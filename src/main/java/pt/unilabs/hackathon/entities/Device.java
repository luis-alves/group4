package pt.unilabs.hackathon.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Class description>
 *
 * @author Luís Alves
 */
@Entity
@Table(name = "devices")
@NoArgsConstructor
@AllArgsConstructor
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "mac_id")
    private String macId;

    public Device(String macId) {
        this.macId = macId;
    }

    public static Device toEntity(String deviceId) {
        return new Device(deviceId);
    }
}
