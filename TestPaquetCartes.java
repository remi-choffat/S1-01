import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;


/**
 * classe de test qui permet de verifier que la classe PaquetCartes
 * fonctionne correctement
 */
public class TestPaquetCartes {

	/**
	 * test des methodes
	 */
	public void test0_verifieMethodes() {
			// Question 4.1
			Carte[] tabC = {new Carte(10), new Carte(20)};
			PaquetCartes paq = new PaquetCartes(tabC);
			paq.ajouterCarteFin(new Carte(25));
			paq.retirerCarte(0);

			// Question 4.2
			PaquetCartes paq2 = new PaquetCartes();

			// Question 4.3
			paq2.remplir(20);

			// Question 4.4
			int tabInt[] = {10,20,30,40,50};
			PaquetCartes paq3 = new PaquetCartes(tabInt);

			// Question 4.5
			Carte c = paq.getCarte(0);
			Carte c2 = paq.getDerniereCarte();
			int nb = paq.getNbCartes();
			boolean vide = paq.etreVide();

			// question 4.7
			paq.melangerPaquet();

			// question  4.8
			paq.insererTri(new Carte(23));

			// question  4.9
			Carte c3 = paq.prendreCarteDessus();

	}


	/**
	 * methode de lancement des tests
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestPaquetCartes(), args);
	}


	/**
	 * test du constructeur vide
	 */
	@Test
	public void test1_constructeur() {
		PaquetCartes paquet = new PaquetCartes();
		assertEquals("paquet devrait avoir 0 carte", 0, paquet.getNbCartes());
	}


	/**
	 * test du constructeur parametres
	 */
	@Test
	public void test2_constructeurParam() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(1);
		tab[1] = new Carte(2);
		tab[2] = new Carte(3);

		PaquetCartes paquet = new PaquetCartes(tab);
		assertEquals("paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());
	}


	/**
	 * test du constructeur avec tableau d'entiers
	 */
	@Test
	public void test3_constructeurParam_Entiers() {
		int[] tab = new int[4];
		for (int i=0; i<4; i++){
			tab[i] = i;
		}

		PaquetCartes paquet = new PaquetCartes(tab);
		assertEquals("paquet devrait avoir 4 cartes", 4, paquet.getNbCartes());
	}


  /**
	 * test getCarte
	 */
	@Test
	public void test4_getCarte_ok() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(1);
		tab[1] = new Carte(2);
		tab[2] = new Carte(3);

		PaquetCartes paquet = new PaquetCartes(tab);
		assertEquals("paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());
		Carte c = paquet.getCarte(1);
		assertEquals("la carte 1 a pour valeur 2", 2, c.getValeur());
	}


	/**
	 * test getCarte paquet vide
	 */
	@Test
	public void test5_getCarte_vide() {
		Carte[] tab = new Carte[0];
		PaquetCartes paquet = new PaquetCartes(tab);
		assertEquals("paquet devrait avoir 0 carte", 0, paquet.getNbCartes());
		assertEquals("la carte 0 est null", null, paquet.getCarte(0));
	}


	/**
	 * test getCarte hors tableau
	 */
	@Test
	public void test6_getCarte_horsTableau() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(1);
		tab[1] = new Carte(2);
		tab[2] = new Carte(3);

		PaquetCartes paquet = new PaquetCartes(tab);
		assertEquals("paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());

                Carte c = paquet.getCarte(3);
		assertEquals("la carte 3 n'existe pas", null, c);
	}


	/**
	 * test nbCartes
	 */
	@Test
	public void test7_getNbCartes() {
		int[] tab = new int[6];
		for (int i=0; i<6; i++){
			tab[i] = i;
		}
		PaquetCartes paquet = new PaquetCartes(tab);
		assertEquals("paquet devrait avoir 6 cartes", 6, paquet.getNbCartes());
	}


