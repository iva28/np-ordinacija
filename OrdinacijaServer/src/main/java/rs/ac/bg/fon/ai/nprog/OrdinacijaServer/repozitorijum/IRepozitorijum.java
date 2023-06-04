package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.repozitorijum;

import java.util.List;

/**
 *
 * @author Iva
 * @param <T>
 */
public interface IRepozitorijum<T> {
    List<T> svi(T param) throws Exception;
    Long dodaj(T param) throws Exception;
    T vratiJednog(T param) throws Exception;
    boolean obrisi(T param)throws Exception;
    boolean izmena(T param) throws Exception;
    List<T> nadji(T param) throws Exception;
}
