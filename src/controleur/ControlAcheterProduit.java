package controleur;

import villagegaulois.*;
import personnages.*;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur, Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierIdentiteAcheteur(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}

	public int acheterProduit(String nomVendeur, int quantite) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return etal.acheterProduit(quantite);
	}

	public boolean rechercherProduit(String produit) {
		return village.rechercherVendeursProduit(produit) != null;
	}

	public String[] rechercherVendeursProduit(String produit) {
		Gaulois[] vendeurs = village.rechercherVendeursProduit(produit);
		if (vendeurs == null)
			return null;
		String[] nomsVendeurs = new String[vendeurs.length];
		for (int i = 0; i < vendeurs.length; i++) {
			nomsVendeurs[i] = vendeurs[i].getNom();
		}
		return nomsVendeurs;
	}
}
