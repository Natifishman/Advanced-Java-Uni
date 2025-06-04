
/**
 * The RandomData class generates random data for testing the employee management program.
 * 
 * Written by Natanel Fishman for Maman 12, Question 1.
 */

import java.util.Random;

//RandomData generates an array of random employees of different types for testing.
public final class RandomData {
	private final static double EXCEPTION_VALUE = -1.0;
	private static final int EMPLOYEE_TYPES = 5;
	private final static int MAX_MONTHS = 12;
	private final static int MAX_DAYS = 28;
	private final static int TIME_RANGE = 65;
	private final static int MIN_YEARS = 1935;

	// Arrays of random data
	// Array of first names - Even with the lecturer's first name!
	private static final String[] firstNames = { "Abigail", "Adam", "Adele", "Agam", "Aharon", "Alma", "Ariel", "Ari",
			"Ayala", "Benjamin", "Bnaya", "Chaim", "Chana", "Chen", "Chaya", "Daniel", "David", "Efrat", "Elah",
			"Eitan", "Eliya", "Emma", "Esther", "Gaia", "Gefen", "Hallel", "Harel", "Hodaya", "Ido", "Imri", "Itai",
			"Itamar", "Lavi", "Leah", "Lia", "Libi", "Maya", "Meir", "Michael", "Michal", "Miriam", "Malka",
			"Mordechai", "Moshe", "Natanel", "Noga", "Noa", "Noam", "Noya", "Omer", "Omer", "Rachel", "Raphael",
			"Rivka", "Roni", "Romi", "Ruth", "Sara", "Shaily", "Shira", "Shimon", "Shlomo", "Shmuel", "Talia", "Tamar",
			"Uri", "Yaakov", "Yael", "Yair", "Yanai", "Yehonatan", "Yehuda", "Yisrael", "Yitzchak", "Yonatan", "Yuval",
			"Yishai", "Yosef", "Yanai" };

	// Array of last names - Even with the lecturer's last name!
	private static final String[] lastNames = { "Abrams", "Abramson", "Becker", "Blau", "Blum", "Cantor", "Cohen",
			"Cooperman", "Diamond", "Ehrlich", "Eisen", "Elkayim", "Fingerhut", "Fishman", "Gelb", "Geller", "Gold",
			"Goldberg", "Goldman", "Goldschmidt", "Green", "Greenberg", "Hakimi", "Horowitz", "Kaplan", "Katz",
			"Kauffman", "Koppelman", "Koval", "Kravitz", "Leib", "Levi", "Levin", "Lieberman", "Maggid", "Margolis",
			"Maze", "Melamed", "Mirzayev", "Mizrahi", "Nudel", "Perlman", "Portnoy", "Rabin", "Rabinowitz", "Rivkin",
			"Rivlin", "Roth", "Sas", "Sasson", "Sebag", "Schechter", "Schneider", "Schreiber", "Schwartz", "Segal",
			"Shapiro", "Singer", "Shamash", "Shulman", "Soros", "Stern", "Ulmer", "Weiss", "Weinberg", "Wexler" };

	// Array of social security numbers - It is not stated that it is necessary for
	// the assignment but it is present in the example in the book so I was not sure
	private static final String[] socialSecurityNumbers = { "000-00-0000", "111-11-1111", "222-22-2222", "333-33-3333",
			"444-44-4444", "555-55-5555", "666-66-6666", "777-77-7777", "888-88-8888", "999-99-9999", "012-34-5678",
			"123-45-6789", "234-56-7890", "345-67-8901", "456-78-9012", "567-89-0123", "678-90-1234", "789-01-2345",
			"890-12-3456", "901-23-4567", "210-32-5432", "321-43-6543", "432-54-7654", "543-65-8765", "654-76-9876",
			"765-87-0987", "876-98-1098", "987-09-2109", "321-09-8765", "432-10-9876", "543-21-0987", "654-32-1098",
			"765-43-2109", "876-54-3210", "987-65-4321", "210-98-7654", "321-09-8765", "432-10-9876", "543-21-0987",
			"654-32-1098", "765-43-2109", "876-54-3210", "987-65-4321", "210-98-7654", "321-09-8765", "432-10-9876",
			"543-21-0987", "654-32-1098", "765-43-2109", "876-54-3210", "987-65-4321", "210-98-7654", "321-09-8765",
			"432-10-9876", "543-21-0987", "654-32-1098", "765-43-2109", "876-54-3210", "987-65-4321" };

