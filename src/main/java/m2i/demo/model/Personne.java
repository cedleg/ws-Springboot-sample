package m2i.demo.model;

import org.springframework.data.annotation.Id;

public class Personne {

    @Id
    private String nom;
    private String prenom;
    private int age;

    public Personne() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personne personne = (Personne) o;

        if (age != personne.age) return false;
        if (nom != null ? !nom.equals(personne.nom) : personne.nom != null) return false;
        return prenom != null ? prenom.equals(personne.prenom) : personne.prenom == null;
    }

    @Override
    public int hashCode() {
        int result = nom != null ? nom.hashCode() : 0;
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                '}';
    }
}
