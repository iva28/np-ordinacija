package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Kuvar extends OpstaDomenskaKlasa{

	private Long kuvarId;
    private String ime;
    private String prezime;
    private String adresa;
    private String telefon;

    public Kuvar() {
    }

    public Kuvar(Long kuvarId, String ime, String prezime, String adresa, String telefon) {
        this.kuvarId = kuvarId;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.telefon = telefon;
    }

    public Kuvar(Long kuvarId, String ime, String prezime) {
        this.kuvarId = kuvarId;
        this.ime = ime;
        this.prezime = prezime;
    }
    
    

    public Long getKuvarId() {
        return kuvarId;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setKuvarId(Long kuvarId) {
        this.kuvarId = kuvarId;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.kuvarId);
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
        final Kuvar other = (Kuvar) obj;
        return Objects.equals(this.kuvarId, other.kuvarId);
    }

    @Override
    public String toString() {
        return   ime + " " + prezime;
    }
    

    @Override
    public String imeTabele() {
        return "kuvar";
    }

    @Override
    public String vratiParametre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiNaziveParametara() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiNazivPrimarnogKljuca() {
        return "kuvarId";
    }

    @Override
    public Long vratiPrimarniKljuc() {
        return kuvarId;
    }


    @Override
    public List<OpstaDomenskaKlasa> konvertujUListu(ResultSet rs) {
        List<OpstaDomenskaKlasa> kuvari = new ArrayList<>();
        try {
            while(rs.next()) {
                Long kuvarId = rs.getLong("kuvarId");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String adresa = rs.getString("adresa");
                String telefon = rs.getString("telefon");
                
                kuvari.add(new Kuvar(kuvarId, ime, prezime, adresa, telefon));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in converting list in Kuvari!\n");
        }
        return kuvari;
    }

    @Override
    public String uslovZaIzmenu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
