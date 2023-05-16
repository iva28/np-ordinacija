package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Jelo extends OpstaDomenskaKlasa{

    private Long jeloId;
    private TipJela tip;
    private String naziv;
    private BigDecimal cena;
    private int kolicina;
    private Kuvar kuvar;

    public Jelo() {
    }

    public Jelo(Long jeloId, TipJela tip, String naziv, BigDecimal cena, int kolicina, Kuvar kuvar) {
        this.jeloId = jeloId;
        this.tip = tip;
        this.naziv = naziv;
        this.cena = cena;
        this.kolicina = kolicina;
        this.kuvar = kuvar;
    }

    public Long getJeloId() {
        return jeloId;
    }

    public TipJela getTip() {
        return tip;
    }

    public String getNaziv() {
        return naziv;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public int getKolicina() {
        return kolicina;
    }

    public Kuvar getKuvar() {
        return kuvar;
    }

    public void setJeloId(Long jeloId) {
        this.jeloId = jeloId;
    }

    public void setTip(TipJela tip) {
        this.tip = tip;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public void setKuvar(Kuvar kuvar) {
        this.kuvar = kuvar;
    }

    @Override
    public String toString() {
        return "Jelo{" + "jeloId=" + jeloId + ", tip=" + tip + ", naziv=" + naziv + ", cena=" + cena + ", kolicina=" + kolicina + ", kuvar=" + kuvar + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Jelo other = (Jelo) obj;
        return Objects.equals(this.naziv, other.naziv);
    }

    @Override
    public String imeTabele() {
        return "jelo";
    }

    @Override
    public String spajanje() {
        return " j join tipjela tj on (j.tip_id = tj.tipId) join kuvar k on (j.kuvar_id = k.kuvarId) ";
    }

    @Override
    public String vratiParametre() {
        return String.format(" '%s', %s, %s, %s, %s", naziv, cena,
                kolicina, tip.vratiPrimarniKljuc(), kuvar.vratiPrimarniKljuc());
    }

    @Override
    public String vratiNaziveParametara() {
        return "(naziv, cena, kolicina, tip_id, kuvar_id) ";
    }

    @Override
    public String vratiNazivPrimarnogKljuca() {
        return "jeloId";
    }

    @Override
    public Long vratiPrimarniKljuc() {
        return jeloId;
    }

    @Override
    public List<OpstaDomenskaKlasa> konvertujUListu(ResultSet rs) {
        List<OpstaDomenskaKlasa> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                Long jeloIdBaza = rs.getLong("j.jeloId");
                String nazivBaza = rs.getString("j.naziv");
                BigDecimal cenaBaza = rs.getBigDecimal("j.cena");
                int kolicinaBaza = rs.getInt("j.kolicina");
                Long tipId = rs.getLong("j.tip_id");
                Long kuvarId = rs.getLong("j.kuvar_id");

                String vrsta = rs.getString("tj.vrsta");
                String ime = rs.getString("k.ime");
                String prezime = rs.getString("k.prezime");

                lista.add(new Jelo(jeloIdBaza, new TipJela(tipId, vrsta),
                        nazivBaza, cenaBaza, kolicinaBaza, new Kuvar(kuvarId, ime, prezime, "", "")));
            }
        } catch (Exception e) {
            System.err.println("Greska u konvertovanju ReseultSet-a u Jelo klasi "+e.getMessage());
        }
        return lista;
    }

    @Override
    public String uslovZaIzmenu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String uslovZaJednog() {
        return null;
    }

    @Override
    public String vratiSlozenPrimarniKljuc() {
        return null;
    }

    @Override
    public String uslovZaVise() {
        if (tip == null && kuvar != null) {
            return " j.kuvar_id = " + kuvar.getKuvarId();
        }
        if (kuvar == null && tip != null) {
            return "j.tip_id = " + tip.getTipId();
        }
        return "j.tip_id = " + tip.getTipId() + " AND j.kuvar_id = " + kuvar.getKuvarId();
    }

    @Override
    public String uslovZaBrisanjeVise() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
