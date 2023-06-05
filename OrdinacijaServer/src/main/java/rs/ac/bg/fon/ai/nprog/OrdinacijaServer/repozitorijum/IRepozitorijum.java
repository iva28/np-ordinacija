package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.repozitorijum;

import java.util.List;

/**
 * Predstavlja genericki repozitorijum koji definise osnovne operacije nad objektima tipa T
 *
 * @param <T> Tip objekata sa kojima ce se raditi u repozitorijumu
 * @author Iva Stanisic
 */
public interface IRepozitorijum<T> {
    /**
     * Vraca sve objekte tipa T iz repozitorijuma koji zadovoljavaju odredjeni parametar
     *
     * @param param Parametar na osnovu kojeg se vrsi pretraga 
     * @return Lista objekata tipa T koji zadovoljavaju parametar
     * @throws Exception ako dodje do greske prilikom izvrsavanja metode
     */
    List<T> svi(T param) throws Exception;
    /**
     * Dodaje novi objekat tipa T u repozitorijum
     *
     * @param param Objekat koji se dodaje
     * @return Identifikator novododatog objekta
     * @throws Exception ako dodje do greske prilikom izvrsavanja metode
     */
    Long dodaj(T param) throws Exception;
    /**
     *Vraca jedan objekat tipa T iz repozitorijuma na osnovu datog parametra
     *
     * @param param Parametar na osnovu kojeg se vrsi pretraga objekata
     * @return Objekat tipa T koji zadovoljava parametar
     * @throws Exception ako dodje do greske prilikom izvrsavanja metode
     */
    T vratiJednog(T param) throws Exception;
    /**
     * Brise objekat tipa T iz repozitorijuma
     *
     * @param param Objekat koji se brise
     * @return True ukoliko je objekat uspesno obrisan, false inace
     * @throws Exception ako dodje do greske prilikom izvrsavanja metode
     */
    boolean obrisi(T param)throws Exception;
    /**
     * Vrsi izmenu podataka objekta tipa T u repozitorijumu
     *
     * @param param Objekat koji se menja
     * @return True ukoliko je izmena uspesno izvrsena, false inace
     * @throws Exception ako dodje do greske prilikom izvrsavanja metode
     */
    boolean izmena(T param) throws Exception;
    /**
     * Vrsi pretragu objekata tipa T u repozitorijumu na osnovu datog parametra
     *
     * @param param Parametar na osnovu kojeg se vrsi pretraga objekata
     * @return Lista objekata tipa T koji zadovoljavaju parametar
     * @throws Exception ako dodje do greske prilikom izvrsavanja metode
     */
    List<T> nadji(T param) throws Exception;
}
