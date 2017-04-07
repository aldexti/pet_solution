package petSolution.exception;

/**
 * @author aldo.tordoya
 *
 */
public class PetSolutionException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7390710769732097542L;
	private String message;

	public PetSolutionException() {
		super();
	}

	/**
	 * @param message
	 */
	public PetSolutionException(String message) {
		super();
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
