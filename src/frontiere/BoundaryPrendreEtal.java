package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Bonjour " + nomVendeur + "je vais regarder si je peux trouver un étal.\n");
			if (!controlPrendreEtal.resteEtals()) {
				System.out
						.println("Je suis désolée " + nomVendeur + " je n'ai plus d'étal qui ne soit pas déjâ occupé");
			} else {
				installerVendeur(nomVendeur);
			}
		} else {
			System.out.println("Je suis désolée " + nomVendeur
					+ " mais il faut être un habitant de notre village pour vendre ici.");
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder infoVendeur = new StringBuilder();
		infoVendeur.append("C'est parfait il me reste un étal pour vous ! \n");
		infoVendeur.append("Il me faudrait quelques renseignements : \n");
		infoVendeur.append("Quelle produit souhaitez-vous vendre ?");
		String produit = Clavier.entrerChaine(infoVendeur.toString());
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur +  " s'est installé à l'étal n°" + numeroEtal);
		}
	}
}
