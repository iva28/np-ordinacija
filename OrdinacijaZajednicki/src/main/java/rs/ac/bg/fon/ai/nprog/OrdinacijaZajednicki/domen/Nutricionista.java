package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Nutricionista extends OpstaDomenskaKlasa{

	  private Long nutricionistaId;
	    private String ime;
	    private String prezime;
	    private String username ;
	    private String password;
	    private Ordinacija ordinacija;

	    public Nutricionista() {
	    }

	    public Nutricionista(Long nutricionistaId, String ime, String prezime, String username, String password, Ordinacija ordinacija) {
	        this.nutricionistaId = nutricionistaId;
	        this.ime = ime;
	        this.prezime = prezime;
	        this.username = username;
	        this.password = password;
	        this.ordinacija = ordinacija;
	    }

	    public Nutricionista(Long nutricionistaId) {
	        this.nutricionistaId = nutricionistaId;
	    }

	    public void setOrdinacija(Ordinacija ordinacija) {
	        this.ordinacija = ordinacija;
	    }

	    public void setNutricionistaId(Long nutricionistaId) {
	        this.nutricionistaId = nutricionistaId;
	    }

	    public void setIme(String ime) {
	        this.ime = ime;
	    }

	    public void setPrezime(String prezime) {
	        this.prezime = prezime;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public Long getNutricionistaId() {
	        return nutricionistaId;
	    }

	    public String getIme() {
	        return ime;
	    }

	    public String getPrezime() {
	        return prezime;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public Ordinacija getOrdinacija() {
	        return ordinacija;
	    }

	    
	    @Override
	    public String imeTabele() {
	        return "nutricionista";
	    }

	    @Override
	    public String vratiParametre() {
	        return String.format("%s, '%s', '%s', '%s', '%s', %s", nutricionistaId, ime, prezime, username, password, ordinacija.vratiPrimarniKljuc());
	    }

	    @Override
	    public String vratiNaziveParametara() {
	        return "nutricionistaId,ime,prezime,username,password,ordinacijaId";
	    }

	    @Override
	    public String vratiNazivPrimarnogKljuca() {
	        return "nutricionistaId";
	    }

	    @Override
	    public Long vratiPrimarniKljuc() {
	        return nutricionistaId;
	    }

	    @Override
	    public List<OpstaDomenskaKlasa> konvertujUListu(ResultSet rs) {
	        List<OpstaDomenskaKlasa> nutricionisti = new ArrayList<>();
	        try {
	            while (rs.next()) {
	                Long idBaza = rs.getLong("n.nutricionistaId");
	                String imeBaza = rs.getString("n.ime");
	                String prezimeBaza = rs.getString("n.prezime");
	                String usernameBaza = rs.getString("n.username");
	                String passwordBaza = rs.getString("n.password");
	                Long ordinacijaId = rs.getLong("n.ordinacijaId");
	                String imeOrdinacije = rs.getString("o.naziv");
	                Nutricionista n = new Nutricionista(idBaza, imeBaza, prezimeBaza, usernameBaza, passwordBaza, 
	                        new Ordinacija(ordinacijaId,imeOrdinacije));
	                
	                nutricionisti.add(n);
	            }
	        } catch (Exception ex) {
	            System.err.println("Greska u konvertovanju ResultSet-a u Nutricionista klasi! "+ex.getMessage());
	        }
	        return nutricionisti;
	    }

	    @Override
	    public String uslovZaIzmenu() {
	        return "nutricionistaId=" + nutricionistaId + ", ime=" + ime + ", prezime=" + prezime + ", username=" + username
	                + ", password=" + password + ", ordinacijaId=" + ordinacija.vratiPrimarniKljuc();
	    }

	    @Override
	    public String uslovZaJednog() {
	        return " n.username= '" + getUsername() + "' AND n.password= '" + getPassword() + "'";
	    }

	    @Override
	    public String toString() {
	        return  ime + " " + prezime;
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
	        final Nutricionista other = (Nutricionista) obj;
	        if (!Objects.equals(this.ime, other.ime)) {
	            return false;
	        }
	        return Objects.equals(this.prezime, other.prezime);
	    }

	    @Override
	    public int hashCode() {
	        int hash = 3;
	        hash = 59 * hash + Objects.hashCode(this.ime);
	        hash = 59 * hash + Objects.hashCode(this.prezime);
	        return hash;
	    }

	    @Override
	    public String spajanje() {
	        return " n join ordinacija o on (n.ordinacijaId = o.ordinacijaId)";
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
