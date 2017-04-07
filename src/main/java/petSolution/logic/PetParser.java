package petSolution.logic;

import java.lang.reflect.Field;

import petSolution.entity.Pet;

/**
 * @author aldo.tordoya
 *
 */
public class PetParser {
	/**
	 * @param args
	 * @return
	 * @throws Exception
	 */
	public static Pet parse(String[] args) throws Exception {
		Pet pet = new Pet();
		for (String parameter : args) {
			
			String[] keyValue = parameter.split("=");
			String key = keyValue[0];
			String value = keyValue[1];

			Field field = pet.getClass().getDeclaredField(key);
			field.setAccessible(true);
			field.set(pet, value);
		}

		return pet;
	}
}
