package by.epam.javawebtraining.mitrahovich.task04.controller;

import by.epam.javawebtraining.mitrahovich.task04.io.WorkerTextFile;
import by.epam.javawebtraining.mitrahovich.task04.model.entity.Item;
import by.epam.javawebtraining.mitrahovich.task04.model.entity.ItemConteiner;
import by.epam.javawebtraining.mitrahovich.task04.model.logic.comporator.DecreaseStringLenght;
import by.epam.javawebtraining.mitrahovich.task04.model.logic.comporator.IncreaseStringLenght;
import by.epam.javawebtraining.mitrahovich.task04.model.logic.strategy.SorterItemsByLenght;
import by.epam.javawebtraining.mitrahovich.task04.model.parser.Parser;
import by.epam.javawebtraining.mitrahovich.task04.model.parser.Parser.ParserType;
import by.epam.javawebtraining.mitrahovich.task04.model.parser.ParserParagraph;
import by.epam.javawebtraining.mitrahovich.task04.model.parser.ParserSentens;
import by.epam.javawebtraining.mitrahovich.task04.model.parser.ParserText;
import by.epam.javawebtraining.mitrahovich.task04.view.ConsolePrinter;
import by.epam.javawebtraining.mitrahovich.task04.view.Printer;

public class Controller {

	public Controller() {

	}

	public void run() {
		Printer printer = new ConsolePrinter();

		String text = WorkerTextFile.read("InputText.txt");
		printer.print(text);
		Parser parserText = new ParserText();
		Parser parserParagraph = new ParserParagraph();
		Parser parserSentens = new ParserSentens();

		parserText.setNext(parserParagraph);
		parserParagraph.setNext(parserSentens);
		Item conteiner = new ItemConteiner(parserText);

		IncreaseStringLenght stringLenght = new IncreaseStringLenght();
		DecreaseStringLenght decreaseStringLenght = new DecreaseStringLenght();

		System.out.println();
		conteiner.parsing(text);
		System.out.println();
		System.out.println();
		System.out.println(text);
		System.out.println();
		System.out.println("TO STRING");
		printer.print(conteiner);
		String outputText = conteiner.toString();
		WorkerTextFile.write(outputText, "OutputText.txt");

		System.out.println(outputText.equals(WorkerTextFile.read("InputText.txt")));
		System.out.println(SorterItemsByLenght.process(conteiner, ParserType.PARAGRAPH, stringLenght));
		System.out.println(SorterItemsByLenght.process(conteiner, ParserType.SENTENS, decreaseStringLenght));

	}

}
