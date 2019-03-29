package by.epam.javawebtraining.mitrahovich.task04.model.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ParserText extends Parser {

	/**
	 * @param parserType
	 */
	public ParserText() {
		super(ParserType.TEXT);
	}

	@Override
	public List<String> parse(String text) {
		if (text != null && text.length() > 1) {

			Pattern p = Pattern.compile("\t");

			String[] temp = p.split(text);

			ArrayList<String> tempList = new ArrayList<>();

			System.out.println("split text");
			for (String str : temp) {
				if (str.length() > 0 && str != null && str != "") {

					tempList.add("\t");
					tempList.add(str);
				}
			}

			return tempList;
		}

		return null;

	}

}
