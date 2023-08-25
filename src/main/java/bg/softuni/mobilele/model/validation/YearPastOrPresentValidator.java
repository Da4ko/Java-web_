package bg.softuni.mobilele.model.validation;

import bg.softuni.mobilele.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.YearMonth;

public class YearPastOrPresentValidator
        implements ConstraintValidator<YearPastOrPresent, Integer> {

    private int minYear;


    @Override
    public void initialize(YearPastOrPresent constraintAnnotation) {
       this.minYear = constraintAnnotation.minYear();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        if(value == null){
            return false;
        }
       int nowYear = YearMonth.now().getYear();
       return value >= minYear && value<=nowYear;
    }
}
