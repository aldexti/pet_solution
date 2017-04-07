package petSolution;

import java.util.Arrays;
import java.util.List;

import petSolution.entity.Pet;
import petSolution.exception.PetSolutionException;
import petSolution.logic.PetManager;
import petSolution.logic.PetRepository;

/**
 * @author aldo.tordoya
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			if (args.length < 2) {
				throw new PetSolutionException("Required: CSV filepath, Operation to be performed, Pet params");
			}
			PetRepository.setPath(args[0]);
			PetRepository.setPets();
			PetManager pm = new PetManager();
			String[] petSolutionParams = Arrays.copyOfRange(args, 2, args.length);

			String operation = args[1].toLowerCase();
			switch (operation) {
			case "create":
				pm.createPet(petSolutionParams);
				for (Pet pet : PetRepository.getPets()) {
					System.out.println(pet);
				}
				break;
			case "delete":
				pm.deletePet(petSolutionParams);
				for (Pet pet : PetRepository.getPets()) {
					System.out.println(pet);
				}
				break;
			case "search":
				List<Pet> pets = pm.searchPets(petSolutionParams);
				for (Pet pet : pets) {
					System.out.println(pet);
				}
				break;
			default:
				throw new PetSolutionException("Operation not allowed");
			}
		} catch (PetSolutionException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
