package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ordinacija extends OpstaDomenskaKlasa{

	private Long ordinacijaId;
    private String naziv;
    private String adresa;

    public Ordinacija() {
    }

    public Ordinacija(Long ordinacijaId, String naziv, String adresa) {
        this.ordinacijaId = ordinacijaId;
        this.naziv = naziv;
        this.adresa = adresa;
    }

    public Ordinacija(Long ordinacijaId) {
        this.ordinacijaId = ordinacijaId;
    }

    public Ordinacija(Long ordinacijaId, String naziv) {
        this.ordinacijaId = ordinacijaId;
        this.naziv = naziv;
    }

    
    public Long getOrdinacijaId() {
        return ordinacijaId;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setOrdinacijaId(Long ordinacijaId) {
        this.ordinacijaId = ordinacijaId;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.ordinacijaId);
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
        final Ordinacija other = (Ordinacija) obj;
        return Objects.equals(this.ordinacijaId, other.ordinacijaId);
    }

    @Override
    public String toString() {
        return "Ordinacija{" + "ordinacijaId=" + ordinacijaId + ", naziv=" + naziv + ", adresa=" + adresa + '}';
    }

    @Override
    public String imeTabele() {
        return "ordinacija";
    }

    @Override
    public String vratiParametre() {
        return String.format("%s, '%s', '%s'", ordinacijaId, naziv, adresa);
    }

    @Override
    public String vratiNaziveParametara() {
        return "ordinacijaId,naziv,adresa";
    }

    @Override
    public String vratiNazivPrimarnogKljuca() {
        return "ordinacijaId";
    }

    @Override
    public Long vratiPrimarniKljuc() {
        return ordinacijaId;
    }


    @Override
    public List<OpstaDomenskaKlasa> konvertujUListu(ResultSet rs) {
        List<OpstaDomenskaKlasa> ordinacije = new ArrayList<>();
        try {
            while (rs.next()) {
                Long ordinacijaIdBaza = rs.getLong("ordinacijaId");
                String nazivBaza = rs.getString("naziv");
                String adresaBaza = rs.getString("adresa");
                ordinacije.add(new Ordinacija(ordinacijaIdBaza, nazivBaza, adresaBaza));
            }
        } catch (Exception ex) {
            System.err.println("Greška u konvertovanju ResultSet-a u Ordinacija klasi! "+ex.getMessage());
        }
        return ordinacije;
    }

    @Override
    public String uslovZaIzmenu() {
        return "ordinacijaId="+ordinacijaId+", naziv="+naziv+", adresa="+adresa;
    }

    @Override
    public String uslovZaJednog() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String spajanje() {
        return "";
    }

    @Override
    public String vratiSlozenPrimarniKljuc() {
        return null;
    }

    @Override
    public String uslovZaVise() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String uslovZaBrisanjeVise() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
