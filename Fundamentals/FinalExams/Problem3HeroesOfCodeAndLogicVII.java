package FinalExams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem3HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> heroHealth = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> heroMana = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        String input;
        String[] info;
        int currentMana;
        int currentHealth;

        for (int i = 0; i < n; i++) {
            input = scanner.nextLine();
            info = input.split(" ");
            String hero = info[0];
            int health = Math.min(Integer.parseInt(info[1]), 100);
            int mana = Math.min(Integer.parseInt(info[2]), 200);

            heroHealth.put(hero, health);
            heroMana.put(hero, mana);
        }

        while (!"End".equals(input = scanner.nextLine())) {
            info = input.split(" - ");
            String command = info[0];
            String heroName = info[1];

            switch (command) {

                case "CastSpell":
                    int neededMana = Integer.parseInt(info[2]);
                    String spell = info[3];
                    currentMana = heroMana.get(heroName);

                    if (currentMana - neededMana < 0) {
                        System.out.printf("%s does not have enough MP to cast %s!\n", heroName, spell);
                    } else {
                        heroMana.put(heroName, currentMana - neededMana);
                        System.out.printf("%s has successfully cast %s and now has %d MP!\n",
                                heroName, spell, currentMana - neededMana);
                    }
                    break;

                case "TakeDamage":
                    int damage = Integer.parseInt(info[2]);
                    String attacker = info[3];
                    currentHealth = heroHealth.get(heroName);

                    if (currentHealth - damage <= 0) {
                        heroHealth.remove(heroName);
                        heroMana.remove(heroName);
                        System.out.printf("%s has been killed by %s!\n", heroName, attacker);
                    } else {
                        heroHealth.put(heroName, currentHealth - damage);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!\n",
                                heroName, damage, attacker, currentHealth - damage);
                    }
                    break;

                case "Recharge":
                    int gainMana = Integer.parseInt(info[2]);
                    currentMana = heroMana.get(heroName);

                    heroMana.put(heroName, Math.min(200, currentMana + gainMana));
                    System.out.printf("%s recharged for %d MP!\n", heroName, heroMana.get(heroName) - currentMana);
                    break;

                case "Heal":
                    int heal = Integer.parseInt(info[2]);
                    currentHealth = heroHealth.get(heroName);

                    heroHealth.put(heroName, Math.min(100, currentHealth + heal));
                    System.out.printf("%s healed for %d HP!\n", heroName, heroHealth.get(heroName) - currentHealth);
                    break;
            }
        }
        for (Map.Entry<String, Integer> heroStats : heroHealth.entrySet()) {
            String hero = heroStats.getKey();
            int health = heroStats.getValue();
            int mana = heroMana.get(hero);

            System.out.println(hero + "\n  " + "HP: " + health + "\n  " + "MP: " + mana);
        }
    }
}
