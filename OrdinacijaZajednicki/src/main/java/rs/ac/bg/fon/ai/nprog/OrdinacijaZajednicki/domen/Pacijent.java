package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pacijent extends OpstaDomenskaKlasa{

	private Long pacijentId;
    private String ime;
    private String prezime;
    private String email;
    private String telefon;
    private Pol pol;

    public Pacijent() {
    }

    public Pacijent(String ime, String prezime, String email, String telefon, Pol pol) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.telefon = telefon;
        this.pol = pol;
    }

    public Pacijent(Long pacijentId, String ime, String prezime, String email, String telefon, Pol pol) {
        this.pacijentId = pacijentId;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.telefon = telefon;
        this.pol = pol;
    }

    public Pacijent(Long pacijentId) {
        this.pacijentId = pacijentId;
    }


    public Long getPacijentId() {
        return pacijentId;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefon() {
        return telefon;
    }

    public Pol getPol() {
        return pol;
    }

    public void setPacijentId(Long pacijentId) {
        this.pacijentId = pacijentId;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.pacijentId);
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
        final Pacijent other = (Pacijent) obj;
        return Objects.equals(this.email, other.email);
    }
    
    

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String imeTabele() {
        return "pacijent";
    }

    @Override
    public String vratiParametre() {
        return String.format(" '%s', '%s', '%s', '%s', '%s'", ime, prezime, email, telefon, pol.toString());
    }

    @Override
    public String vratiNaziveParametara() {
        return "(ime, prezime, email, telefon, pol) ";
    }

    @Override
    public String vratiNazivPrimarnogKljuca() {
        return "id";
    }

    @Override
    public Long vratiPrimarniKljuc() {
        return pacijentId;
    }

    @Override
    public List<OpstaDomenskaKlasa> konvertujUListu(ResultSet rs) {
        List<OpstaDomenskaKlasa> pacijenti = new ArrayList<>();
        try {
            while (rs.next()) {
                Long pacijentiIdBaza = rs.getLong("id");
                String imeBaza = rs.getString("ime");
                String prezimeBaza = rs.getString("prezime");
                String emailBaza = rs.getString("email");
                String telefonBaza = rs.getString("telefon");
                Pol polBaza = Pol.valueOf(rs.getString("pol"));

                Pacijent novi = new Pacijent();
                novi.setPacijentId(pacijentiIdBaza);
                novi.setIme(imeBaza);
                novi.setPrezime(prezimeBaza);
                novi.setEmail(emailBaza);
                novi.setTelefon(telefonBaza);
                novi.setPol(polBaza);
                pacijenti.add(novi);
            }
        } catch (Exception ex) {
            System.err.println("Greška u ResultSet-u u Pacijent klasi! "+ex.getMessage());
        }
        return pacijenti;
    }

    @Override
    public String uslovZaIzmenu() {
        return "ime = '" + ime + "' ,prezime = '" + prezime + "' , email = '"
                + email + "', telefon = '" + telefon + "' ,pol = '" + pol + "'";
    }

    @Override
    public String uslovZaJednog() {
        return  " email ='"+email+"'" ;
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
        return " ime= '" + ime + "'";
    }

    @Override
    public String uslovZaBrisanjeVise() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
