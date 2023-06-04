package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 * Apstraktna klasa koja predstavlja opstu domensku klasu. 
 * 
 * Klasa pruza osnovne funkcionalnosti koje se koriste za rad sa domeskim klasama.
 * 
 * @author Iva Stanisic
 *
 */
public abstract class OpstaDomenskaKlasa {
	/**
	 * Podrazumevani konstruktor
	 */
	public OpstaDomenskaKlasa() {
		
	}

	/**
	 * Vraca ime tabele u bazi podataka, koje odgovara domeskom objektu
	 * 
	 * @return ime tabele kao String
	 */
	public abstract String imeTabele();
	/**
	 *  Vraca atribute domenskog objekta koji se koriste prilikom upisa u bazu podataka
	 *  
	 * @return parametri objekta kao String
	 */
    public abstract String vratiParametre();
    /**
     * Vraca nazive atributa domenskog objekta koji se koriste prilikom upisa u bazu podataka
     * 
     * @return nazivi parametara kao String
     */
    public abstract String vratiNaziveParametara();
    /**
     * Vraca naziv primarnog kljuca domenskog objekta
     * 
     * @return naziv primarnog kljuca kao String
     */
    public abstract String vratiNazivPrimarnogKljuca();
    /**
     * Vraca vrednost primarnog kljuca domenskog objekta
     * 
     * @return primarni kljuc kao Long
     */
    public abstract Long vratiPrimarniKljuc();
    /**
     * Konvertuje rezultat iz baze podataka u listu domenskih objekata
     * 
     * @param rs rezultat iz baze podataka
     * @return lista domenskih objekata
     */
    public abstract List<OpstaDomenskaKlasa> konvertujUListu(ResultSet rs);
    /**
     * Vraca uslov za izmenu podataka u bazi podataka za odredjeni domenski objekat
     * 
     * @return uslov za izmenu domenskog objekta
     */
    public abstract String uslovZaIzmenu();
    /**
     * Vraca uslov za dobijanje jednog domenskog objekta iz baze podataka
     * 
     * @return uslov za jedan domenski objekat
     */
    public abstract String uslovZaJednog();
    /**
     * Vraca uslov za dobijanje vise domenskih objekata iz baze podataka
     * 
     * @return uslov za vise domenskih objekata
     */
    public abstract String uslovZaVise();
    /**
     * Vraca deo sql upita koji se koristi za spajanje tabela u bazi podataka
     * 
     * @return deo sql upita za spajanje tabela
     */
    public abstract  String spajanje();
    /**
     * Vraca slozen primarni kljuc ukoliko postoji, ako ne postoji vraca null
     * 
     * @return slozen primarni kljuc kao String
     */
    public abstract  String vratiSlozenPrimarniKljuc();
    /**
     * Vraca uslov za brisanje vise domenskih objekata iz tabele baze podataka
     * 
     * @return uslov za brisanje kao String
     */
    public abstract String uslovZaBrisanjeVise(); 
}
