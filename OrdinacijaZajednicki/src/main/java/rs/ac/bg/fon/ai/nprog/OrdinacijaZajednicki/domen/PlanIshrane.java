package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class PlanIshrane extends OpstaDomenskaKlasa{
	
	 private Long planIshraneId;
	    private Date datum;
	    private BigDecimal cena;
	    private int brojDana;
	    private Pacijent pacijent;
	    private Nutricionista nutricionista;
	    private List<StavkaPlanaIshrane> stavke;

	    public List<StavkaPlanaIshrane> getStavke() {
	        return stavke;
	    }

	    public void setStavke(List<StavkaPlanaIshrane> stavke) {
	        this.stavke = stavke;
	    }

	    public PlanIshrane() {
	        stavke = new ArrayList<>();
	    }

	    public PlanIshrane(Long planIshraneId, Date datum, BigDecimal cena, int brojDana, Pacijent pacijent, Nutricionista nutricionista, List<StavkaPlanaIshrane> stavke) {
	        this.planIshraneId = planIshraneId;
	        this.datum = datum;
	        this.cena = cena;
	        this.brojDana = brojDana;
	        this.pacijent = pacijent;
	        this.nutricionista = nutricionista;
	        this.stavke = stavke;
	    }

	    public PlanIshrane(Long planIshraneId, Date datum, BigDecimal cena, int brojDana, Pacijent pacijent, Nutricionista nutricionista) {
	        this.planIshraneId = planIshraneId;
	        this.datum = datum;
	        this.cena = cena;
	        this.brojDana = brojDana;
	        this.pacijent = pacijent;
	        this.nutricionista = nutricionista;
	    }

	    public PlanIshrane(Long planIshraneId) {
	        this.planIshraneId = planIshraneId;
	    }

	    public Long getPlanIshraneId() {
	        return planIshraneId;
	    }

	    public Date getDatum() {
	        return datum;
	    }

	    public BigDecimal getCena() {
	        return cena;
	    }

	    public int getBrojDana() {
	        return brojDana;
	    }

	    public Pacijent getPacijent() {
	        return pacijent;
	    }

	    public Nutricionista getNutricionista() {
	        return nutricionista;
	    }

	    public void setPlanIshraneId(Long planIshraneId) {
	        this.planIshraneId = planIshraneId;
	    }

	    public void setDatum(Date datum) {
	        this.datum = datum;
	    }

	    public void setCena(BigDecimal cena) {
	        this.cena = cena;
	    }

	    public void setBrojDana(int brojDana) {
	        this.brojDana = brojDana;
	    }

	    public void setPacijent(Pacijent pacijent) {
	        this.pacijent = pacijent;
	    }

	    public void setNutricionista(Nutricionista nutricionista) {
	        this.nutricionista = nutricionista;
	    }

	    public void dodajStavku(StavkaPlanaIshrane stavka) {
	        stavke.add(stavka);
	    }

	    @Override
	    public String toString() {
	        return "PlanIshrane{" + "planIshraneId=" + planIshraneId + ", datum=" + datum + ", cena=" + cena + ", pacijent=" + pacijent + ", nutricionista=" + nutricionista + '}';
	    }

	    @Override
	    public int hashCode() {
	        int hash = 3;
	        hash = 97 * hash + Objects.hashCode(this.planIshraneId);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        final PlanIshrane other = (PlanIshrane) obj;
	        if (this.brojDana != other.brojDana) {
	            return false;
	        }
	        if (!Objects.equals(this.datum, other.datum)) {
	            return false;
	        }
	        if (!Objects.equals(this.pacijent, other.pacijent)) {
	            return false;
	        }
	        return Objects.equals(this.nutricionista, other.nutricionista);
	    }

	    

	    @Override
	    public String imeTabele() {
	        return "planishrane";
	    }

	    @Override
	    public String vratiParametre() {
	        return String.format("'%s', %s, %s, %s, %s", new java.sql.Date(datum.getTime()),
	                cena, pacijent.vratiPrimarniKljuc(), nutricionista.vratiPrimarniKljuc(), brojDana);
	    }

	    @Override
	    public String vratiNaziveParametara() {
	        return " (datum,cena,pacijentId,nutricionistaId,brojDana)";
	    }

	    @Override
	    public String vratiNazivPrimarnogKljuca() {
	        return "planishraneId";
	    }

	    @Override
	    public Long vratiPrimarniKljuc() {
	        return planIshraneId;
	    }

	    @Override
	    public List<OpstaDomenskaKlasa> konvertujUListu(ResultSet rs) {
	        List<OpstaDomenskaKlasa> planovi = new ArrayList<>();
	        try {
	            while (rs.next()) {
	                Long planIshraneIdBaza = rs.getLong("pi.planishraneId");
	                Date datumBaza = rs.getDate("pi.datum");
	                BigDecimal cenaBaza = rs.getBigDecimal("pi.cena");
	                Long pacijentId = rs.getLong("pi.pacijentId");
	                Long nutricionistaId = rs.getLong("pi.nutricionistaId");
	                int brojDanaBaza = rs.getInt("pi.brojDana");
	                String imeP = rs.getString("p.ime");
	                String prezimeP = rs.getString("p.prezime");
	                String emailP = rs.getString("p.email");
	                
	                String imeN = rs.getString("n.ime");
	                String prezimeN = rs.getString("n.prezime");

	                PlanIshrane pi = new PlanIshrane(planIshraneIdBaza, datumBaza, cenaBaza, brojDanaBaza,
	                        new Pacijent(pacijentId, imeP, prezimeP, emailP, "", null),
	                        new Nutricionista(nutricionistaId, imeN, prezimeN, "", "", null));
	                planovi.add(pi);
	            }
	        } catch (Exception ex) {
	            System.err.println("Greška u konvertovanju ResultSet-a u Plan Ishrane klasi! "+ex.getMessage());
	        }
	        return planovi;
	    }

	    @Override
	    public String uslovZaIzmenu() {
	        return " datum = '" + new java.sql.Date(datum.getTime()) + "', cena = " + cena + " ,pacijentId = "
	                + pacijent.vratiPrimarniKljuc() + " ,nutricionistaId = " + nutricionista.vratiPrimarniKljuc()
	                + " ,brojDana = " + brojDana;
	    }

	    @Override
	    public String uslovZaJednog() {
	        return " pi.planishraneId =" + planIshraneId;
	    }

	    @Override
	    public String spajanje() {
	        return " pi join pacijent p on (pi.pacijentId = p.id) "
	                + "join nutricionista n on (pi.nutricionistaId = n.nutricionistaId)";
	    }

	    @Override
	    public String vratiSlozenPrimarniKljuc() {
	        return null;
	    }

	    @Override
	    public String uslovZaVise() {
	        if (pacijent == null && nutricionista != null) {
	            return " n.ime = '" + nutricionista.getIme() + "' AND n.prezime = '" + nutricionista.getPrezime() + "'";
	        } else if (pacijent != null && nutricionista == null) {
	            return " p.ime ='" + pacijent.getIme() + "' AND p.prezime ='" + pacijent.getPrezime() + "'";
	        } else {
	            return "p.ime ='" + pacijent.getIme() + "' AND p.prezime ='" + pacijent.getPrezime() + "' AND n.ime = '"
	                    + nutricionista.getIme() + "' AND n.prezime ='" + nutricionista.getPrezime() + "'";
	        }
	    }

	    @Override
	    public String uslovZaBrisanjeVise() {
	        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	    }


}
