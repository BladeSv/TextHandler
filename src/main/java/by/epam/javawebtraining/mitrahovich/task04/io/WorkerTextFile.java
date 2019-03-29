package by.epam.javawebtraining.mitrahovich.task04.io;

import static by.epam.javawebtraining.mitrahovich.task04.util.PropertiesManager.getInputTextFileName;
import static by.epam.javawebtraining.mitrahovich.task04.util.PropertiesManager.getOutputTextFileName;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

public class WorkerTextFile {
	private static Logger logger = Logger.getRootLogger();
	private static String inputTexFileName = getInputTextFileName();
	private static String outputTexFileName = getOutputTextFileName();

	public WorkerTextFile() {

	}

	public static void write(String string, String fileName) {

		try (BufferedWriter os = new BufferedWriter(new FileWriter((outputTexFileName + fileName), false))) {
			os.write(string);

		} catch (FileNotFoundException e) {
			logger.warn("write text in file", e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.warn("write text in file", e);
			e.printStackTrace();
		}

	}

	public static String read(String fileName) {

		StringBuilder sb = null;
		try (BufferedReader is = new BufferedReader(new FileReader((inputTexFileName + fileName)))) {
			sb = new StringBuilder();
			while (is.ready()) {
				sb.append(is.readLine()).append("\n");
			}

		} catch (FileNotFoundException e) {
			logger.warn("read text from file", e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.warn("read text from file", e);
			e.printStackTrace();
		}

		return sb.toString();
	}
}