	private static enum EmployeeType { // Arranged alphabetically
		BASE_PLUS_COMMISSION, COMMISSION, HOURLY, PIECE_WORKER, SALARIED
	}

	private static final EmployeeType[] employeeTypes = EmployeeType.values();

	private static final Random rnd = new Random();

	// Private constructor to prevent instantiation
	private RandomData() {
	}

	/**
	 * Generates an array of random employees
	 *
	 * @return Array of randomly generated employees.
	 */
	public static Employee[] generateRandomEmployeeData() {
		Employee[] employees = new Employee[EMPLOYEE_TYPES];
		for (int i = 0; i < employees.length; i++) {
			EmployeeType employeeType = employeeTypes[i];
			String firstName = firstNames[rnd.nextInt(firstNames.length)];
			String lastName = lastNames[rnd.nextInt(lastNames.length)];
			String socialSecurityNumber = socialSecurityNumbers[rnd.nextInt(socialSecurityNumbers.length)];
			int dayOfBirth = rnd.nextInt(MAX_DAYS) + 1; // 1 to 28. Limiting to 28 for simplicity(Exceptions).
			int monthOfBirth = rnd.nextInt(MAX_MONTHS); // 0 to 11, months are zero valued
			int yearOfBirth = rnd.nextInt(TIME_RANGE) + MIN_YEARS; // 1935 to 1999
			switch (employeeType) {
			case COMMISSION:
				employees[i] = getRandomCommissionEmployee(firstName, lastName, socialSecurityNumber, yearOfBirth,
						monthOfBirth, dayOfBirth);
				break;
			case BASE_PLUS_COMMISSION:
				employees[i] = getRandomBasePlusCommissionEmployee(firstName, lastName, socialSecurityNumber,
						yearOfBirth, monthOfBirth, dayOfBirth);
				break;
			case HOURLY:
				employees[i] = getRandomHourlyEmployee(firstName, lastName, socialSecurityNumber, yearOfBirth,
						monthOfBirth, dayOfBirth);
				break;
			case SALARIED:
				employees[i] = getRandomSalariedEmployee(firstName, lastName, socialSecurityNumber, yearOfBirth,
						monthOfBirth, dayOfBirth);
				break;
			case PIECE_WORKER:
				employees[i] = getRandomPieceWorkerEmployee(firstName, lastName, socialSecurityNumber, yearOfBirth,
						monthOfBirth, dayOfBirth);
				break;
			default:
				System.err.println("Unknown employee type encountered.");
				break;
			}
		}
		return employees;
	}

