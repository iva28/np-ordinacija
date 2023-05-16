package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StavkaPlanaIshrane extends OpstaDomenskaKlasa{

	private Long rb;
    private BigDecimal cena;
    private int kolicina;
    private Jelo jelo;
    private PlanIshrane planIshrane;
    
    public StavkaPlanaIshrane() {
    }
    
    public StavkaPlanaIshrane(Long rb, BigDecimal cena, int kolicina, Jelo jelo) {
        this.rb = rb;
        this.cena = cena;
        this.kolicina = kolicina;
        this.jelo = jelo;
    }
    
    public StavkaPlanaIshrane(PlanIshrane planIshrane) {
        this.planIshrane = planIshrane;
    }
    
    public Long getRb() {
        return rb;
    }
    
    public BigDecimal getCena() {
        return cena;
    }
    
    public int getKolicina() {
        return kolicina;
    }
    
    public Jelo getJelo() {
        return jelo;
    }
    
    public PlanIshrane getPlanIshrane() {
        return planIshrane;
    }
    
    public void setRb(Long rb) {
        this.rb = rb;
    }
    
    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }
    
    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }
    
    public void setJelo(Jelo jelo) {
        this.jelo = jelo;
    }
    
    public void setPlanIshrane(PlanIshrane planIshrane) {
        this.planIshrane = planIshrane;
    }
    
    @Override
    public String toString() {
        return "StavkaPlanaIshrane{" + "rb=" + rb + ", cena=" + cena + ", kolicina=" + kolicina + ", jelo=" + jelo + ", planIshrane=" + planIshrane + '}';
    }
    
    @Override
    public String imeTabele() {
        return "stavkaplanaishrane";
    }
    
    @Override
    public String vratiParametre() {
        return String.format(" %s, %s, %s, %s", cena,
                kolicina, planIshrane.vratiPrimarniKljuc(), jelo.vratiPrimarniKljuc());
    }
    
    @Override
    public String vratiNaziveParametara() {
         return "(cena, kolicina, planishraneId, jelo_id) ";
    }
    
    @Override
    public String vratiNazivPrimarnogKljuca() {
        return null;
    }
    
    @Override
    public Long vratiPrimarniKljuc() {
        return null;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.rb);
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
        final StavkaPlanaIshrane other = (StavkaPlanaIshrane) obj;
        return Objects.equals(this.jelo, other.jelo);
    }
    
    
    
    @Override
    public List<OpstaDomenskaKlasa> konvertujUListu(ResultSet rs) {
        List<OpstaDomenskaKlasa> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                Long rbBaza = rs.getLong("s.rb");
                BigDecimal cenaBaza = rs.getBigDecimal("s.cena");
                int kolicinaBaza = rs.getInt("s.kolicina");
                 Long planIshraneId = rs.getLong("s.planishraneId");
                
                Long jeloId = rs.getLong("s.jelo_id");
                
                String nazivJela = rs.getString("j.naziv");
                BigDecimal cenaJelaBaza = rs.getBigDecimal("j.cena");
                int gramaza = rs.getInt("j.kolicina");
                
                Long tipId = rs.getLong("j.tip_id");
                Long kuvarId = rs.getLong("j.kuvar_id");
                
                String vrstaJela = rs.getString("tj.vrsta");
                
                String imeKuvara = rs.getString("k.ime");
                String prezimeKuvara = rs.getString("k.prezime");
                
                StavkaPlanaIshrane nova = new StavkaPlanaIshrane();
                nova.setRb(rbBaza);
                
                nova.setPlanIshrane(new PlanIshrane(planIshraneId));
                nova.setPlanIshrane(planIshrane);
                nova.setJelo(new Jelo(jeloId, new TipJela(tipId, vrstaJela), nazivJela,
                        cenaJelaBaza, gramaza, new Kuvar(kuvarId, imeKuvara, prezimeKuvara)));
                nova.setKolicina(kolicinaBaza);
                nova.setCena(cenaBaza);
                lista.add(nova);
            }
        } catch (Exception e) {
            System.err.println("Greska u konvertovanju liste u Stavka plana ishrane klasi! "+e.getMessage());
        }
        return lista;
    }
    
    @Override
    public String uslovZaIzmenu() {
        return " cena = " + cena + " ,kolicina = " + kolicina
                + " ,planishraneId = " + planIshrane.vratiPrimarniKljuc() + " , jelo_id = " + jelo.vratiPrimarniKljuc();
    }
    
    @Override
    public String uslovZaJednog() {
        return null;
    }
    
    @Override
    public String spajanje() {
        return " s join planishrane p on (s.planishraneId = p.planishraneId) "
                + "join jelo j on (s.jelo_id = j.jeloId) "
                + "join tipjela tj on (j.tip_id = tj.tipId)"
                + " join kuvar k on (j.kuvar_id = k.kuvarId) ";
    }
    
    @Override
    public String vratiSlozenPrimarniKljuc() {
        return "planishraneId = "+planIshrane.vratiPrimarniKljuc()+" AND rb = "+getRb();
    }
    
    @Override
    public String uslovZaVise() {
        return "s.planishraneId = " + planIshrane.vratiPrimarniKljuc();
    }

    @Override
    public String uslovZaBrisanjeVise() {
        return " planishraneId = "+planIshrane.vratiPrimarniKljuc();
    }

}
