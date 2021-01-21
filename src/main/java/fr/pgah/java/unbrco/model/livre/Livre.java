package fr.pgah.java.unbrco.model.livre;

import fr.pgah.java.unbrco.model.bibliotheque.Bibliotheque;

public class Livre {

  private String titre;
  private String auteur;
  private GenreLivre genre;
  private int annee;
  private int edition;
  private Bibliotheque bibliothequeMere;
  private boolean estSortie;

  public Livre(String titre, String auteur, GenreLivre genre, int annee, int ed) {

    this.titre = titre;
    this.auteur = auteur;
    this.genre = genre;
    this.annee = annee;
    this.edition = ed;
    this.estSortie = false;

  }

  public String getTitre() {
    return titre;
  }

  public String getAuteur() {
    return auteur;
  }

  public GenreLivre getGenre() {
    return genre;
  }

  public int getAnnee() {
    return annee;
  }

  public int getEdition() {
    return edition;
  }

  public Bibliotheque getBibliothequeMere() {
    return bibliothequeMere;
  }

  public void setBibliothequeMere(Bibliotheque home) {
    this.bibliothequeMere = home;
    home.enregistrerLivre(this);
  }

  // MODIFIE : this
  // EFFETS : enregistre le fait que le livre est revenu
  public void enregistrerRetour() {
    this.estSortie = false;
  }

  // RENVOIE : vrai si le livre est sorti
  public boolean estSorti() {
    return estSortie;
  }

  // MODIFIE : this
  // EFFETS : enregistre le fait que le livre est sorti
  public void enregistrerSortie() {
    this.estSortie = true;
  }
}
