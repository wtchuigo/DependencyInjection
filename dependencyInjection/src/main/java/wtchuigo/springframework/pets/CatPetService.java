package wtchuigo.springframework.pets;

public class CatPetService implements PetService {

	@Override
	public String getPetType() {
		
		return "Cats Are the Best!";
	}

}
