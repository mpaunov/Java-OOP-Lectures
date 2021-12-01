package desingPatterns;

import desingPatterns.template.LocalStorePurchase;
import desingPatterns.template.OnlinePurchase;
import desingPatterns.template.TemplatePurchase;
import unitTesting.rpg_lab.Axe;
import unitTesting.rpg_lab.Hero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Hero> heroes = new ArrayList<>();

        heroes.add(new Hero("Azgor", new Axe(10, 100)));
        heroes.add(new Hero("Gimli", new Axe(1000, 100)));
        heroes.add(new Hero("Gandalf", new Axe(50, 100)));

        Collections.sort(heroes);

        heroes.forEach(h -> System.out.println(h.getName()));

        System.out.println();

        Collections.sort(heroes, Comparator.comparingInt(f -> f.getWeapon().getAttackPoints()));

        heroes.forEach(h -> System.out.println(h.getName()));

        System.out.println();

        TemplatePurchase purchase1 = new OnlinePurchase();
        TemplatePurchase purchase2 = new LocalStorePurchase();

        purchase1.purchaseOrder();

        System.out.println();

        purchase2.purchaseOrder();
    }
}
