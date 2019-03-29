package by.epam.javawebtraining.mitrahovich.task04.model.entity;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import by.epam.javawebtraining.mitrahovich.task04.model.parser.Parser;
import by.epam.javawebtraining.mitrahovich.task04.model.parser.Parser.ParserType;

public class ItemConteiner extends Item {
	private static Logger logger;

	private Parser parser;
	private List<Treatment> conteiner;

	static {
		logger = Logger.getRootLogger();
	}

	public ItemConteiner() {

	}

	/**
	 * @param parser
	 * @param next
	 */

	public ItemConteiner(Parser parser) {
		super();
		setParser(parser);

		conteiner = new LinkedList<Treatment>();
	}

	public Parser getParser() {
		return parser;
	}

	public boolean setParser(Parser parser) {
		if (parser != null) {
			this.parser = parser;
			return true;
		}

		return false;

	}

	public boolean setContent(String content) {
		if (content != null) {

			return true;
		}

		return false;

	}

	@Override
	public ParserType getParserType() {

		return getParser().getParserType();
	}

	@Override
	public List<Treatment> getConteiner() {

		return conteiner;
	}

	public void parsing(String text) {
		if (text != null && text != "") {
			logger.trace("parser=" + getParser().getClass().getSimpleName() + ", text to parse=" + text);

			List<String> parsedText = getParser().parse(text);

			if (parsedText != null) {
				logger.trace(getParser().getClass().getSimpleName() + " array lengtht:" + parsedText.size());
				for (String str : parsedText) {
					if (str.trim().length() > 1 && getParser().getNext() != null) {
						Item temp = new ItemConteiner(getParser().getNext());

						temp.parsing(str);
						conteiner.add(temp);

						logger.trace(getParser().getClass().getSimpleName() + " parsed on paths:" + str);

					} else if (str.trim().length() <= 1 || getParser().getNext() == null) {
						Item item = new Item();
						item.parsing(str);

						conteiner.add(item);

					}

				}
			}

		}

	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		for (Treatment t : conteiner) {

			sb.append(t.toString());

		}

		return sb.toString();
	}

}
