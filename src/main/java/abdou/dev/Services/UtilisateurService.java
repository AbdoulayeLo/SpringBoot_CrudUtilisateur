package abdou.dev.Services;

import abdou.dev.Entities.Utilisateur;
import abdou.dev.Exception.UtilisateurNotFoundException;
import abdou.dev.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService{
    @Autowired
    public UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> listAllUtilisateur(){
      return (List<Utilisateur>) utilisateurRepository.findAll();
    }

    public Utilisateur getUtilisateur(Long id) throws UtilisateurNotFoundException {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        if (utilisateur.isPresent()){
            return utilisateur.get();
        }
        throw new UtilisateurNotFoundException("Pas d'utilisateur ce ID"+id);
    }

    public void saveUtilisateur(Utilisateur utilisateur){
         utilisateurRepository.save(utilisateur);
    }
    public void SupprimerUtilisateur(Long id){
        utilisateurRepository.deleteById(id);
    }
}
