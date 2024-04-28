package abdou.dev.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Entity
@Table
@Setter
@Getter
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String prenom;
    private String nom;
    private Integer age;
    private String email;
    private Date date_insctit;

    public Utilisateur() {
    }

    public Utilisateur(Long id, String prenom, String nom, Integer age, String email, Date date_insctit) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
        this.email = email;
        this.date_insctit = date_insctit;
    }

    public Utilisateur(String prenom, String nom, Integer age, String email, Date date_insctit) {
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
        this.email = email;
        this.date_insctit = date_insctit;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", date_insctit=" + date_insctit +
                '}';
    }
}
