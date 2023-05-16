package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TipJela extends OpstaDomenskaKlasa{

	 private Long tipId;
	    private String vrsta;

	    public TipJela(Long tipId, String vrsta) {
	        this.tipId = tipId;
	        this.vrsta = vrsta;
	    }

	    public TipJela() {
	    }

	    public Long getTipId() {
	        return tipId;
	    }

	    public String getVrsta() {
	        return vrsta;
	    }

	    public void setTipId(Long tipId) {
	        this.tipId = tipId;
	    }

	    public void setVrsta(String vrsta) {
	        this.vrsta = vrsta;
	    }

	    @Override
	    public String toString() {
	        return   vrsta;
	    }

	    @Override
	    public int hashCode() {
	        int hash = 5;
	        hash = 97 * hash + Objects.hashCode(this.tipId);
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
	        final TipJela other = (TipJela) obj;
	        return Objects.equals(this.tipId, other.tipId);
	    }
	    
	    

	    @Override
	    public String imeTabele() {
	        return "tipjela";
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
	        return "tipId";
	    }

	    @Override
	    public Long vratiPrimarniKljuc() {
	        return tipId;
	    }


	    @Override
	    public List<OpstaDomenskaKlasa> konvertujUListu(ResultSet rs) {
	         List<OpstaDomenskaKlasa> jela = new ArrayList<>();
	        try {
	            while (rs.next()) {
	                Long tipIdBaza = rs.getLong("tipId");
	                String vrstaBaza = rs.getString("vrsta");
	                jela.add(new TipJela(tipIdBaza, vrstaBaza));
	            }
	        } catch (SQLException ex) {
	            System.err.println("Greška u konvertovanju u ResultSet-u u Tip Jelo klasi! "+ex.getMessage());
	        }
	        return jela;
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
