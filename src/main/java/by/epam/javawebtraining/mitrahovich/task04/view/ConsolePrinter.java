package by.epam.javawebtraining.mitrahovich.task04.view;

public class ConsolePrinter implements Printer {

	public ConsolePrinter() {

	}

	@Override
	public void print(Object obj) {
		System.out.println(obj);

	}

}
