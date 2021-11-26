package pt.unilabs.hackathon.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import pt.unilabs.hackathon.entities.Measure;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * <Class description>
 *
 * @author Luís Alves
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MeasureDTO {

    private String email;

    private String username;

    @JsonProperty("HR")
    private Integer heartRate;

    @JsonProperty("Confidence")
    private Integer confidence;

    @JsonProperty("SpO2")
    private Integer spo2;

    @JsonProperty("Status")
    private Integer status;

    @JsonProperty("Object Temperature")
    private Double objectTemperature;

    @JsonProperty("Ambient Temperature")
    private Double ambientTemperature;

    @JsonProperty("Device Id")
    public String deviceId;

}
