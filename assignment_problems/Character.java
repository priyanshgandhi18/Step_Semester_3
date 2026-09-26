public class Character {
    private final int maxHealth;
    private int health;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount > 0) {
            this.health = Math.max(0, this.health - amount);
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            this.health = Math.min(this.maxHealth, this.health + amount);
        }
    }

    public int getHealth() {
        return this.health;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }
}