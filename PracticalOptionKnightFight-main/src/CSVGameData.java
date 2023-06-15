import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;

public class CSVGameData extends GameData{

    CSVGameData(String gamedata, String saveData){
        loadGameData(gamedata);
        loadSaveData(saveData);
    }
    void loadSaveData(String saveData){
        int counter = 0;
        Scanner file = readFile(saveData);
        if(file == null) return;
        while(file.hasNextLine()) {
            Scanner line = new Scanner(file.nextLine());
            line.useDelimiter(","); 
            Knight kt = new Knight(
                    ++counter,
                    line.next().trim(),
                    line.nextInt(),
                    line.nextInt(),
                    line.nextInt(),
                    DiceType.valueOf(line.next()),
                    line.nextInt());
            knights.add(kt);
        }
    }
    private Scanner readFile(String fileName){
        try {
            Scanner scanner = new Scanner(new File(fileName));
            return scanner;
        } catch (Exception e) {
            return null;
        }
    }
    void loadGameData(String gamedata){
        Scanner file = readFile(gamedata);
        if(file == null) return;
        while(file.hasNextLine()) {
            Scanner line = new Scanner(file.nextLine());
            line.useDelimiter(","); 
            if(line.next().trim().equals("MOB")){
                MOB mob = new MOB(
                    line.next().trim(),
                    line.nextInt(),
                    line.nextInt(),
                    line.nextInt(),
                    DiceType.valueOf(line.next())   
                );
                monsters.add(mob);
            }else{
                String fort_name = line.next().trim();
                int fort_hpBonus = line.nextInt();
                int fort_armor = line.nextInt();
                int fort_hitModifier = line.nextInt();
                String fort_dice = line.next();
                if(fort_dice.equals("-")){
                    Fortune fortune = new Fortune(fort_name, fort_hpBonus, fort_armor, fort_hitModifier);
                    fortunes.add(fortune);
                }else{
                    Fortune fortune = new Fortune(fort_name, fort_hpBonus, fort_armor, fort_hitModifier, DiceType.valueOf(fort_dice));
                    fortunes.add(fortune);
                }
            }
        }   
    }
    @Override
    public void save(String filename) {
        try {
            PrintWriter printWriter = new PrintWriter(filename);
            for(Knight knight : knights){
                printWriter.println(knight.toCSV());
            }
            printWriter.close();
        } catch (Exception e) {

        }
    }
    public static void main(String[] args) {
        CSVGameData data = new CSVGameData("PracticalOptionKnightFight-main\\gamedata.csv", "new.csv");
        System.out.println(data.activeKnights);
        System.out.println(data.fortunes);
        System.out.println(data.knights);
        System.out.println(data.monsters);


    }
}
