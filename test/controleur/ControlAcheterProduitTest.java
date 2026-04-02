package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import personnages.*;
import villagegaulois.*;

class ControlAcheterProduitTest {

	private Village village;
	private Chef abracourcix;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlEmmenager controlEmmenager;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abracourcix = new Chef("Abracourcix", 10, village);
		village.setChef(abracourcix);

		controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		controlEmmenager.ajouterGaulois("Asterix", 10);

		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
	}

	@Test
	void testControlAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,
				controlTrouverEtalVendeur, village);
		assertNotNull(controlAcheterProduit, "Constructeur ne renvoie pas null");
	}

	@Test
	void testVerifierIdentiteAcheteur() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,
				controlTrouverEtalVendeur, village);

		assertTrue(controlAcheterProduit.verifierIdentiteAcheteur("Bonemine"), "Bonemine est un habitant connu");
		assertFalse(controlAcheterProduit.verifierIdentiteAcheteur("Existe pas"));
	}

	@Test
	void testRechercherProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,
				controlTrouverEtalVendeur, village);

		village.installerVendeur(new Gaulois("Asterix", 10), "poisson", 20);

		assertTrue(controlAcheterProduit.rechercherProduit("poisson"));
		assertFalse(controlAcheterProduit.rechercherProduit("chaudron"));
	}

	@Test
	void testAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,
				controlTrouverEtalVendeur, village);

		village.installerVendeur(new Gaulois("Asterix", 10), "poisson", 20);

		controlAcheterProduit.acheterProduit("Asterix", 5);
	}
}