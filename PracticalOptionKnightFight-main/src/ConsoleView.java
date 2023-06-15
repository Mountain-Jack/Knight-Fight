

import java.util.List;
import java.util.Scanner;

public class ConsoleView implements GameView{
    private final Scanner in = new Scanner(System.in);
    
    ConsoleView(){
    }
    @Override
    public void splashScreen() {
        System.out.print("HELLO GAME TIME!");
    }
    @Override
    public void endGame(){
        System.out.print("Goodbye");
    }
    @Override
    public String displayMainMenu(){
        System.out.print("What would you like to do?");
        return in.nextLine();
    }
    @Override
    public void printHelp() {
        System.out.print("Unsure what to do, here are some options:");
        System.out.println("           ls or list all  - listing the knights");
        System.out.println("           list active  - list the active knights knights only");
        System.out.println("           show name or id - show the knight details card");
        System.out.println("           set active name or id - set knight as active (note: only 4 knights can be active) ");
        System.out.println("           remove active name or id - remove a knight from active status (heals knight)");
        System.out.println("           explore or adventure or quest - find random monsters to fight");
        System.out.println("           save filename - save the game to the file name (default: saveData.csv)");
        System.out.println("           exit or goodbye - to leave the game\n");
        System.out.println("Game rules: You can have four active knights. As long as they are active, they won't heal, but they can gain XP by going on adventures.");
        System.out.println("When you make a knight inactive, they will heal. How many monsters can you defeat before, you have to heal?");
    }
    @Override
    public void listKnights(List<Knight> knights) {
        if(knights.size() == 0){
            System.out.println("No knights to list");
            return;
        }
        for(Knight knight : knights){
            System.out.println(knight.getId() + ": " + knight.getName());
        }
    }
    @Override
    public void knightNotFound() {
        System.out.println("Knight not found!");
    }
    @Override
    public void showKnight(Knight knight) {
        System.out.print(knight.toString() + "\n");
    }
    @Override
    public void setActiveFailed() {
        System.out.println("Unable to set active knight. Only four can be active at a time.");
    }
    @Override
    public void printBattleText(List<MOB> monsters, List<Knight> activeKnights) {
        for(int i = 0; i < activeKnights.size(); i++){
            Knight tempKnight = activeKnights.get(i);
            if(i < monsters.size()){
                MOB tempMonster = monsters.get(i);
                System.out.println(String.format("%-27s%n", tempKnight.getName(), tempMonster.getName()));;
            }else{
                System.out.println(String.format("%-27s%n", tempKnight.getName()));;
            }           
        }
    }
    @Override
    public void printBattleText(MOB dead) {
        System.out.println(dead.getName() + " was defeated!");
    }
    @Override
    public void printFortunes(List<Knight> activeKnights) {
        System.out.println("For this quest, our knights drew the following fortunes!");
        for(Knight knight : activeKnights){
            System.out.println(knight.getName());
            System.out.println(knight.getActiveFortune().toString());
        }
    }
    @Override
    public boolean checkContinue() {
        System.out.println("Would you like to continue on your quest (y/n)? ");
        String answer = in.nextLine();
        if((answer.toLowerCase().equals("y") || (answer.toLowerCase().equals("yes")))){
            return true;
        }
        return false;
    }
    @Override
    public void printDefeated() {
        System.out.println("All active knights have been defeated!\n");
    }
}
