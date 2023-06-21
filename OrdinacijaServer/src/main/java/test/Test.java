package test;

import java.util.List;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.repozitorijum.db.impl.DBBroker;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.planIshrane.SOUcitajListuPlanova;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.PlanIshrane;

public class Test {

	public static void main(String[] args) throws Exception {
	DBBroker broker = new DBBroker();
	List<OpstaDomenskaKlasa> lista = broker.svi(new PlanIshrane());
	System.out.println(lista == null);
	System.out.println(lista);

	}

}
