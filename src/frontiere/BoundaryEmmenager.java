package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println("Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder druide = new StringBuilder();
		druide.append("Bienvenue druide ");
		druide.append(nomVisiteur);
		druide.append("\n Quelle est votre force ? \n");
		int forceDruide = Clavier.entrerEntier(druide.toString());
		int effetPotionMinDruide = Clavier.entrerEntier("Quelle est la force de potion la plus faible que vous produisez ?");
		int effetPotionMaxDruide = Clavier.entrerEntier("Quelle est la force de potion la plus forte que vous produisez ?");
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide,effetPotionMinDruide,effetPotionMaxDruide);
		System.out.println("Le druide " + nomVisiteur + " a emménagé dans le village !");
	}
	
	private void emmenagerGaulois(String nomVisiteur) {
		StringBuilder gaulois = new StringBuilder();
		gaulois.append("Bienvenue villageois ");
		gaulois.append(nomVisiteur);
		gaulois.append("\n Quelle est votre force ? \n");
		int forceGaulois = Clavier.entrerEntier(gaulois.toString());
		controlEmmenager.ajouterGaulois(nomVisiteur, forceGaulois);
		System.out.println("Le gaulois " + nomVisiteur + " a emménagé dans le village");
	}
}
