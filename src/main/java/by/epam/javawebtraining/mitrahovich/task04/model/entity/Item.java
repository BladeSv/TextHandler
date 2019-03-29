package by.epam.javawebtraining.mitrahovich.task04.model.entity;

import java.util.List;

import by.epam.javawebtraining.mitrahovich.task04.model.parser.Parser.ParserType;

public class Item implements Treatment {
	private String content;

	public Item() {
		content = "";
	}

	public void parsing(String text) {
		content = text;
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

		return content;
	}

	@Override
	public ParserType getParserType() {

		return null;
	}

	@Override
	public List<Treatment> getConteiner() {

		return null;
	}

}
