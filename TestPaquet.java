import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;


/**
 * classe de test qui permet de verifier que la classe Paquet
 * fonctionne correctement
 */
public class TestPaquet {

	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestPaquet(), args);
	}

	/**
	 * test du constructeur vide
	 */
	@Test
	public void test1_constructeur() {
		Paquet paquet = new Paquet();
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

		Paquet paquet = new Paquet(tab);
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

		Paquet paquet = new Paquet(tab);
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

		Paquet paquet = new Paquet(tab);
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
		Paquet paquet = new Paquet(tab);
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

		Paquet paquet = new Paquet(tab);
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
		Paquet paquet = new Paquet(tab);
		assertEquals("paquet devrait avoir 6 cartes", 6, paquet.getNbCartes());
	}

	/**
	 * test nbCartes 0
	 */
	@Test
	public void test8_getNbCartes_0() {
		int[] tab = new int[0];
		Paquet paquet = new Paquet(tab);
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
		Paquet paquet = new Paquet(tab);
		assertEquals("valeur de la derniere carte devrait etre 5", 5, paquet.getDerniereCarte().getValeur());
	}

	/**
	 * test getDerniereCarte vide
	 */
	@Test
	public void test10_getDerniereCarte_Vide() {
		Carte[] tab = new Carte[0];
		Paquet paquet = new Paquet(tab);
		assertEquals("la derniere carte devrait etre null", null, paquet.getDerniereCarte());
	}

	/**
	 * test estVide vrai
	 */
	@Test
	public void test11_estVide_Vrai() {
		int[] tab = new int[0];
		Paquet paquet = new Paquet(tab);
		assertEquals("paquet devrait être vide", true, paquet.estVide());
	}

	/**
	 * test estVide vrai
	 */
	@Test
	public void test12_estVide_Faux() {
		int[] tab = new int[2];
		tab[0] = 1;
		tab[1]  =2;
		Paquet paquet = new Paquet(tab);
		assertEquals("paquet ne devrait pas être vide", false, paquet.estVide());
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

		Paquet paquet = new Paquet(tab);
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

		Paquet paquet = new Paquet(tab);
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

		Paquet paquet = new Paquet(tab);
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

			Paquet paquet = new Paquet(tab);
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

			Paquet paquet = new Paquet(tab);
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

			Paquet paquet = new Paquet(tab);
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

			Paquet paquet = new Paquet(tab);
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

			Paquet paquet = new Paquet(tab);
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

			Paquet paquet = new Paquet(tab);
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
			Paquet paquet = new Paquet();
			paquet.remplir(5);

			// test paquet
			assertEquals("paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());

			// test cartes
			for (int i=0; i<3; i++){
				assertEquals("carte "+i+" devrait etre egale a "+(i+2), i+2, paquet.getCarte(i).getValeur());
			}
		}

}
