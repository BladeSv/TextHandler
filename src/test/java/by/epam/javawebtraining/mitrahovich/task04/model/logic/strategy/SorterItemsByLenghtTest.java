package by.epam.javawebtraining.mitrahovich.task04.model.logic.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import by.epam.javawebtraining.mitrahovich.task04.model.entity.Item;
import by.epam.javawebtraining.mitrahovich.task04.model.entity.ItemConteiner;
import by.epam.javawebtraining.mitrahovich.task04.model.logic.comporator.IncreaseStringLenght;
import by.epam.javawebtraining.mitrahovich.task04.model.parser.Parser;
import by.epam.javawebtraining.mitrahovich.task04.model.parser.Parser.ParserType;
import by.epam.javawebtraining.mitrahovich.task04.model.parser.ParserParagraph;
import by.epam.javawebtraining.mitrahovich.task04.model.parser.ParserSentens;
import by.epam.javawebtraining.mitrahovich.task04.model.parser.ParserText;

public class SorterItemsByLenghtTest {
	private String elementary;
	private Item conteiner;
	private Comparator comp;
	private String expected;

	@BeforeEach
	void init() {
		elementary = "	Java provides the java.util.regex package for pattern matching with regular expressions. "
				+ "Java regular expressions are very similar to the Perl programming language and very easy to learn."
				+ "	A regular expression is a special sequence of characters that helps you match or find other strings or sets of strings, "
				+ "using a specialized syntax held in a pattern. They can be used to search, edit, or manipulate text and data."
				+ "	Capturing groups are a way to treat multiple characters as a single unit. They are created by placing the characters "
				+ "to be grouped inside a set of parentheses. For example, the regular expression (dog) creates a single group containing"
				+ "the letters \"d\", \"o\", and \"g\".";

		expected = " They can be used to search, edit, or manipulate text and data.\n"
				+ "Capturing groups are a way to treat multiple characters as a single unit\n"
				+ " They are created by placing the characters to be grouped inside a set of parentheses\n"
				+ "Java provides the java.util.regex package for pattern matching with regular expressions\n"
				+ " Java regular expressions are very similar to the Perl programming language and very easy to learn.\n"
				+ " For example, the regular expression (dog) creates a single group containingthe letters \"d\", \"o\", and \"g\".\n"
				+ "A regular expression is a special sequence of characters that helps you match or find other strings or sets of strings, using a specialized syntax held in a pattern";
		Parser parserText = new ParserText();
		Parser parserParagraph = new ParserParagraph();
		Parser parserSentens = new ParserSentens();

		parserText.setNext(parserParagraph);
		parserParagraph.setNext(parserSentens);
		conteiner = new ItemConteiner(parserText);
		comp = new IncreaseStringLenght();
	}

	@Test
	void testToString() {
		conteiner.parsing(elementary);

		assertEquals(expected, SorterItemsByLenght.process(conteiner, ParserType.SENTENS, comp));
	}
}
