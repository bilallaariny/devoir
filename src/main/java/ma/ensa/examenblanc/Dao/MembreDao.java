package ma.ensa.examenblanc.Dao;

import ma.ensa.examenblanc.Membre;
import ma.ensa.examenblanc.Incident;
import java.util.List;
public interface MembreDao {
    public void insere(Membre m);
    public List<Incident> chargerListIncidents();

}
