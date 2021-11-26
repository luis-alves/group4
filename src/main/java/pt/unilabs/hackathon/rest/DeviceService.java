package pt.unilabs.hackathon.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pt.unilabs.hackathon.entities.Device;
import pt.unilabs.hackathon.dtos.MeasureDTO;
import pt.unilabs.hackathon.entities.Measure;
import pt.unilabs.hackathon.repositories.DeviceRepository;
import pt.unilabs.hackathon.repositories.MeasuresRepository;
import pt.unilabs.hackathon.repositories.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <Class description>
 *
 * @author Luís Alves
 */
@RestController
@RequestMapping(path = "/api/v1/measures")
@RequiredArgsConstructor
public class DeviceService {

    final private MeasuresRepository measuresRepository;
    final private DeviceRepository deviceRepository;
    final private UserRepository userRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void receiveData(@RequestBody MeasureDTO measureDto) {

        Optional<Device> optionalDevice = deviceRepository.findByMacId(measureDto.getDeviceId());

        if (optionalDevice.isPresent()) {
            measuresRepository.save(Measure.toEntity(measureDto));
            return;
        }

        createDeviceAndPersistMeasure(measureDto);
    }

    private void createDeviceAndPersistMeasure(MeasureDTO measureDto) {
        deviceRepository.save(Device.toEntity(measureDto.getDeviceId()));

        measuresRepository.save(Measure.toEntity(measureDto));
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private List<MeasureDTO> getUserLastMeasures(@RequestParam("deviceId") String deviceId, @RequestParam("limit") Integer limit) {

        //@formatter:off
        return measuresRepository.getByDeviceId(deviceId, limit)
                                .stream()
                                .map(this::buildResponse)
                                .collect(Collectors.toList());
        //@formatter:on
    }

    private MeasureDTO buildResponse(Measure measure) {

        return null;


    }
}
