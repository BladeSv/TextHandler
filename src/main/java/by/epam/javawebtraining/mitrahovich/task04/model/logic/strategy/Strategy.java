package by.epam.javawebtraining.mitrahovich.task04.model.logic.strategy;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.epam.javawebtraining.mitrahovich.task04.model.entity.Treatment;
import by.epam.javawebtraining.mitrahovich.task04.model.parser.Parser;

public class Strategy {

	private static Logger logger;

	static {
		logger = Logger.getRootLogger();
	}

	protected static List<Treatment> findTreatmentByParserType(Treatment treatment, Parser.ParserType parserType) {
		List<Treatment> findedTreatment = new ArrayList<>();
		if (treatment != null && parserType != null) {
			if (treatment.getParserType() != parserType) {
				if (treatment.getConteiner() != null) {
					for (Treatment tr : treatment.getConteiner()) {

						List<Treatment> temp = findTreatmentByParserType(tr, parserType);

						if (!temp.isEmpty()) {
							findedTreatment.addAll(temp);
						}

					}
				}
			} else {
				logger.trace("find Treatment-" + treatment.getConteiner().getClass().getSimpleName() + " with parser-"
						+ parserType.name());
				findedTreatment.add(treatment);
			}

		}

		return findedTreatment;

	}
}
