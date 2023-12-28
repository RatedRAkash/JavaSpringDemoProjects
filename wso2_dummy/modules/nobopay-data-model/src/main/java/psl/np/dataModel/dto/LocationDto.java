package psl.np.dataModel.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import psl.np.dataModel.constant.EnumConstant.EventType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(max = 20)
    private String deviceId;
    @Size(max = 40)
    private String uuid;
    @NotNull
    private double latitude;
    @NotNull
    private double longitude;
    private Double accuracy;
    @NotNull
    private EventType eventType;
    @Size(max = 100)
    private String eventReference;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getEventReference() {
        return eventReference;
    }

    public void setEventReference(String eventReference) {
        this.eventReference = eventReference;
    }

    @Override
    public String toString() {
        return "LocationDto{" +
                "deviceId='" + deviceId + '\'' +
                ", uuid='" + uuid + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", accuracy=" + accuracy +
                ", eventType=" + eventType +
                ", eventReference='" + eventReference + '\'' +
                '}';
    }
}
