package fr.pgah.java.unbrco.model.bibliotheque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import fr.pgah.java.unbrco.model.livre.Livre;
import fr.pgah.java.unbrco.model.livre.GenreLivre;

public class BibliothecaireTests {

  private Livre livreRef;
  private Livre livreRom;
  private Livre livreBiblio;
  private Livre livreMan;
  private Livre livreCui;
  private Bibliotheque testBiblio1, testBiblio2;
  private Bibliothecaire testBibliothecaire;

  @BeforeEach
  public void setUp() {
    testBiblio1 = new Bibliotheque("Bibliothèque privée Dampierre", testBibliothecaire);
    testBiblio2 = new Bibliotheque("Bibliothèque du même réseau", null);

    livreRef = new Livre("Dormir n'importe où", "E. Clément, B. Briendo", GenreLivre.REFERENCE, 2021, 1);
    livreRef.setBibliothequeMere(testBiblio1);
    livreRom = new Livre("Pizza mon amour", "T. Geneste", GenreLivre.ROMAN, 2020, 2);
    livreRom.setBibliothequeMere(testBiblio1);
    livreBiblio = new Livre("Ma vie avec lui", "A. Krzykawsky", GenreLivre.BIBLIOGRAPHIE, 2023, 1);
    livreBiblio.setBibliothequeMere(testBiblio1);
    livreMan = new Livre("Introduction à la programmation C#", "M. Giera", GenreLivre.MANUEL, 2035, 2);
    livreMan.setBibliothequeMere(testBiblio1);
    livreCui = new Livre("Maîtriser l'Art de l'Américain-cervelas", "Q. Delaporte", GenreLivre.CUISINE, 2020, 2);
    livreCui.setBibliothequeMere(testBiblio1);

    testBibliothecaire = new Bibliothecaire("Kevin Roy", 10, testBiblio1, livreRom);
  }

  @Test
  public void testInformationBibliotecaire() {
    assertEquals("Kevin Roy", testBibliothecaire.getNom());
    assertEquals(testBiblio1, testBibliothecaire.getBibliotheque());
    assertEquals(10, testBibliothecaire.getAge());
    assertEquals(livreRom, testBibliothecaire.getLivreFavori());
  }

  @Test
  public void testChangementBibliotheque() {
    testBibliothecaire.changerDeBibliotheque(testBiblio2);
    assertEquals(testBiblio2, testBibliothecaire.getBibliotheque());

    testBibliothecaire.changerDeBibliotheque(testBiblio1);
    assertEquals(testBiblio1, testBibliothecaire.getBibliotheque());
  }
}
