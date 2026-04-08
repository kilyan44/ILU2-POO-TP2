package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentiteAcheteur(nomAcheteur)) {
			System.out.println("Je suis désolée " + nomAcheteur
					+ " mais il faut être un habitant de notre village pour commercer ici.");
			return;
		}
		String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
		String[] vendeurs = controlAcheterProduit.rechercherVendeursProduit(produit);
		if (vendeurs == null) {
			System.out.println("Désolé, personne ne vend ce produit au marché.");
			return;
		}
		String nomVendeur = choisirVendeur(produit, vendeurs);
		System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomVendeur);
		acheter(produit, nomVendeur, nomAcheteur);
	}

	public String choisirVendeur(String produit, String[] vendeurs) {
		StringBuilder liste = new StringBuilder();
		liste.append("Chez quel commerçant voulez-vous acheter des ");
		liste.append(produit).append(" ?\n");
		for (int i = 0; i < vendeurs.length; i++) {
			liste.append(i + 1).append(" - ").append(vendeurs[i]).append("\n");
		}
		int choix = Clavier.entrerEntier(liste.toString());
		return vendeurs[choix - 1];
	}

	public void acheter(String produit, String nomVendeur, String nomAcheteur) {
		System.out.println("Bonjour " + nomAcheteur);
		int quantiteDemandee = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");
		int quantiteVendue = controlAcheterProduit.acheterProduit(nomVendeur, quantiteDemandee);
		afficherResultatAchat(nomAcheteur, nomVendeur, produit, quantiteDemandee, quantiteVendue);
	}

	public void afficherResultatAchat(String nomAcheteur, String nomVendeur, String produit, int quantiteDemandee,
			int quantiteVendue) {
		if (quantiteVendue == 0) {
			System.out.println(nomAcheteur + " veut acheter " + quantiteDemandee + " " + produit
					+ ", malheureusement il n'y en a plus !");
		} else if (quantiteVendue < quantiteDemandee) {
			System.out.println(nomAcheteur + " veut acheter " + quantiteDemandee + " " + produit + ", malheureusement "
					+ nomVendeur + " n'en a plus que " + quantiteVendue + ". " + nomAcheteur
					+ " achète tout le stock de " + nomVendeur + ".");
		} else {
			System.out.println(nomAcheteur + " achète " + quantiteVendue + " " + produit + " à " + nomVendeur);
		}
	}
}