package inclasse.struttureDati.polinomi;

import java.util.LinkedList;
import java.util.ListIterator;

public class Polynomial {
	private LinkedList<Term> termini;

	public Polynomial(Term t) {
		this();
		termini.add(t);
	}

	public Polynomial() {
		termini = new LinkedList<>();
	}
	
	public void add(Polynomial p) {
		ListIterator<Term> it;
		for (Term term : p.termini) {
			it = termini.listIterator();
			boolean ins = false;
			while(it.hasNext() && !ins) {
				Term o = it.next();
				if(term.getExp() == o.getExp()) {
					o.setCoef(o.getCoef() + term.getCoef());
					ins = true;
				} else if(term.getExp() > o.getExp()) {
					it.previous();
					it.add(term);
					ins = true;
				}
			}
			if(!ins) termini.addLast(term);
		}
	}


	public void multiply(Polynomial p) {
		Polynomial tmp = new Polynomial();

		boolean firstTime = true;

		for (Term t1 : termini) {
			for (Term t2 : p.termini) {
				ListIterator<Term> it = tmp.termini.listIterator();
				Term ris = new Term(t1.getCoef() * t2.getCoef(), t1.getExp() + t2.getExp());
				if(!firstTime) {
					boolean ins = false;
					while(it.hasNext() && !ins) {
						Term o = it.next();
						if(ris.getExp() == o.getExp()) {
							o.setCoef(o.getCoef() + ris.getCoef());
							ins = true;
						} else if(ris.getExp() > o.getExp()) {
							it.previous();
							it.add(ris);
							ins = true;
						}
					}

					if (!ins) {
						tmp.termini.add(ris);
					}
				} else {
					tmp.termini.add(ris);
					firstTime = false;
				}
			}
		}
		this.termini = tmp.termini;
		// (A+B) * (C+D) = AC + AD + BC + BD
	}

	



	@Override
	public String toString() {
		String s = "";

		for (Term term : termini) {
			s += "(" + ((term.getCoef() >= 0) ? "+" : "") + term + ")";
		}

		return s;
	}
}
