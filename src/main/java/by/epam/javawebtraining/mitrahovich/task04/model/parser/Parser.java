package by.epam.javawebtraining.mitrahovich.task04.model.parser;

import java.util.List;

public abstract class Parser {
	private ParserType parserType;
	private Parser next;

	public abstract List<String> parse(String text);

	public Parser getNext() {
		return next;
	}

	public void setNext(Parser next) {
		this.next = next;
	}

	public ParserType getParserType() {
		return parserType;
	}

	public Parser(ParserType parserType) {
		super();
		this.parserType = parserType;
	}

	public enum ParserType {
		TEXT, PARAGRAPH, SENTENS, WORD, SIMVOL;

	}
}
