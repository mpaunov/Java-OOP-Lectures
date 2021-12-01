package unitTesting.rpg_lab;

public class Hero implements Comparable<Hero> {

    private String name;
    private int experience;
    private Weapon weapon;

    public Hero(String name, Weapon weapon) {
        this.name = name;
        this.experience = 0;
        this.weapon = weapon;
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void attack(Target target) {
        this.weapon.attack(target);

        if (target.isDead()) {
            this.experience += target.giveExperience();
        }
    }

    // Package private so it can be called in tests
    void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public int compareTo(Hero other) {
        return Integer.compare(other.weapon.getAttackPoints(), this.weapon.getAttackPoints());
    }
}
