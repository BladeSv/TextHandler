package by.epam.javawebtraining.mitrahovich.task04.model.entity;

import java.util.List;

import by.epam.javawebtraining.mitrahovich.task04.model.parser.Parser;

public interface Treatment extends Cloneable {
	void parsing(String text);

	Parser.ParserType getParserType();

	List<Treatment> getConteiner();
}
