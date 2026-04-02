package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import personnages.*;
import villagegaulois.*;

class ControlPrendreEtalTest {

    private Village village;
    private Chef abracourcix;
    private ControlVerifierIdentite controlVerifierIdentite;
    private ControlEmmenager controlEmmenager;

    @BeforeEach
    public void initialiserSituation() {
        System.out.println("Initialisation...");
        village = new Village("le village des irréductibles", 10, 5);
        abracourcix = new Chef("Abracourcix", 10, village);
        village.setChef(abracourcix);

        controlEmmenager = new ControlEmmenager(village);
        controlEmmenager.ajouterGaulois("Asterix", 10);
        controlEmmenager.ajouterGaulois("Bonemine", 10);

        controlVerifierIdentite = new ControlVerifierIdentite(village);
    }

    @Test
    void testControlPrendreEtal() {
        ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
        assertNotNull(controlPrendreEtal);
    }

    @Test
    void testResteEtals() {
        ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
        assertTrue(controlPrendreEtal.resteEtals());
    }

    @Test
    void testVerifierIdentite() {
        ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
        assertTrue(controlPrendreEtal.verifierIdentite("Asterix"));
        assertFalse(controlPrendreEtal.verifierIdentite("Existe pas"));
    }

    @Test
    void testPrendreEtal() {
        ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
        controlPrendreEtal.prendreEtal("Asterix", "poisson", 20);
    }
}