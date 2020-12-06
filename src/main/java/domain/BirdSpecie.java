package domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class BirdSpecie {
	@NotEmpty
	private String name;
	@NotNull
	@Min(value = 1250, message = "{validation.birdspecie.year}")
	private Integer yearOfDiscovery;
	@NotEmpty
	@Pattern(regexp = "[A-Z]{1,2}[0-9]{3}", message = "{validation.birdspecie.code}") // [A-Z]{1,2}\d{3}
	private String code;

	public BirdSpecie(String name, Integer yearOfDiscovery, String code) {
		super();
		this.name = name;
		this.yearOfDiscovery = yearOfDiscovery;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYearOfDiscovery() {
		return yearOfDiscovery;
	}

	public void setYearOfDiscovery(Integer yearOfDiscovery) {
		this.yearOfDiscovery = yearOfDiscovery;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return String.format("%s - %d (%s)", getName(), getYearOfDiscovery(), getCode());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		BirdSpecie other = (BirdSpecie) obj;
		if (!code.equals(other.code))
			return false;
		return name.equalsIgnoreCase(other.name);

	}

}
