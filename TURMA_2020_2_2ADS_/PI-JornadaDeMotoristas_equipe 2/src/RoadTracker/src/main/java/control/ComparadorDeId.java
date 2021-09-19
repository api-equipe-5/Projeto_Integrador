package control;

import java.util.Comparator;

import model.Logs;

public class ComparadorDeId implements Comparator<Logs>{

	@Override
	public int compare(Logs log1, Logs log2) {

		return log1.getId() - log2.getId();
	}

}
