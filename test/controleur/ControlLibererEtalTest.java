package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import personnages.*;
import villagegaulois.*;

class ControlLibererEtalTest {

    private Village village;
    private Chef abracourcix;
    private ControlEmmenager controlEmmenager;
    private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

    @BeforeEach
    public void initialiserSituation() {
        System.out.println("Initialisation...");
        village = new Village("le village des irréductibles", 10, 5);
        abracourcix = new Chef("Abracourcix", 10, village);
        village.setChef(abracourcix);

        controlEmmenager = new ControlEmmenager(village);
        controlEmmenager.ajouterGaulois("Asterix", 10);

        controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
    }

    @Test
    void testControlLibererEtal() {
        ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
        assertNotNull(controlLibererEtal);
    }

    @Test
    void testIsVendeur() {
        ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
        village.installerVendeur(village.trouverHabitant("Asterix"), "poisson", 20);
        assertTrue(controlLibererEtal.isVendeur("Asterix"));
        assertFalse(controlLibererEtal.isVendeur("Existe pas"));
    }

    @Test
    void testLibererEtal() {
        ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
        village.installerVendeur(village.trouverHabitant("Asterix"), "poisson", 20);
        String[] donneesEtal = controlLibererEtal.libererEtal("Asterix");
        assertNotNull(donneesEtal);
    }

    @Test
    void testLibererEtalVendeurInexistant() {
        ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
        String[] donneesEtal = controlLibererEtal.libererEtal("Existe pas");
        assertNull(donneesEtal);
    }
}