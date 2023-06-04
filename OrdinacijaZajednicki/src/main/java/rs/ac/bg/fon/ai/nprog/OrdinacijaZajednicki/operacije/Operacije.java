package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.operacije;

/**
 * Enum Operacije predstavlja moguce operacije aplikacije
 * 
 * @author Iva Stanisic
 *
 */
public enum Operacije {
	 /**
     * Operacija: PRIJAVI_SE
     * Opis: Predstavlja operaciju za prijavu korisnika.
     */
    PRIJAVI_SE,

    /**
     * Operacija: VRATI_NUTRICIONISTE
     * Opis: Predstavlja operaciju za dobavljanje nutricionista.
     */
    VRATI_NUTRICIONISTE,

    /**
     * Operacija: ODJAVI_SE
     * Opis: Predstavlja operaciju za odjavu korisnika.
     */
    ODJAVI_SE,

    /**
     * Operacija: SVI_PACIJENTI
     * Opis: Predstavlja operaciju za dobavljanje svih pacijenata.
     */
    SVI_PACIJENTI,

    /**
     * Operacija: KREIRAJ_PACIJENTA
     * Opis: Predstavlja operaciju za kreiranje novog pacijenta.
     */
    KREIRAJ_PACIJENTA,

    /**
     * Operacija: OBRISI_PACIJENTA
     * Opis: Predstavlja operaciju za brisanje pacijenta.
     */
    OBRISI_PACIJENTA,

    /**
     * Operacija: IZMENI_PACIJENTA
     * Opis: Predstavlja operaciju za izmenu pacijenta.
     */
    IZMENI_PACIJENTA,

    /**
     * Operacija: NADJI_PACIJENTE
     * Opis: Predstavlja operaciju za pretragu pacijenata.
     */
    NADJI_PACIJENTE,

    /**
     * Operacija: UCITAJ_PACIJENTA
     * Opis: Predstavlja operaciju za učitavanje određenog pacijenta.
     */
    UCITAJ_PACIJENTA,

    /**
     * Operacija: VRATI_TIP_JELA
     * Opis: Predstavlja operaciju za dobavljanje vrsta jela.
     */
    VRATI_TIP_JELA,

    /**
     * Operacija: VRATI_KUVARE
     * Opis: Predstavlja operaciju za dobavljanje kuvara.
     */
    VRATI_KUVARE,

    /**
     * Operacija: KREIRAJ_JELO
     * Opis: Predstavlja operaciju za kreiranje novog jela.
     */
    KREIRAJ_JELO,

    /**
     * Operacija: VRATI_JELA
     * Opis: Predstavlja operaciju za dobavljanje jela.
     */
    VRATI_JELA,

    /**
     * Operacija: NADJI_JELA
     * Opis: Predstavlja operaciju za pretragu jela.
     */
    NADJI_JELA,
    /**
     * Operacija: KREIRAJ_PLAN_ISHRANE
     * Opis: Predstavlja operaciju za kreiranje novog plana ishrane.
     */
    KREIRAJ_PLAN_ISHRANE,

    /**
     * Operacija: VRATI_PLANOVE
     * Opis: Predstavlja operaciju za dobavljanje svih planova ishrane.
     */
    VRATI_PLANOVE,

    /**
     * Operacija: NADJI_PLAN_ISHRANE
     * Opis: Predstavlja operaciju za pretragu planova ishrane.
     */
    NADJI_PLAN_ISHRANE,

    /**
     * Operacija: UCITAJ_PLAN_ISHRANE
     * Opis: Predstavlja operaciju za učitavanje određenog plana ishrane.
     */
    UCITAJ_PLAN_ISHRANE,

    /**
     * Operacija: OBRISI_PLAN_ISHRANE
     * Opis: Predstavlja operaciju za brisanje plana ishrane.
     */
    OBRISI_PLAN_ISHRANE,

    /**
     * Operacija: IZMENI_PLAN_ISHRANE
     * Opis: Predstavlja operaciju za izmenu plana ishrane.
     */
    IZMENI_PLAN_ISHRANE
}
