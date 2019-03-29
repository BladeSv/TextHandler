package by.epam.javawebtraining.mitrahovich.task04.model.logic.comporator;

import java.util.Comparator;

public class DecreaseStringLenght implements Comparator<String> {

	public DecreaseStringLenght() {

	}

	@Override
	public int compare(String o1, String o2) {

		return o2.length() - o1.length();
	}
}
