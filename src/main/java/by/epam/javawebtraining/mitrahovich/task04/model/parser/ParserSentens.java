package by.epam.javawebtraining.mitrahovich.task04.model.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ParserSentens extends Parser {

	public ParserSentens() {
		super(ParserType.SENTENS);
	}

	@Override
	public List<String> parse(String text) {
		if (text != null && text.length() > 1) {

			Pattern p = Pattern.compile("[ ]");
			String[] temp = p.split(text);

			ArrayList<String> tempList = new ArrayList<>();

			if (temp[0] != null && temp[0].length() > 0) {
				tempList.add(temp[0]);
			}
			for (int i = 1; i < temp.length; i++) {
				if (temp[i] != null && temp[i].length() > 0) {
					tempList.add(" ");
					tempList.add(temp[i]);

				}
			}

			return tempList;

		}
		return null;

	}
}