	/**
	 * Generates an array of random exception employees.
	 *
	 * @return Array of randomly generated employees.
	 */
	public static Employee[] generateExceptionEmployeeData() {
		Employee[] employees = new Employee[EMPLOYEE_TYPES];
		for (int i = 0; i < employees.length; i++) {
			EmployeeType employeeType = employeeTypes[i];
			String firstName = firstNames[rnd.nextInt(firstNames.length)];
			String lastName = lastNames[rnd.nextInt(lastNames.length)];
			String socialSecurityNumber = socialSecurityNumbers[rnd.nextInt(socialSecurityNumbers.length)];
			int dayOfBirth = rnd.nextInt(MAX_DAYS) + 1; // 1 to 28. Limiting to 28 for simplicity(Exceptions).
			int monthOfBirth = rnd.nextInt(MAX_MONTHS); // 0 to 11, months are zero valued
			int yearOfBirth = rnd.nextInt(TIME_RANGE) + MIN_YEARS; // 1935 to 1999
			try {
				switch (employeeType) {
				case COMMISSION:
					employees[i] = getExceptionCommissionEmployee(firstName, lastName, socialSecurityNumber,
							yearOfBirth, monthOfBirth, dayOfBirth);
					break;
				case BASE_PLUS_COMMISSION:
					employees[i] = getExceptionBasePlusCommissionEmployee(firstName, lastName, socialSecurityNumber,
							yearOfBirth, monthOfBirth, dayOfBirth);
					break;
				case HOURLY:
					employees[i] = getExceptionHourlyEmployee(firstName, lastName, socialSecurityNumber, yearOfBirth,
							monthOfBirth, dayOfBirth);
					break;
				case SALARIED:
					employees[i] = getExceptionSalariedEmployee(firstName, lastName, socialSecurityNumber, yearOfBirth,
							monthOfBirth, dayOfBirth);
					break;
				case PIECE_WORKER:
					employees[i] = getExceptionPieceWorkerEmployee(firstName, lastName, socialSecurityNumber,
							yearOfBirth, monthOfBirth, dayOfBirth);
					break;
				default:
					System.err.println("Unknown employee type encountered.");
					break;
				}
			} catch (IllegalArgumentException e) {
				System.out.println("Exception occurred while generating employee: " + e.getMessage());
				// For now, we'll just set this slot in the array to null.
				employees[i] = null;
			}
		}
		return employees;
	}

	// Per instructions, avoid "magic numbers" in the program body, using named
	// constants in uppercase(e.g., NUM_MAX).
	// However, for minor calculations, numbers are left as-is for developer
	// convenience, as the instructions don't specify the granularity of detail
	// required and this is not a mandatory class in the assignment.

	/**
	 * Generates a random commission employee.
	 *
	 * @param firstName            First name of the employee.
	 * @param lastName             Last name of the employee.
	 * @param socialSecurityNumber Social security number of the employee.
	 * @param yearOfBirth          Year of birth of the employee.
	 * @param monthOfBirth         Month of birth of the employee.
	 * @param dayOfBirth           Day of birth of the employee.
	 * @return Randomly generated CommissionEmployee object.
	 */
	private static CommissionEmployee getRandomCommissionEmployee(String firstName, String lastName,
			String socialSecurityNumber, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
		double grossSales = rnd.nextDouble() * 55000 + 5000; // 5000 to 60000
		double commissionRate = rnd.nextDouble() / 10 + 0.1; // 0.1 to 0.2
		return new CommissionEmployee(firstName, lastName, socialSecurityNumber, grossSales, commissionRate,
				yearOfBirth, monthOfBirth, dayOfBirth);
	}

	/**
	 * Generates a random piece worker employee.
	 *
	 * @param firstName            First name of the employee.
	 * @param lastName             Last name of the employee.
	 * @param socialSecurityNumber Social security number of the employee.
	 * @param yearOfBirth          Year of birth of the employee.
	 * @param monthOfBirth         Month of birth of the employee.
	 * @param dayOfBirth           Day of birth of the employee.
	 * @return Randomly generated PieceWorkerEmployee object.
	 */
	private static PieceWorker getRandomPieceWorkerEmployee(String firstName, String lastName,
			String socialSecurityNumber, int yearOfBirth, int monthOfBirth, int dayOfBirth) {

		int piecesSold = rnd.nextInt(3000); // 0 to 2999 pieces
		double salaryPerPiece = rnd.nextDouble() * 10; // 0 to 10.0 per piece
		return new PieceWorker(firstName, lastName, socialSecurityNumber, piecesSold, salaryPerPiece, yearOfBirth,
				monthOfBirth, dayOfBirth);
	}

