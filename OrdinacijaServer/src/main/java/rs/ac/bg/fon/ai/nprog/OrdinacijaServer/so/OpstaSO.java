package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.repozitorijum.db.KonekcijaSaBazom;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.repozitorijum.db.impl.DBBroker;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;

/**
 *
 * @author Iva
 */
public abstract class OpstaSO {
    protected DBBroker db = new DBBroker();
    public final void izvrsiOperaciju(OpstaDomenskaKlasa obj) throws Exception {
        try {
            validiraj(obj);
            KonekcijaSaBazom.getInstanca().otvoriKonekciju();
            izvrsiSpecificnuOperaciju(obj);
            KonekcijaSaBazom.getInstanca().potvrdiTransakciju();
        } catch (Exception e) {
            KonekcijaSaBazom.getInstanca().ponistiTransakciju();
        } finally {
            KonekcijaSaBazom.getInstanca().zatvoriKonekciju();
        }
    }
    protected abstract void izvrsiSpecificnuOperaciju(OpstaDomenskaKlasa obj) throws Exception;
    protected abstract void validiraj(OpstaDomenskaKlasa obj) throws Exception;
}
