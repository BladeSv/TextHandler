package by.epam.javawebtraining.mitrahovich.task04.model.logic.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;

import by.epam.javawebtraining.mitrahovich.task04.model.entity.Treatment;
import by.epam.javawebtraining.mitrahovich.task04.model.parser.Parser;

public class SorterItemsByLenght extends Strategy {

	private static Logger logger;

	static {
		logger = Logger.getRootLogger();
	}

	public SorterItemsByLenght() {

	}

	public static String process(Treatment treatment, Parser.ParserType parserType, Comparator<String> comp) {
		String result = "";
		if (treatment != null && parserType != null) {
			List<Treatment> workConteiner = findTreatmentByParserType(treatment, parserType);
			if (!workConteiner.isEmpty()) {
				List<String> tempBase = new ArrayList<>();
				logger.trace("Count finded items-" + workConteiner.size());

				for (Treatment tr : workConteiner) {
					String temp = tr.toString();
					tempBase.add(temp);
					logger.trace("Treatment-" + tr.getConteiner().getClass().getSimpleName() + " with parser-"
							+ parserType.name() + " Leght- " + temp.length() + " toString: " + temp);

				}
				Collections.sort(tempBase, comp);
				StringBuilder sb = new StringBuilder();
				for (String str : tempBase) {
					sb.append(str).append("\n");

				}
				result = sb.toString();

			}

		}

		return result;
	}

}
