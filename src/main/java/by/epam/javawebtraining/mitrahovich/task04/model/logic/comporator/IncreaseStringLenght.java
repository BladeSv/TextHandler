package by.epam.javawebtraining.mitrahovich.task04.model.logic.comporator;

import java.util.Comparator;

public class IncreaseStringLenght implements Comparator<String> {

	public IncreaseStringLenght() {

	}

	@Override
	public int compare(String o1, String o2) {

		return o1.length() - o2.length();
	}

}
