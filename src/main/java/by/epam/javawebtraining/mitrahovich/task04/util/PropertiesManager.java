package by.epam.javawebtraining.mitrahovich.task04.util;

import java.util.ResourceBundle;

public class PropertiesManager {

	public static final ResourceBundle rb;

	static {
		rb = ResourceBundle.getBundle("config");
	}

	public static String getStatus() {

		return rb.getString("status");
	}

	public static String getInputTextFileName() {

		return rb.getString("input_text");
	}

	public static String getOutputTextFileName() {

		return rb.getString("output_text");
	}

}
