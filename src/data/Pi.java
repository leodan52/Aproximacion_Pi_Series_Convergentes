package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Pi {

	public static final File FILE = new File("resources/pi_10_millones.txt");

	public static String getPi(int count_decimals) {

		String fileContent = getFileContent();
		Pattern pattern = Pattern.compile("(?<=\\s)\\d{10}(?=\\s)");
		Matcher matcher = pattern.matcher(fileContent);
		String salida = "";

		while (matcher.find() & salida.length() < count_decimals) {
			salida += matcher.group();
		}

		return "3." + salida.substring(0, count_decimals); //.substring(0, count_decimals);
	}

	public static String getFileContent() {
		String salida = "";

		try (FileReader fr = new FileReader(FILE)) {

			BufferedReader br = new BufferedReader(fr);

			salida = br.lines().collect(Collectors.joining("; "));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return salida;

	}

}
