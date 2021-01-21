package fr.pgah.java.unbrco.model.livre;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import fr.pgah.java.unbrco.model.bibliotheque.Bibliothecaire;
import fr.pgah.java.unbrco.model.bibliotheque.Bibliotheque;

public class LivreTests {

  private Livre livreRef;
  private Livre livreRom;
  private Livre livreBiblio;
  private Livre livreMan;
  private Livre livreCui;
  private Bibliotheque testBibliotheque;
  private Bibliothecaire testBibliothecaire;

  @BeforeEach
  public void setUp() {
    testBibliotheque = new Bibliotheque("Bibliothèque privée Dampierre", testBibliothecaire);
    testBibliothecaire = new Bibliothecaire("Kevin Roy", 10, testBibliotheque, livreRom);

    livreRef =
        new Livre("Dormir n'importe où", "E. Clément, B. Briendo", GenreLivre.REFERENCE, 2021, 1);
    livreRef.setBibliothequeMere(testBibliotheque);
    livreRom = new Livre("Pizza mon amour", "T. Geneste",
        GenreLivre.ROMAN, 2020, 2);
    livreRom.setBibliothequeMere(testBibliotheque);
    livreBiblio =
        new Livre("Ma vie avec lui", "A. Krzykawsky",
            GenreLivre.BIBLIOGRAPHIE, 2023, 1);
    livreBiblio.setBibliothequeMere(testBibliotheque);
    livreMan = new Livre("Introduction à la programmation C#", "M. Giera",
        GenreLivre.MANUEL, 2035, 2);
    livreMan.setBibliothequeMere(testBibliotheque);
    livreCui = new Livre("Maîtriser l'Art de l'Américain-cervelas", "Q. Delaporte",
        GenreLivre.CUISINE, 2020, 2);
    livreCui.setBibliothequeMere(testBibliotheque);
  }

  @Test
  public void test1() {
    assertEquals(livreRef.getTitre(), "Dormir n'importe où");
    assertEquals(livreMan.getAuteur(), "M. Giera");
    assertEquals(livreCui.getGenre(), GenreLivre.CUISINE);
    assertEquals(livreRom.getAnnee(), 2020);
    assertEquals(livreCui.getEdition(), 2);
    assertEquals(livreCui.getBibliothequeMere(), testBibliotheque);
  }

  @Test
  public void test2() {
    assertEquals(livreRef.estSorti(), false);
    livreRef.enregistrerSortie();
    assertEquals(livreRef.estSorti(), true);
    livreRef.enregistrerRetour();
    assertEquals(livreRef.estSorti(), false);
  }
}
