public class Fortune implements Attributes {
    private int armor;
    private DiceType dtype;
    private int hitModifier;
    private int hpBonus;
    private String name;

    public Fortune(String name, int hpBonus, int armor, int hitModifier) {
        this(name, hpBonus, armor, hitModifier, null);
    }

    public Fortune(String name, int hpBonus, int armor, int hitModifier, DiceType type) {
        this.armor = armor;
        this.dtype = type;
        this.hitModifier = hitModifier;
        this.hpBonus = hpBonus;
        this.name = name;
    }
    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public int getMaxHP() {
        return hpBonus;
    }

    @Override
    public DiceType getDamageDie() {
        return dtype;
    }

    @Override
    public int getHitModifier() {
        return hitModifier;
    }

    public String getName(){
        return name;
    }
    
    public String toString(){
        String formattedString = "";
        
        formattedString += "+======================+\n";
        formattedString += String.format("|%-22s|\n", getName());
        formattedString += String.format("|HP Bonus:%13s|\n", ("+" + getMaxHP()));
        formattedString += String.format("|AC Bonus:%13s|\n", ("+" + getArmor()));
        formattedString += String.format("|Hit Bonus:%12s|\n", ("+" + getHitModifier()));
        formattedString += String.format("|Damage Adj:%11s|\n", ((getDamageDie() == null) ? "-" : getDamageDie()));
        formattedString += "+======================+\n";
        return formattedString; 

    }
    public static void main(String[] args) {
        
    }
    
}
