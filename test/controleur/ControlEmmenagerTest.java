package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import personnages.*;
import villagegaulois.*;

class ControleEmmenagerTest {

    private Village village;
    private Chef abracourcix;

    @BeforeEach
    public void initialiserSituation() {
        System.out.println("Initialisation...");
        village = new Village("le village des irréductibles", 10, 5);
        abracourcix = new Chef("Abracourcix", 10, village);
        village.setChef(abracourcix);
    }

    @Test
    void testControleEmmenager() {
        ControlEmmenager controlEmmenager = new ControlEmmenager(village);
        assertNotNull(controlEmmenager, "Constructeur ne renvoie pas null");
    }

    @Test
    void testIsHabitant() {
        ControlEmmenager controlEmmenager = new ControlEmmenager(village);
        controlEmmenager.ajouterGaulois("Bonemine", 10);
        assertTrue(controlEmmenager.isHabitant("Bonemine"));
        assertFalse(controlEmmenager.isHabitant("Existe pas"));
        controlEmmenager.ajouterDruide("Panoramix", 10, 1, 5);
        assertTrue(controlEmmenager.isHabitant("Panoramix"));
    }

    @Test
    void testAjouterDruide() {
        ControlEmmenager controlEmmenager = new ControlEmmenager(village);
        controlEmmenager.ajouterDruide("Panoramix", 10, 1, 5);
    }
}