	/**
	 * Generates a random hourly employee.
	 *
	 * @param firstName            First name of the employee.
	 * @param lastName             Last name of the employee.
	 * @param socialSecurityNumber Social security number of the employee.
	 * @param yearOfBirth          Year of birth of the employee.
	 * @param monthOfBirth         Month of birth of the employee.
	 * @param dayOfBirth           Day of birth of the employee.
	 * @return Randomly generated HourlyEmployee object.
	 */
	private static HourlyEmployee getRandomHourlyEmployee(String firstName, String lastName,
			String socialSecurityNumber, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
		double wage = rnd.nextDouble() * 30 + 10; // 10 to 40 $ per hour
		double hours = rnd.nextDouble() * 168; // 0.0 to 168.0 hours
		return new HourlyEmployee(firstName, lastName, socialSecurityNumber, wage, hours, yearOfBirth, monthOfBirth,
				dayOfBirth);
	}

	/**
	 * Generates a random base plus commission employee.
	 *
	 * @param firstName            First name of the employee.
	 * @param lastName             Last name of the employee.
	 * @param socialSecurityNumber Social security number of the employee.
	 * @param yearOfBirth          Year of birth of the employee.
	 * @param monthOfBirth         Month of birth of the employee.
	 * @param dayOfBirth           Day of birth of the employee.
	 * @return Randomly generated BasePlusCommissionEmployee object.
	 */
	private static BasePlusCommissionEmployee getRandomBasePlusCommissionEmployee(String firstName, String lastName,
			String socialSecurityNumber, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
		double grossSales = rnd.nextDouble() * 55000 + 5000; // 5000.0 to 60000.0
		double commissionRate = rnd.nextDouble() / 10; // 0.0 to 0.1
		double baseSalary = rnd.nextDouble() * 5000; // 0.0 to 5000.0
		return new BasePlusCommissionEmployee(firstName, lastName, socialSecurityNumber, grossSales, commissionRate,
				baseSalary, yearOfBirth, monthOfBirth, dayOfBirth);
	}

	/**
	 * Generates a random salaried employee.
	 *
	 * @param firstName            First name of the employee.
	 * @param lastName             Last name of the employee.
	 * @param socialSecurityNumber Social security number of the employee.
	 * @param yearOfBirth          Year of birth of the employee.
	 * @param monthOfBirth         Month of birth of the employee.
	 * @param dayOfBirth           Day of birth of the employee.
	 * @return Randomly generated SalariedEmployee object.
	 */
	private static SalariedEmployee getRandomSalariedEmployee(String firstName, String lastName,
			String socialSecurityNumber, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
		double weeklySalary = rnd.nextDouble() * 3000 + 300; // 300.0 to 3300.0
		return new SalariedEmployee(firstName, lastName, socialSecurityNumber, weeklySalary, yearOfBirth, monthOfBirth,
				dayOfBirth);
	}

	/**
	 * Generates a random exception piece worker employee.
	 *
	 * @param firstName            First name of the employee.
	 * @param lastName             Last name of the employee.
	 * @param socialSecurityNumber Social security number of the employee.
	 * @param yearOfBirth          Year of birth of the employee.
	 * @param monthOfBirth         Month of birth of the employee.
	 * @param dayOfBirth           Day of birth of the employee.
	 * @return Randomly generated PieceWorkerEmployee object.
	 */
	private static PieceWorker getExceptionPieceWorkerEmployee(String firstName, String lastName,
			String socialSecurityNumber, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
		try {
			int piecesSold = (int) EXCEPTION_VALUE; // Exception
			double salaryPerPiece = rnd.nextDouble() * 10; // 0 to 10.0 per piece
			return new PieceWorker(firstName, lastName, socialSecurityNumber, piecesSold, salaryPerPiece, yearOfBirth,
					monthOfBirth, dayOfBirth);
		} catch (IllegalArgumentException e) {
			System.out.println("Error creating PieceWorkerEmployee: " + e.getMessage());
			return null; // or handle the exception accordingly
		}
	}

