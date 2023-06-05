package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.repozitorijum.db.impl;

import java.util.List;
import java.sql.*;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.repozitorijum.IRepozitorijum;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.repozitorijum.db.KonekcijaSaBazom;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;

/**
 * Predstavlja broker za pristup bazi podataka koji implementira interfejs IRepozitorijum.
 * 
 * Omogucava izvrsavanje osnovnih operacija nad objektima tipa OpstaDomenskaKlasa
 *
 * @author Iva Stanisic
 */
public class DBBroker implements IRepozitorijum<OpstaDomenskaKlasa> {

    @Override
    public Long dodaj(OpstaDomenskaKlasa param) throws Exception {
        try {
            Connection conn = KonekcijaSaBazom.getInstanca().otvoriKonekciju();
            String sql = "INSERT INTO " + param.imeTabele() + param.vratiNaziveParametara() + "VALUES ("
                    + param.vratiParametre() + ")";
            PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            Long id = -1L;
            if (rs.next()) {
                id = rs.getLong(1);
            }
            return id;
        } catch (Exception e) {
            System.err.println("Ne može da sačuva: " + param.imeTabele());
            throw e;
        }
    }

    @Override
    public OpstaDomenskaKlasa vratiJednog(OpstaDomenskaKlasa param) throws Exception {
        try {
            Connection conn = KonekcijaSaBazom.getInstanca().otvoriKonekciju();
            String sql = "SELECT * FROM " + param.imeTabele() + param.spajanje() + " WHERE " + param.uslovZaJednog();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<OpstaDomenskaKlasa> list = param.konvertujUListu(rs);
            if (list == null || list.isEmpty()) {
                return null;
            }
            OpstaDomenskaKlasa result = list.get(0);
            rs.close();
            st.close();
            return result;
        } catch (Exception e) {
            System.err.println("Ne može da nađe "+param.imeTabele());
            throw e;
        }
    }

    @Override
    public boolean obrisi(OpstaDomenskaKlasa param) throws Exception {
        try {
            Connection conn = KonekcijaSaBazom.getInstanca().otvoriKonekciju();
            String sql;
            if (param.vratiSlozenPrimarniKljuc() == null) {
                sql = "DELETE FROM " + param.imeTabele() + " WHERE " + param.vratiNazivPrimarnogKljuca() + " = " + param.vratiPrimarniKljuc();
            } else {
                sql = "DELETE FROM " + param.imeTabele()+ " WHERE " + param.uslovZaBrisanjeVise();
            }
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            st.close();
            return true;
        } catch (Exception e) {
            System.err.println("Ne može da obriše: " + param.imeTabele());
            throw e;
        }
    }

    @Override
    public boolean izmena(OpstaDomenskaKlasa param) throws Exception {
        try {
            Connection conn = KonekcijaSaBazom.getInstanca().otvoriKonekciju();
            String sql;
            if (param.vratiSlozenPrimarniKljuc() == null) {
                sql = "UPDATE " + param.imeTabele() + " SET " + param.uslovZaIzmenu()
                        + " WHERE " + param.vratiNazivPrimarnogKljuca() + " = " + param.vratiPrimarniKljuc();
            } else {
                sql = "UPDATE " + param.imeTabele() + " SET " + param.uslovZaIzmenu()
                        + " WHERE " + param.vratiSlozenPrimarniKljuc();
            }
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            st.close();
            return true;
        } catch (Exception e) {
            System.err.println("Ne može da ažurira: " + param.imeTabele());
            throw e;
        }
    }

    @Override
    public List<OpstaDomenskaKlasa> svi(OpstaDomenskaKlasa param) throws Exception {
        try {
            Connection conn = KonekcijaSaBazom.getInstanca().otvoriKonekciju();
            String sql = "SELECT * FROM " + param.imeTabele() + param.spajanje();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<OpstaDomenskaKlasa> list = param.konvertujUListu(rs);
            rs.close();
            st.close();
            return list;
        } catch (Exception e) {
            System.err.println("Ne može da vrati sve: " + param.imeTabele());
            throw e;
        }
    }

    @Override
    public List<OpstaDomenskaKlasa> nadji(OpstaDomenskaKlasa param) throws Exception {
        try {
            Connection conn = KonekcijaSaBazom.getInstanca().otvoriKonekciju();
            String sql = "Select * FROM " + param.imeTabele() + param.spajanje() + " WHERE " + param.uslovZaVise();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<OpstaDomenskaKlasa> list = param.konvertujUListu(rs);
            rs.close();
            st.close();
            return list;
        } catch (Exception e) {
            System.err.println("Ne može da nađe: " + param.imeTabele());
            throw e;
        }
    }

}
