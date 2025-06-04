/**
 * The PieceWorker class represents an employee who is paid based on the
 * number of pieces they sell.
 * 
 * Written by Natanel Fishman for Maman 12, Question 1.
 */

// Represents an employee paid by the piece
public class PieceWorker extends Employee {
	private int piecesSold; // Number of pieces sold
	private double salaryPerPiece; // Salary for each piece

	/**
	 * Constructor.
	 *
	 * @param firstName            First name of the employee.
	 * @param lastName             Last name of the employee.
	 * @param socialSecurityNumber Social security number of the employee.
	 * @param piecesSold           Number of pieces sold.
	 * @param salaryPerPiece       Salary for each piece.
	 * @param year                 Year of birth of the employee.
	 * @param month                Month of birth of the employee.
	 * @param dayOfMonth           Day of birth of the employee.
	 */
	public PieceWorker(String firstName, String lastName, String socialSecurityNumber, int piecesSold,
			double salaryPerPiece, int year, int month, int dayOfMonth) {
		super(firstName, lastName, socialSecurityNumber, year, month, dayOfMonth);

		// Validation for piecesSold
		if (piecesSold < 0) {
			throw new IllegalArgumentException("Number of pieces sold must be >= 0");
		}
		// Validation for salaryPerPiece
		if (salaryPerPiece < 0) {
			throw new IllegalArgumentException("Salary for each piece must be >= 0");
		}

		// Assigning values
		this.piecesSold = piecesSold;
		this.salaryPerPiece = salaryPerPiece;
	}

	/**
	 * Set method for piecesSold.
	 *
	 * @param piecesSold Number of pieces sold.
	 */
	public void setPiecesSold(int piecesSold) {
		// Validation
		if (piecesSold < 0.0) {
			throw new IllegalArgumentException("Number of pieces sold must be >= 0");
		}

		// Setting the value
		this.piecesSold = piecesSold;
	}

	/**
	 * Get method for piecesSold.
	 *
	 * @return Number of pieces sold.
	 */
	public double getPiecesSold() {
		return piecesSold;
	}

	/**
	 * Set method for salaryPerPiece.
	 *
	 * @param salaryPerPiece Salary for each piece.
	 */
	public void setSalaryPerPiece(double salaryPerPiece) {
		// Validation
		if (salaryPerPiece < 0) {
			throw new IllegalArgumentException("Salary for each piece must be >= 0");
		}
		// Setting the value
		this.salaryPerPiece = salaryPerPiece;
	}

	/**
	 * Get method for salaryPerPiece.
	 *
	 * @return Salary for each piece.
	 */
	public double getSalaryPerPiece() {
		return salaryPerPiece;
	}

	/**
	 * Method to calculate earnings; override abstract method earnings in Employee.
	 *
	 * @return Earnings of the piece worker.
	 */
	@Override
	public double earnings() {
		return getPiecesSold() * getSalaryPerPiece();
	}

	/**
	 * String representation of PieceWorker object.
	 *
	 * @return Formatted string representation.
	 */
	@Override
	public String toString() {
		return String.format("%s: %s%n%s: $%,.2f; %s: $%.2f", "Piece worker employee", super.toString(), "Pieces sold",
				getPiecesSold(), "Salary per piece", getSalaryPerPiece());
	}
}