	/**
	 * test nbCartes 0
	 */
	@Test
	public void test8_getNbCartes_0() {
		int[] tab = new int[0];
		PaquetCartes paquet = new PaquetCartes(tab);
		assertEquals("paquet devrait avoir 0 carte", 0, paquet.getNbCartes());
	}


	/**
	 * test getDerniereCarte
	 */
	@Test
	public void test9_getDerniereCarte() {
		int[] tab = new int[6];
		for (int i=0; i<6; i++){
			tab[i] = i;
		}
		PaquetCartes paquet = new PaquetCartes(tab);
		assertEquals("valeur de la derniere carte devrait etre 5", 5, paquet.getDerniereCarte().getValeur());
	}


	/**
	 * test getDerniereCarte vide
	 */
	@Test
	public void test10_getDerniereCarte_Vide() {
		Carte[] tab = new Carte[0];
		PaquetCartes paquet = new PaquetCartes(tab);
		assertEquals("la derniere carte devrait etre null", null, paquet.getDerniereCarte());
	}


	/**
	 * test etreVide vrai
	 */
	@Test
	public void test11_etreVide_Vrai() {
		int[] tab = new int[0];
		PaquetCartes paquet = new PaquetCartes(tab);
		assertEquals("paquet devrait être vide", true, paquet.etreVide());
	}


	/**
	 * test etreVide vrai
	 */
	@Test
	public void test12_etreVide_Faux() {
		int[] tab = new int[2];
		tab[0] = 1;
		tab[1]  =2;
		PaquetCartes paquet = new PaquetCartes(tab);
		assertEquals("paquet ne devrait pas être vide", false, paquet.etreVide());
	}


	/**
	 * test ajoutCarteDebut ok
	 */
	@Test
	public void test13_ajoutCarteDebut() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(1);
		tab[1] = new Carte(2);
		tab[2] = new Carte(3);

		PaquetCartes paquet = new PaquetCartes(tab);
		paquet.ajouterCarteDebut(new Carte(0));

		assertEquals("paquet devrait avoir 4 cartes", 4, paquet.getNbCartes());

