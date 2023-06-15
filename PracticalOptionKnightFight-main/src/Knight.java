public class Knight extends MOB {
    private Fortune activeFortune;
    protected final int id;
    protected int xp;

    Knight(int id, String name, int hp, int armor, int hitmodifier, DiceType damageDie, int xp){
        super(name, hp, armor, hitmodifier, damageDie);
        this.id = id;
        this.xp = xp;
    }
    
    public int getArmor(){
        if(activeFortune == null){
            return super.getArmor();
        }
        return super.getArmor() + activeFortune.getArmor();
    }

    public int getMaxHP(){
        if(activeFortune == null){
            return super.getMaxHP();
        }
        return super.getMaxHP() + activeFortune.getMaxHP();
    }

    public DiceType getDamageDie(){
        if(activeFortune == null){
            return super.getDamageDie();
        }
        return activeFortune.getDamageDie();
    }

    public int getHitModifier(){
        if(activeFortune == null){
            return super.getHitModifier();
        }
        return super.getHitModifier() + activeFortune.getHitModifier();
    }

    public int getXP(){
        return xp;
    }

    public Fortune getActiveFortune(){
        return activeFortune;
    }

    public void setActiveFortune(Fortune activeFortune){
        this.activeFortune = activeFortune;
    }

    public void addXP(int xp){
        this.xp += xp;
    }

    public Integer getId(){
        return Integer.valueOf(id);
    }

    public String toString(){
        return "+============================+\n" +
        String.format("| %-27s|%n", getName()) +
        String.format("| id: %-23d|%n", getId()) + 
        "|                            |\n" +
        String.format("|  Health: %-6d XP: %-7d|%n", getHP(), getXP())  +
        String.format("|  Power: %-6s  Armor: %-4d|%n", getDamageDie(), getArmor()) +
        "|                            |\n" +
        "+============================+";
    }

    public String toCSV(){
       return (getName() + "," + getMaxHP() + "," + getArmor() + "," + getHitModifier() + "," + 
       getDamageDie()+ "," + getXP());

    }
    public static void main(String[] args) {
        
    }
    
}
