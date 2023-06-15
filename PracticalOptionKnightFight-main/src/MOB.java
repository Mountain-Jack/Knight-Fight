public class MOB implements Attributes {
    protected int armor;
    protected int damage;
    protected DiceType damageDie;
    protected int hitModifier;
    protected int maxHP;
    private final String name;

    MOB(String name, int hp, int armor, int hitModifier, DiceType damageDie){
        this.armor = armor;
        this.damageDie = damageDie;
        this.hitModifier = hitModifier;
        this.maxHP = hp;
        this.name = name;
    }

    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public int getMaxHP() {
        return maxHP;
    }

    @Override
    public DiceType getDamageDie() {
        return damageDie;
    }

    @Override
    public int getHitModifier() {
        return hitModifier;
    }
    
    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public void resetDamage(){
        damage = 0;
    }

    public void addDamage(int damage){
        this.damage += damage;
    }
    public int getHP(){
        return maxHP - damage;
    }

    public String toString(){
        return "+============================+\n" +
        String.format("| %-27s|%n", getName()) +
        "|                            |\n" +
        String.format("|         Health: %-10d |%n", getHP())  +
        String.format("|  Power: %-6s  Armor: %-4d|%n", getDamageDie().toString(), getArmor()) +
        "|                            |\n" +
        "+============================+";
    }

    public MOB copy(){
        MOB copy = new MOB(name, maxHP, armor, hitModifier, damageDie);
        return copy;
    }
    public static void main(String[] args) {
    

    }
}
