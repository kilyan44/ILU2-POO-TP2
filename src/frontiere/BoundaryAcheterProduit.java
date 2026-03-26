package frontiere;

import controleur.ControlAcheterProduit;
import controleur.ControlAfficherMarche;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (controlAcheterProduit.verifierIdentiteAcheteur(nomAcheteur)) {
			String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?\n");
			if (!controlAcheterProduit.rechercherProduit(produit)) {
				System.out.println("Désolé, personne ne vend se produit au marché.\n");
			} else {
				String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
				int indiceVendeur = Clavier
						.entrerEntier("Chez quel commerçant voulez-vous acheter des " + produit + "\n" + infosMarche);
				String nomVendeur = infosMarche[indiceVendeur];
				System.out.println("Panoramix se déplace jusqu'à l'étal du vendeur " + nomVendeur);
				acheter(produit, nomVendeur, nomAcheteur);
			}
		} else {
			System.out.println("Je suis désolée " + nomAcheteur
					+ " mais il faut être un habitant de notre village pour commercer ici.\n");
		}
	}

	private void acheter(String produit, String nomVendeur, String nomAcheteur) {
		int nbProduit = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?\n");
		System.out.println(nomAcheteur + " achète " + nbProduit + "" + produit + "à" + nomVendeur);
		controlAcheterProduit.acheterProduit(nomVendeur, nbProduit);
	}

	private void validerQuantite(String nomVendeur, String nomAcheteur, int quantiteAcheter) {
		
	}
}
