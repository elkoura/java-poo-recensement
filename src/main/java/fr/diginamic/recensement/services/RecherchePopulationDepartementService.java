package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;

/**
 * Recherche et affichage de toutes les villes d'un département dont la
 * population est comprise entre une valeur min et une valeur max renseignées
 * par l'utilisateur.
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationDepartementService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) {
	    System.out.println("Quel est le code du département recherché ? ");
	    String choix = scanner.nextLine();

	    System.out.println("Choississez une population minimum (en milliers d'habitants): ");
	    String saisieMin = scanner.nextLine();
	    System.out.println("Choississez une population maximum (en milliers d'habitants): ");
	    String saisieMax = scanner.nextLine();

	    try {
	        if (!NumberUtils.isCreatable(saisieMin) || !NumberUtils.isCreatable(saisieMax)) {
	            throw new IllegalArgumentException("Les valeurs de population doivent être des nombres valides.");
	        }

	        int min = Integer.parseInt(saisieMin) * 1000;
	        int max = Integer.parseInt(saisieMax) * 1000;

	        if (min < 0 || max < 0) {
	            throw new IllegalArgumentException("Les valeurs de population ne peuvent pas être négatives.");
	        }
	        if (min > max) {
	            throw new IllegalArgumentException("La population minimum ne peut pas être supérieure à la population maximum.");
	        }

	        List<Ville> villes = rec.getVilles();
	        boolean departementExiste = false;
	        for (Ville ville : villes) {
	            if (ville.getCodeDepartement().equalsIgnoreCase(choix)) {
	                departementExiste = true;
	                if (ville.getPopulation() >= min && ville.getPopulation() <= max) {
	                    System.out.println(ville);
	                }
	            }
	        }
	        if (!departementExiste) {
	            throw new IllegalArgumentException("Le code de département saisi est inconnu.");
	        }
	    } catch (IllegalArgumentException e) {
	        System.err.println("Erreur: " + e.getMessage());
	        throw e; // Rethrow pour une éventuelle gestion supplémentaire dans Application.java
	    }
	}
	}


