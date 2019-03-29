package by.epam.javawebtraining.mitrahovich.task04.model.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import by.epam.javawebtraining.mitrahovich.task04.model.parser.Parser;
import by.epam.javawebtraining.mitrahovich.task04.model.parser.ParserParagraph;
import by.epam.javawebtraining.mitrahovich.task04.model.parser.ParserSentens;
import by.epam.javawebtraining.mitrahovich.task04.model.parser.ParserText;

public class ItemConteinerTest {
	private String expected;
	private Item conteiner;

	@BeforeEach
	void init() {
		expected = "	Java provides the java.util.regex package for pattern matching with regular expressions. \r\n"
				+ "Java regular expressions are very similar to the Perl programming language and very easy to learn.\r\n"
				+ "	A regular expression is a special sequence of characters that helps you match or find other strings or sets of strings,\r\n"
				+ "using a specialized syntax held in a pattern. They can be used to search, edit, or manipulate text and data.\r\n"
				+ "	Capturing groups are a way to treat multiple characters as a single unit. They are created by placing the characters\r\n"
				+ "to be grouped inside a set of parentheses. For example, the regular expression (dog) creates a single group containing\r\n"
				+ "the letters \"d\", \"o\", and \"g\".";
		Parser parserText = new ParserText();
		Parser parserParagraph = new ParserParagraph();
		Parser parserSentens = new ParserSentens();

		parserText.setNext(parserParagraph);
		parserParagraph.setNext(parserSentens);
		conteiner = new ItemConteiner(parserText);
	}

	@Test
	void testToString() {
		conteiner.parsing(expected);
		assertEquals(expected, conteiner.toString());
	}

}
