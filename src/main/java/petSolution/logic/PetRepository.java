package petSolution.logic;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import petSolution.entity.Pet;

/**
 * @author aldo.tordoya
 *
 */
public class PetRepository {
	private static String filepath;
	private static List<Pet> pets;

	/**
	 * @param path
	 * @throws Exception
	 */
	public static void setPath(String path) throws Exception {
		filepath = path;
	}

	/**
	 * @param petsCSV
	 */
	public static void setPets() throws Exception {
		Reader in = new FileReader(filepath);
		Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader("type", "name", "gender", "update").parse(in);
		List<Pet> petsCSV = new ArrayList<Pet>();
		for (CSVRecord record : records) {
			String type = record.get("type");
			String name = record.get("name");
			String gender = record.get("gender");
			String updateStr = record.get("update");
			DateFormat df = new SimpleDateFormat("yyyyMMdd-hhmmss");
			Date parsedDate = df.parse(updateStr);
			Timestamp update = new Timestamp(parsedDate.getTime());

			Pet pet = new Pet(type, name, gender, update);
			petsCSV.add(pet);
		}
		pets = petsCSV;
	}

	/**
	 * @param pet
	 * @throws Exception
	 */
	public static void createPetOnCSV(Pet pet) throws Exception {
		FileWriter fileWriter = null;
		CSVPrinter csvFilePrinter = null;
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator("\n");
		try {
			fileWriter = new FileWriter(filepath, true);
			csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);

			List<String> row = new ArrayList<String>();
			
			row.add(pet.getType());
			row.add(pet.getName());
			row.add(pet.getGender());

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-hhmmss");
			String updateString = sdf.format(pet.getUpdate());
			row.add(updateString);
			csvFilePrinter.printRecord(row);

			System.out.println(row);
		} finally {
			fileWriter.flush();
			fileWriter.close();
			csvFilePrinter.close();
		}
	}

	/**
	 * @return List Pets
	 */
	public static List<Pet> getPets() {
		return pets;
	}
}
