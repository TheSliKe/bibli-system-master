package fr.pgah.java.unbrco.model.bibliotheque;

import java.util.ArrayList;
import java.util.List;

import fr.pgah.java.unbrco.model.livre.Livre;

public class Bibliotheque {

  private Bibliothecaire gerant;
  private String nom;
  private List<Bibliotheque> branches;
  private List<Livre> livresReference;
  private List<Livre> livresRomans;
  private List<Livre> livresBiographie;
  private List<Livre> livresManuels;
  private List<Livre> livreCuisine;

  public Bibliotheque(String nom, Bibliothecaire gerant) {

    this.nom = nom;
    this.gerant = gerant;

    this.branches = new ArrayList<Bibliotheque>();
    this.livresReference = new ArrayList<Livre>();
    this.livresRomans = new ArrayList<Livre>();
    this.livresBiographie = new ArrayList<Livre>();
    this.livresManuels = new ArrayList<Livre>();
    this.livreCuisine = new ArrayList<Livre>();

  }

  public String getNom() {
    return nom;
  }

  public Bibliothecaire getGerant() {
    return gerant;
  }

  // PREREQUIS : livre != null
  // MODIFIE : this
  // EFFETS : stocke livre dans la collection appropriée de cet objet
  public void enregistrerLivre(Livre livre) {

    if (livre != null) {
      
      switch (livre.getGenre()) {
        case REFERENCE:
          livresReference.add(livre);
        break;
        case ROMAN:
          livresRomans.add(livre);
        break;
        case BIBLIOGRAPHIE:
          livresBiographie.add(livre);
        break;
        case MANUEL:
          livresManuels.add(livre);
        break;
        case CUISINE:
          livreCuisine.add(livre);
        break;
      }

    }

  }

  // PREREQUIS : livre != null
  // RENVOIE : vrai si livre est dans le catalogue de cette bibliothèque
  // (qu'il soit actuellement emprunté ou non)
  public boolean estDansCatalogue(Livre livre) {

    if (livre != null) {

      switch (livre.getGenre()) {
        case REFERENCE:
          return trouverLivre(livresReference, livre);
        
        case ROMAN:
          return trouverLivre(livresRomans, livre);
        
        case BIBLIOGRAPHIE:
          return trouverLivre(livresBiographie, livre);
      
        case MANUEL:
          return trouverLivre(livresManuels, livre);
      
        case CUISINE:
          return trouverLivre(livreCuisine, livre);
        
        default :
          return false;
      }

    }
    return false;

  }

  // PREREQUIS: livre != null
  // RENVOIE : vrai si livre est disponible à l'emprunt
  public boolean peutEtreEmprunte(Livre livre) {

    if (livre != null) {

      if (livre.estSorti()) {
        return false;
      }
      return true;

    }
    return false;
  }

  // PREREQUIS : livre != null
  // RENVOIE : vrai si livre est dans le catalogue de cette bibliotheque
  // ou dans celui de l'un de ses branches
  public boolean estDansCatalogueEtendu(Livre livre) {

    if (livre != null) {

      if (estDansCatalogue(livre)) {
        return true;
      }

      for (Bibliotheque bibliotheque : branches) {
        
        if (bibliotheque.estDansCatalogue(livre)) {
          return true;
        }

      }

      return false;
    
    }
    return false;

  }

  // PREREQUIS : livre != null
  // MODIFIE : this
  // EFFETS : enregistre le fait que livre est maintenant emprunté (si possible)
  // RENVOIE : vrai si l'opération est un succès
  public boolean enregistrerSortie(Livre livre) {

    if (livre != null) {

      if (livre.estSorti()) {
        return false;
      }
      
      livre.enregistrerSortie();
      return true;

    }
    return false;
  }

  // PREREQUIS : livre != null
  // MODIFIE : this
  // EFFETS : enregistre le fait que livre est revenu (si possible)
  // RENVOIE : vrai si l'opération est un succès
  public boolean enregistrerRetour(Livre livre) {
    
    if (livre != null) {

      if (!livre.estSorti()) {
        return false;
      }

      livre.enregistrerRetour();
      return true;
      

    }
    return false;

  }

  // PREREQUIS : gerant != null
  // MODIFIE : this
  // EFFETS : set le nouveau gérant
  // RENVOIE : vrai si l'opération est un succès
  public boolean engagerGerant(Bibliothecaire bibliothecaire) {

    if (bibliothecaire != null) {
     
      this.gerant = bibliothecaire;
      return true;

    }
    return false;
  }


  // EFFETS : affiche le catalogue de cette bibliothèque
  // (toutes les informations de chaque livre)
  public void afficherCatalogue() {

    System.out.println("----Livre REFERENCE----");
    for (Livre livre : livresReference) {
      System.out.println(livre.getTitre() + " " + livre.getAuteur() + " " + livre.getGenre() + " " + livre.getAnnee() + " " + livre.getEdition() + " " + livre.getBibliothequeMere());
    }

    System.out.println("----Livre ROMAN----");
    for (Livre livre : livresRomans) {
      System.out.println(livre.getTitre() + " " + livre.getAuteur() + " " + livre.getGenre() + " " + livre.getAnnee() + " " + livre.getEdition() + " " + livre.getBibliothequeMere());
    }

    System.out.println("----Livre BIBLIOGRAPHIE----");
    for (Livre livre : livresBiographie) {
      System.out.println(livre.getTitre() + " " + livre.getAuteur() + " " + livre.getGenre() + " " + livre.getAnnee() + " " + livre.getEdition() + " " + livre.getBibliothequeMere());
    }

    System.out.println("----Livre MANUEL----");
    for (Livre livre : livresManuels) {
      System.out.println(livre.getTitre() + " " + livre.getAuteur() + " " + livre.getGenre() + " " + livre.getAnnee() + " " + livre.getEdition() + " " + livre.getBibliothequeMere());
    }

    System.out.println("----Livre CUISINE----");
    for (Livre livre : livreCuisine) {
      System.out.println(livre.getTitre() + " " + livre.getAuteur() + " " + livre.getGenre() + " " + livre.getAnnee() + " " + livre.getEdition() + " " + livre.getBibliothequeMere());
    }

  }

  //---------------------------------------------------------------

  private boolean trouverLivre(List<Livre> livres, Livre livre){

    for (Livre livreL : livres) {
      
      if (livreL.equals(livre)) {
        return true;
      }

    }

  return false;
  }

}
