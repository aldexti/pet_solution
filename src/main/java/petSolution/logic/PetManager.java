package petSolution.logic;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import petSolution.entity.Pet;

/**
 * @author aldo.tordoya
 *
 */
public class PetManager {

	/**
	 * @param args
	 * @throws Exception
	 */
	public void createPet(String[] args) throws Exception {
		Pet pet = PetParser.parse(args);
		Timestamp update = new Timestamp(new Date().getTime());
		pet.setUpdate(update);		
		PetRepository.getPets().add(pet);
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public void deletePet(String[] args) throws Exception {
		Pet pet = PetParser.parse(args);
		PetRepository.getPets().remove(pet);
	}

	/**
	 * @param args
	 * @return
	 * @throws Exception
	 */
	public List<Pet> searchPets(String[] args) throws Exception {
		List<Pet> searchResult = new ArrayList<Pet>();
		Pet searchCriterias = PetParser.parse(args);

		List<Pet> pets = PetRepository.getPets();
		if (args.length > 0) {
			for (Pet pet : pets) {
				if (pet.equals(searchCriterias)) {
					searchResult.add(pet);
				}
			}
		} else {
			searchResult.addAll(pets);
		}

		Collections.sort(searchResult);

		return searchResult;
	}

}
