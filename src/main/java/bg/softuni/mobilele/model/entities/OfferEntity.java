package bg.softuni.mobilele.model.entities;

import bg.softuni.mobilele.model.entities.enums.EngineEnum;
import bg.softuni.mobilele.model.entities.enums.TransmissionEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private EngineEnum engine;

    private String imageUrl;

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private int mileage;

    private BigDecimal price;

    private int year;

    @Enumerated(EnumType.STRING)
    private TransmissionEnum transmissionEnum;

    @ManyToOne
    private ModelEntity model;

    //TODO
   // public UserEntity getUser() {
   //     return user;
   // }
//
   // public void setUser(UserEntity user) {
   //     this.user = user;
   // }
//
   // @ManyToOne
   //  private UserEntity user;

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

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public TransmissionEnum getTransmissionEnum() {
        return transmissionEnum;
    }

    public void setTransmissionEnum(TransmissionEnum transmissionEnum) {
        this.transmissionEnum = transmissionEnum;
    }

    public ModelEntity getModel() {
        return model;
    }

    public void setModel(ModelEntity model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "OfferEntity{" +
                "engine=" + engine +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", year=" + year +
                ", transmissionEnum=" + transmissionEnum +
                ", model=" + model +
                ", id=" + id +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
