package iterator;

import java.util.ArrayList;

public class ConcretIterator<G> implements Iterator<G>{

	private ArrayList<G> array;
	private int posicao = 0;
	
	public ConcretIterator(ArrayList<G> array) {
		this.array = array;
	}
	
	@Override
	public boolean hasNext() {
		if(posicao >= array.size() || array.get(posicao) == null) {
			return false;
		}
		return true;
	}

	@Override
	public G next() {
		G iten = this.array.get(posicao);
		posicao ++;
		return iten;
	}

}