	/**
	 * Generates a random exception hourly employee.
	 *
	 * @param firstName            First name of the employee.
	 * @param lastName             Last name of the employee.
	 * @param socialSecurityNumber Social security number of the employee.
	 * @param yearOfBirth          Year of birth of the employee.
	 * @param monthOfBirth         Month of birth of the employee.
	 * @param dayOfBirth           Day of birth of the employee.
	 * @return Randomly generated HourlyEmployee object.
	 */
	private static HourlyEmployee getExceptionHourlyEmployee(String firstName, String lastName,
			String socialSecurityNumber, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
		try {
			double wage = EXCEPTION_VALUE; // Exception
			double hours = rnd.nextDouble() * 168; // 0.0 to 168.0 hours
			return new HourlyEmployee(firstName, lastName, socialSecurityNumber, wage, hours, yearOfBirth, monthOfBirth,
					dayOfBirth);
		} catch (IllegalArgumentException e) {
			System.out.println("Error creating HourlyEmployee: " + e.getMessage());
			return null; // or handle the exception accordingly
		}
	}

	/**
	 * Generates a random exception base plus commission employee.
	 *
	 * @param firstName            First name of the employee.
	 * @param lastName             Last name of the employee.
	 * @param socialSecurityNumber Social security number of the employee.
	 * @param yearOfBirth          Year of birth of the employee.
	 * @param monthOfBirth         Month of birth of the employee.
	 * @param dayOfBirth           Day of birth of the employee.
	 * @return Randomly generated BasePlusCommissionEmployee object.
	 */
	private static BasePlusCommissionEmployee getExceptionBasePlusCommissionEmployee(String firstName, String lastName,
			String socialSecurityNumber, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
		try {
			double grossSales = rnd.nextDouble() * 55000 + 5000; // 5000.0 to 60000.0
			double commissionRate = rnd.nextDouble() / 10; // 0.0 to 0.1
			double baseSalary = EXCEPTION_VALUE; // Exception
			return new BasePlusCommissionEmployee(firstName, lastName, socialSecurityNumber, grossSales, commissionRate,
					baseSalary, yearOfBirth, monthOfBirth, dayOfBirth);
		} catch (IllegalArgumentException e) {
			System.out.println("Error creating BasePlusCommissionEmployee: " + e.getMessage());
			return null; // or handle the exception accordingly
		}
	}

	/**
	 * Generates a random exception salaried employee.
	 *
	 * @param firstName            First name of the employee.
	 * @param lastName             Last name of the employee.
	 * @param socialSecurityNumber Social security number of the employee.
	 * @param yearOfBirth          Year of birth of the employee.
	 * @param monthOfBirth         Month of birth of the employee.
	 * @param dayOfBirth           Day of birth of the employee.
	 * @return Randomly generated SalariedEmployee object.
	 */
	private static SalariedEmployee getExceptionSalariedEmployee(String firstName, String lastName,
			String socialSecurityNumber, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
		try {
			double weeklySalary = EXCEPTION_VALUE; // Exception
			return new SalariedEmployee(firstName, lastName, socialSecurityNumber, weeklySalary, yearOfBirth,
					monthOfBirth, dayOfBirth);
		} catch (IllegalArgumentException e) {
			System.out.println("Error creating SalariedEmployee: " + e.getMessage());
			return null; // or handle the exception accordingly
		}
	}

	/**
	 * Generates a random exception commission employee.
	 *
	 * @param firstName            First name of the employee.
	 * @param lastName             Last name of the employee.
	 * @param socialSecurityNumber Social security number of the employee.
	 * @param yearOfBirth          Year of birth of the employee.
	 * @param monthOfBirth         Month of birth of the employee.
	 * @param dayOfBirth           Day of birth of the employee.
	 * @return Randomly generated CommissionEmployee object.
	 */
	private static CommissionEmployee getExceptionCommissionEmployee(String firstName, String lastName,
			String socialSecurityNumber, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
		try {
			double grossSales = EXCEPTION_VALUE; // Exception
			double commissionRate = rnd.nextDouble() / 10 + 0.1; // 0.1 to 0.2
			return new CommissionEmployee(firstName, lastName, socialSecurityNumber, grossSales, commissionRate,
					yearOfBirth, monthOfBirth, dayOfBirth);
		} catch (IllegalArgumentException e) {
			System.out.println("Error creating CommissionEmployee: " + e.getMessage());
			return null; // or handle the exception accordingly
		}
	}
}