			// chaque carte doit etre bien placee: place i => valeur i+1
			for (int i=0;i<3;i++) {
				Carte c = paquet.getCarte(i);
				assertEquals("la carte "+i+" a pour valeur "+i, i, c.getValeur());
		}

	}


	/**
	 * test ajoutCarteFin ok
	 */
	@Test
	public void test14_ajoutCarteFin() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(1);
		tab[1] = new Carte(2);
		tab[2] = new Carte(3);

		PaquetCartes paquet = new PaquetCartes(tab);
		paquet.ajouterCarteFin(new Carte(4));

		assertEquals("paquet devrait avoir 4 cartes", 4, paquet.getNbCartes());

								// chaque carte doit etre bien placee: place i => valeur i+1
								for (int i=0;i<3;i++) {
			Carte c = paquet.getCarte(i);
			assertEquals("la carte "+i+"a pour valeur"+(i+1), i+1, c.getValeur());
		}
	}


	/**
	 * test ajoutCarte ok
	 */
	@Test
	public void test15_ajoutCarte() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(1);
		tab[1] = new Carte(3);
		tab[2] = new Carte(4);

		PaquetCartes paquet = new PaquetCartes(tab);
		paquet.ajouterCarte(new Carte(2), 0);

		assertEquals("paquet devrait avoir 4 cartes", 4, paquet.getNbCartes());

								// chaque carte doit etre bien placee: place i => valeur i+1
								for (int i=0;i<3;i++) {
			Carte c = paquet.getCarte(i);
			assertEquals("la carte "+i+" a pour valeur "+(i+1), i+1, c.getValeur());
		}

	}


		/**
		 * test ajoutCarte place hors tableau inf
		 */
		@Test
		public void test16_ajoutCarte_hors_tableau_inf() {
			Carte[] tab = new Carte[3];
			tab[0] = new Carte(2);
			tab[1] = new Carte(3);
			tab[2] = new Carte(4);

			PaquetCartes paquet = new PaquetCartes(tab);
			paquet.ajouterCarte(new Carte(1), -1);

			assertEquals("paquet devrait avoir 4 cartes", 4, paquet.getNbCartes());

									// chaque carte doit etre bien placee: place i => valeur i+1
									for (int i=0;i<3;i++) {
				Carte c = paquet.getCarte(i);
				assertEquals("la carte "+i+" a pour valeur "+(i+1), i+1, c.getValeur());
			}

		}


		/**
		 * test ajoutCarte place hors tableau sup
		 */
		@Test
		public void test17_ajoutCarte_hors_tableau_sup() {
			Carte[] tab = new Carte[3];
			tab[0] = new Carte(1);
			tab[1] = new Carte(2);
			tab[2] = new Carte(3);

			PaquetCartes paquet = new PaquetCartes(tab);
			paquet.ajouterCarte(new Carte(4), 8);

			assertEquals("paquet devrait avoir 4 cartes", 4, paquet.getNbCartes());

									// chaque carte doit etre bien placee: place i => valeur i+1
									for (int i=0;i<3;i++) {
				Carte c = paquet.getCarte(i);
				assertEquals("la carte "+i+" a pour valeur "+(i+1), i+1, c.getValeur());
			}

		}


		/**
		 * test retirerCarte ok
		 */
		@Test
		public void test18_retirerCarte() {
			Carte[] tab = new Carte[3];
			tab[0] = new Carte(1);
			tab[1] = new Carte(2);
			tab[2] = new Carte(3);

			PaquetCartes paquet = new PaquetCartes(tab);
			Carte c = paquet.retirerCarte(1);

			// test paquet
			assertEquals("paquet devrait avoir 2 cartes", 2, paquet.getNbCartes());
			assertEquals("premiere carte valeur 1", 1, paquet.getCarte(0).getValeur());
			assertEquals("seconde carte valeur 3", 3, paquet.getCarte(1).getValeur());

			// test carte retournee
			assertEquals("carte retiree a pour valeur 2", 2, c.getValeur());

		}


		/**
		 * test retirerCarte premiere carte
		 */
		@Test
		public void test19_retirerCarte_premiere() {
			Carte[] tab = new Carte[3];
			tab[0] = new Carte(1);
			tab[1] = new Carte(2);
			tab[2] = new Carte(3);

			PaquetCartes paquet = new PaquetCartes(tab);
			Carte c = paquet.retirerCarte(0);

			// test paquet
			assertEquals("paquet devrait avoir 2 cartes", 2, paquet.getNbCartes());
			assertEquals("premiere carte valeur 2", 2, paquet.getCarte(0).getValeur());
			assertEquals("seconde carte valeur 3", 3, paquet.getCarte(1).getValeur());

			// test carte retournee
			assertEquals("carte retiree a pour valeur 1", 1, c.getValeur());

		}


		/**
		 * test retirerCarte derniere carte
		 */
		@Test
		public void test20_retirerCarte_derniere() {
			Carte[] tab = new Carte[3];
			tab[0] = new Carte(1);
			tab[1] = new Carte(2);
			tab[2] = new Carte(3);

			PaquetCartes paquet = new PaquetCartes(tab);
			Carte c = paquet.retirerCarte(2);

			// test paquet
			assertEquals("paquet devrait avoir 2 cartes", 2, paquet.getNbCartes());
			assertEquals("premiere carte valeur 1", 1, paquet.getCarte(0).getValeur());
			assertEquals("seconde carte valeur 2", 2, paquet.getCarte(1).getValeur());

			// test carte retournee
			assertEquals("carte retiree a pour valeur 3", 3, c.getValeur());

		}


		/**
		 * test retirerCarte carte inexistante
		 */
		@Test
		public void test21_retirerCarte_inexistante() {
			Carte[] tab = new Carte[3];
			tab[0] = new Carte(1);
			tab[1] = new Carte(2);
			tab[2] = new Carte(3);

			PaquetCartes paquet = new PaquetCartes(tab);
			Carte c = paquet.retirerCarte(3);

			// test paquet
			assertEquals("paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());

			// test carte retournee
			assertEquals("carte retiree est null", null, c);

		}


		/**
		 * test remplir
		 */
		@Test
		public void test22_remplir() {
			PaquetCartes paquet = new PaquetCartes();
			paquet.remplir(5);

			// test paquet
			assertEquals("paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());

			// test cartes
			for (int i=0; i<3; i++){
				assertEquals("carte "+i+" devrait etre egale a "+(i+2), i+2, paquet.getCarte(i).getValeur());
			}
		}


		/**
		 * test mélanger
		 */
		@Test
		public void test23_melangerPaquet() {
			PaquetCartes paquet1 = new PaquetCartes();
			paquet1.remplir(10);
			PaquetCartes paquet2 = new PaquetCartes();
			paquet2.remplir(10);
			paquet2.melangerPaquet();
			boolean egal = true;
			for (int i=0; i<8; i++){
				if (paquet1.getCarte(i) != paquet2.getCarte(i)) egal = false;
			}
			assertEquals("les deux paquets sont identiques", false, egal);
		}


		/**
		 * test insererTri tableau vide
		 */
		@Test
		public void test24_insererTri_vide() {
			PaquetCartes tab = new PaquetCartes();
			tab.insererTri(new Carte(2));
			assertEquals("le paquet devrait avoir 1 cartes", 1, tab.getNbCartes());
			assertEquals("la carte 0 a pour valeur 2", 2, tab.getCarte(0).getValeur());
		}


		/**
		 * test insererTri tableau non vide
		 */
		@Test
		public void test25_insererTri() {
			Carte[] tab = new Carte[3];
			tab[0] = new Carte(0);
			tab[1] = new Carte(1);
			tab[2] = new Carte(3);
			PaquetCartes paquet = new PaquetCartes(tab);
			paquet.insererTri(new Carte(2));
			assertEquals("le paquet devrait avoir 4 cartes", 4, paquet.getNbCartes());
			for (int i=0; i<3; i++){
				Carte c = paquet.getCarte(i);
				assertEquals("la carte "+i+" a pour valeur "+i, i, c.getValeur());
			}
		}


		/**
		 * test prendreCarteDessus tableau non vide
		 */
		@Test
		public void test26_prendreCarteDessus() {
			Carte[] tab = new Carte[3];
			tab[0] = new Carte(0);
			tab[1] = new Carte(1);
			tab[2] = new Carte(2);
			PaquetCartes paquet = new PaquetCartes(tab);
			Carte c = paquet.prendreCarteDessus();
			assertEquals("le paquet devrait avoir 2 cartes", 2, paquet.getNbCartes());
			assertEquals("la carte retiree a pour valeur 0", 0, c.getValeur());
		}


		/**
		 * test prendreCarteDessus tableau vide
		 */
		@Test
		public void test27_prendreCarteDessus_vide() {
			PaquetCartes paquet = new PaquetCartes();
			Carte c = paquet.prendreCarteDessus();
			assertEquals("le paquet devrait avoir 0 carte", 0, paquet.getNbCartes());
			assertEquals("la methode doit renvoyer null", null, c);
		}


		/**
		 * test toString
		 */
		@Test
		public void test28_toString() {
			Carte[] tab = new Carte[4];
			tab[0] = new Carte(2);
			tab[1] = new Carte(8);
			tab[2] = new Carte(24);
			tab[3] = new Carte(36);
			PaquetCartes paquet = new PaquetCartes(tab);
			assertEquals("l'affichage est incorrect", "0-c2 1-c8 2-c24 3-c36 ", paquet.toString());
		}

}
