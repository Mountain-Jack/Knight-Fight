import java.util.Random;

public class CombatEngine{
    private final GameData data;
    private final DiceSet  dice = new DiceSet();
    private final Random rnd = new Random();
    private final GameView view;

    CombatEngine(GameData data, GameView view){
        this.data = data;
        this.view = view;
    }
    public void initialize(){
        for(Knight knight : data.getActiveKnights()){
            knight.setActiveFortune(data.getRandomFortune());
        }   
    }
    public void runCombat(){
        System.out.println("fight just happened, all your knights died\n\n\n\n\n\n\n\njk");
    }
    public void clear(){
        for(Knight knight : data.getKnights()){
            knight.setActiveFortune(null);
        }
    }
}