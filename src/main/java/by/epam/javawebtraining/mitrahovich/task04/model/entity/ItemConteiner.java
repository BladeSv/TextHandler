package by.epam.javawebtraining.mitrahovich.task04.model.entity;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import by.epam.javawebtraining.mitrahovich.task04.model.parser.Parser;
import by.epam.javawebtraining.mitrahovich.task04.model.parser.ParserType;

public class ItemConteiner extends Item {
	private static Logger logger = Logger.getRootLogger();
	private String content = "";
	private List<Treatment> conteiner;
	private Parser parser;

	public ItemConteiner() {

	}

	/**
	 * @param parser
	 * @param next
	 */
	public ItemConteiner(Parser parser, Item next) {
		super();
		this.parser = parser;

		conteiner = new LinkedList<Treatment>();
	}

	public ItemConteiner(Parser parser) {
		super();
		this.parser = parser;

		conteiner = new LinkedList<Treatment>();
	}

	public ItemConteiner(Item itemConteiner) {
		super();
		this.parser = itemConteiner.getParser();

		conteiner = new LinkedList<Treatment>();

	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Treatment> getConteiner() {
		return conteiner;
	}

	public void parsing(String text) {
		if (text != null && text != "") {
			logger.trace("parser=" + parser.getClass().getSimpleName() + ", text to parse=" + text);
			content = text;

			List<String> parsedText = parser.parse(text);

			if (parsedText != null) {
				logger.trace(parser.getClass().getSimpleName() + " array lengtht:" + parsedText.size());
				for (String str : parsedText) {
					if (str.length() > 1 && parser.getNext() != null) {
						Item temp = null;

						temp = new ItemConteiner(parser.getNext());
						if (parser.getParserType() == ParserType.TEXT) {

						}

						temp.parsing(str);
						conteiner.add(temp);

						logger.trace(parser.getClass().getSimpleName() + " parsed on paths:" + str);

					} else if (str.length() == 1 || parser.getNext() == null) {
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
