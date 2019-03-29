package by.epam.javawebtraining.mitrahovich.task04.model.entity;

import by.epam.javawebtraining.mitrahovich.task04.model.parser.Parser;

public class Item implements Treatment, Cloneable {
	private String content;

	private Parser parser;

	private Item next;

	public Item() {

	}

	public Item(Item item) {

	}

	public Parser getParser() {
		return parser;
	}

	public void setParser(Parser parser) {
		this.parser = parser;
	}

	public Item getNext() {
		return next;
	}

	public void setNext(Item next) {
		this.next = next;
	}

	public void parsing(String text) {
		content = text;
	}

	public String collect() {

		return content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		return true;
	}

	@Override
	public String toString() {
		// System.out.println("Item-" + content);
		return content;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {

		return super.clone();
	}

}
