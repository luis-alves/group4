package pt.unilabs.hackathon.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import pt.unilabs.hackathon.dtos.MeasureDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * <Class description>
 *
 * @author Luís Alves
 */
@Entity
@Table(name = "measures")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Measure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "device_id")
    private String deviceId;

    @Column(name = "heart_rate")
    private Integer heartRate;

    @Column(name = "confidence")
    private Integer confidence;

    @Column(name = "spo2")
    private Integer spo2;

    @Column(name = "status")
    private Integer status;

    @Column(name = "object_temperature")
    private Double objectTemperature;

    @Column(name = "ambient_temperature")
    private Double ambientTemperature;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    //@formatter:off
    public Measure(String deviceId,
                  Integer heartRate,
                  Integer confidence,
                  Integer spo2,
                  Integer status,
                  Double objectTemperature,
                  Double ambientTemperature) { //@formatter:on

        this.deviceId = deviceId;
        this.heartRate = heartRate;
        this.confidence = confidence;
        this.spo2 = spo2;
        this.status = status;
        this.objectTemperature = objectTemperature;
        this.ambientTemperature = ambientTemperature;
    }

    public static Measure toEntity(MeasureDTO measureDto) {
        //@formatter:off
        return new Measure(measureDto.deviceId,
                         measureDto.getHeartRate(),
                         measureDto.getConfidence(),
                         measureDto.getSpo2(),
                         measureDto.getStatus(),
                         measureDto.getObjectTemperature(),
                         measureDto.getAmbientTemperature());
        //@formatter:on
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Measure measure = (Measure) o;
        return Objects.equals(id, measure.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Measure.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("deviceId='" + deviceId + "'")
                .add("heartRate=" + heartRate)
                .add("confidence=" + confidence)
                .add("spo2=" + spo2)
                .add("status=" + status)
                .add("objectTemperature=" + objectTemperature)
                .add("ambientTemperature=" + ambientTemperature)
                .toString();
    }
}
