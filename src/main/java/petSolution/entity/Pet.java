package petSolution.entity;

import java.sql.Timestamp;

/**
 * @author aldo.tordoya
 *
 */
public class Pet implements Comparable<Pet> {
	private String type;
	private String name;
	private String gender;
	private Timestamp update;

	public Pet() {
	}

	/**
	 * @param type
	 * @param name
	 * @param gender
	 * @param update
	 */
	public Pet(String type, String name, String gender, Timestamp update) {
		this.type = type;
		this.name = name;
		this.gender = gender;
		this.update = update;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the update
	 */
	public Timestamp getUpdate() {
		return update;
	}

	/**
	 * @param update
	 *            the update to set
	 */
	public void setUpdate(Timestamp update) {
		this.update = update;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pet [type=" + type + ", name=" + name + ", gender=" + gender + ", update=" + update + "]";
	}

	public int compareTo(Pet anotherPet) {
		/*first compare by date and if date is the same compare by name*/
		int result = anotherPet.getUpdate().compareTo(this.getUpdate());
        
		if (result == 0) {
            result = this.getName().compareTo(anotherPet.getName());
        } 
        return result;
	}

	@Override
	public boolean equals(Object another) {
		boolean result = false;

		if (another == null)
			return false;
		if (another == this)
			return true;
		if (!(another instanceof Pet))
			return false;

		Pet anotherPet = (Pet) another;

		if ((anotherPet.type == null || anotherPet.type.equals(type))
				&& (anotherPet.name == null || anotherPet.name.equals(name))
				&& (anotherPet.gender == null || anotherPet.gender.equals(gender))) {
			result = true;
		}

		return result;
	}
}
