package validator;

import java.time.Year;
import java.util.Set;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import domain.BirdSpecie;

public class BirdSpecieValidator implements Validator {

	 @Override
	    public boolean supports(Class<?> klass) {
	        return BirdSpecieValidator.class.isAssignableFrom(klass);
	    }

		@Override
		public void validate(Object target, Errors errors) {
			BirdSpecie bs = (BirdSpecie) target;
			if(bs.getYearOfDiscovery()!=null) {
				if(bs.getYearOfDiscovery()>Year.now().getValue()) {
					errors.rejectValue("yearOfDiscovery",
		                    "birdSpecie.yearOfDiscovery.largerThanCurrentYear",
		                    "You cannot discover birds in the future!");
				}
			}
		}

}
