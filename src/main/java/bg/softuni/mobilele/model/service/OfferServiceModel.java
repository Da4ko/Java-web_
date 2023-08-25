package bg.softuni.mobilele.model.service;

import bg.softuni.mobilele.model.entities.enums.EngineEnum;
import bg.softuni.mobilele.model.entities.enums.TransmissionEnum;
import bg.softuni.mobilele.model.validation.YearPastOrPresent;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class OfferServiceModel {

    @NotNull
    private EngineEnum engine;
    @NotNull
    private String imageUrl;
    @NotNull
    @Positive
    private Integer mileage;
    @DecimalMin("100")
    private BigDecimal price;
    @YearPastOrPresent(minYear = 1930)
    private Integer year;
    @NotEmpty
    @Size(min = 10, max = 512)
    private String description;
    @NotNull
    private TransmissionEnum transmissionEnum;
    @NotNull
    private Integer modelId;

    public EngineEnum getEngine() {
        return engine;
    }

    public void setEngine(EngineEnum engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TransmissionEnum getTransmissionEnum() {
        return transmissionEnum;
    }

    public void setTransmissionEnum(TransmissionEnum transmissionEnum) {
        this.transmissionEnum = transmissionEnum;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    @Override
    public String toString() {
        return "OfferServiceModel{" +
                "engine=" + engine +
                ", imageUrl='" + imageUrl + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", year=" + year +
                ", description='" + description + '\'' +
                ", transmissionEnum=" + transmissionEnum +
                ", modelId=" + modelId +
                '}';
    }
}
