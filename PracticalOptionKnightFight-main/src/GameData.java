import java.util.LinkedList;
import java.util.List;
import java.util.Random;
public abstract class GameData{
    private static final int MAX_ACTIVE = 4;
    protected final List<Knight> activeKnights = new LinkedList<>();
    protected final List<Fortune> fortunes = new LinkedList<>();
    protected final List<Knight> knights = new LinkedList<>();
    protected final List<MOB> monsters = new LinkedList<>();
    private static final Random random = new Random(); 
    public GameData(){

    }
    public List<Knight> getKnights(){
        return knights;
    }
    public List<Knight> getActiveKnights(){
        return activeKnights;
    }
    public Knight getActive(String nameOrId){
        for(Knight knight: activeKnights){
            if(knight.getName().contains(nameOrId)){
                return knight;
            }
            if(knight.getId().toString().equals(nameOrId)){
                return knight;
            }
        }
        return null;
    }
    public Knight getKnight(String nameOrId){
        for(Knight knight: knights){
            if(knight.getName().toLowerCase().contains(nameOrId)){
                return knight;
            }
            if(knight.getId().toString().equals(nameOrId)){
                return knight;
            }
        }
        return null;
    }
    protected Knight findKnight(String nameOrId, List<Knight> list){
        for(Knight knight: list){
            if(knight.getName().toLowerCase().contains(nameOrId)){
                return knight;
            }
            if(knight.getId().toString().equals(nameOrId)){
                return knight;
            }
        }
        return null;
    }
    public boolean setActive(Knight kt){
        if(activeKnights.size() <= 4){
            activeKnights.add(kt);
            return true;
        }
        return false;
    }
    public void removeActive(Knight kt){
        kt.resetDamage();
        activeKnights.remove(activeKnights.indexOf(kt));
    }
    public Fortune getRandomFortune(){
        return fortunes.get(random.nextInt(fortunes.size()));
    }
    public List<MOB> getRandomMonsters(){
        List<MOB> list = new LinkedList<MOB>();
        for(int i = 0; i < activeKnights.size(); i++){
            MOB monster = monsters.get(random.nextInt(monsters.size()));
            list.add(monster);
            }
        return list;
    }
    public List<MOB> getRandomMonsters(int number){
        List<MOB> list = new LinkedList<MOB>();
        for(int i = 0; i < number; i++){
            MOB monster = monsters.get(random.nextInt(monsters.size()));
            list.add(monster);
            }
        return list;
    }
    public abstract void save(String filename);
}
