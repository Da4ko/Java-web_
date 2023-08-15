package bg.softuni.mobilele.model;

import bg.softuni.mobilele.model.entities.*;
import bg.softuni.mobilele.model.entities.enums.EngineEnum;
import bg.softuni.mobilele.model.entities.enums.ModelCategoryEnum;
import bg.softuni.mobilele.model.entities.enums.TransmissionEnum;
import bg.softuni.mobilele.repository.BrandRepository;
import bg.softuni.mobilele.repository.ModelRepository;
import bg.softuni.mobilele.repository.OfferRepository;
import bg.softuni.mobilele.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Component
public class DBInit implements CommandLineRunner {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DBInit(ModelRepository modelRepository,
                  BrandRepository brandRepository,
                  OfferRepository offerRepository,
                  UserRepository userRepository,
                  PasswordEncoder passwordEncoder) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        BrandEntity fordBrand = new BrandEntity();
        fordBrand.setName("Ford");
        setCurrentTimestamps(fordBrand);



        BrandEntity hondaBrand = new BrandEntity();
        hondaBrand.setName("Honda");
        setCurrentTimestamps(hondaBrand);


        brandRepository.saveAll(List.of(fordBrand, hondaBrand));

        ModelEntity fiestaModel = initFiesta(fordBrand);
        initEscort(fordBrand);
        initNC750S(hondaBrand);
        createFiestaOffer(fiestaModel);

        initAdmin();
    }
    private void initAdmin(){
        UserEntity admin = new UserEntity();
        admin.setFirstName("Petyr");
        admin.setLastName("Dimitrov");
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("topsecret"));
        setCurrentTimestamps(admin);
        userRepository.save(admin);

    }

    private ModelEntity initFiesta(BrandEntity fordBrand) {
        ModelEntity fiesta = new ModelEntity();

        fiesta.setName("Fiesta");
        fiesta.setCategory(ModelCategoryEnum.CAR);
        fiesta.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwMtbRUS0Pa3Tf2FhkmINOPQsEr4x0_x_GdvxvHgMIUg&s");
        fiesta.setStartYear(1976);
        fiesta.setBrand(fordBrand);
        setCurrentTimestamps(fiesta);

        return modelRepository.save(fiesta);
    }
    private ModelEntity initEscort(BrandEntity fordBrand) {
        ModelEntity escort = new ModelEntity();

        escort.setName("Escort");
        escort.setCategory(ModelCategoryEnum.CAR);
        escort.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/3/39/Ford_Escort_RS2000_MkI.jpg/280px-Ford_Escort_RS2000_MkI.jpg");
        escort.setStartYear(1968);
        escort.setEndYear(2002);
        escort.setBrand(fordBrand);
        setCurrentTimestamps(escort);

        return modelRepository.save(escort);
    }
    private void createFiestaOffer(ModelEntity modelEntity){
        OfferEntity fiestaOffer = new OfferEntity();

        fiestaOffer.setEngine(EngineEnum.GASOLINE);
        fiestaOffer.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/2017_Ford_Fiesta_Zetec_1.1_Front.jpg/280px-2017_Ford_Fiesta_Zetec_1.1_Front.jpg");
        fiestaOffer.setMileage(80000);
        fiestaOffer.setPrice(BigDecimal.valueOf(10000));
        fiestaOffer.setYear(2019);
        fiestaOffer.setDescription("Karana e ot nemska baba");
        fiestaOffer.setTransmissionEnum(TransmissionEnum.MANUAL);
        fiestaOffer.setModel(modelEntity);
        setCurrentTimestamps(fiestaOffer);
        offerRepository.save(fiestaOffer);
    }
    private ModelEntity initNC750S(BrandEntity hondaBrand){
        ModelEntity nc750s = new ModelEntity();

        nc750s.setName("NC750S");
        nc750s.setCategory(ModelCategoryEnum.MOTORCYCLE);
            nc750s.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/2012_Honda_NC700SA.jpg/300px-2012_Honda_NC700SA.jpg");
        nc750s.setStartYear(2014);
        nc750s.setBrand(hondaBrand);
        setCurrentTimestamps(nc750s);

        return modelRepository.save(nc750s);
    }

    private static void setCurrentTimestamps(BaseEntity baseEntity){
        baseEntity.setCreated(Instant.now());
        baseEntity.setUpdated(Instant.now());
    }
}
