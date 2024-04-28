package abdou.dev.Controllers;

import abdou.dev.Entities.Utilisateur;
import abdou.dev.Exception.UtilisateurNotFoundException;
import abdou.dev.Services.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@AllArgsConstructor
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/utilisateurs")
    public String AffichagelistUtilisateur(Model model){
        List<Utilisateur> ListUtilisateurs= utilisateurService.listAllUtilisateur();
        model.addAttribute("ListUtilisateurs",ListUtilisateurs);
        return "/utilisateurs";
    }
    @GetMapping("/utilisateurs/ajouter")
    public String AjouterUtilisateur(Model model){
        model.addAttribute("utilisateurs",new Utilisateur());
        return "/utilisateur_formulaire";
    }
    @PostMapping("/utilisateurs/save")
    public String SaveUtilisateur(Utilisateur utilisateur ,RedirectAttributes redirectSMS){
        utilisateurService.saveUtilisateur(utilisateur);
        redirectSMS.addFlashAttribute("message","Utilisateur ajouter avec success");
        return "redirect:/utilisateurs";
    }
    @GetMapping("/utilisateurs/modifier/{id}")
    public String modifierUtilisateur(@PathVariable("id") Long id , Model model, RedirectAttributes redirectSMS)  {
      try {
          Utilisateur utilisateur=  utilisateurService.getUtilisateur(id);
          model.addAttribute("utilisateurs",utilisateur);
          return "utilisateur_formulaire";
      }catch (UtilisateurNotFoundException e ){
          redirectSMS.addFlashAttribute("Etudiant modifier avec Success");
          return "redirect:/utilisateurs";
      }
    }


    @GetMapping("/utilisateurs/supprimer/{id}")
    public String supprimerUtilisateur(@PathVariable("id") Long id){
        utilisateurService.SupprimerUtilisateur(id);
        return "redirect:/utilisateurs";
    }
}
