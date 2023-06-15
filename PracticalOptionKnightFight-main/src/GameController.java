public class GameController {
    private final GameData data;
    private final CombatEngine engine;
    private final GameView view;

    GameController(GameData data, GameView view, CombatEngine engine){
        this.data = data;
        this.engine = engine;
        this.view = view;
    }
    public void start(){
        boolean run = true;
        while(run){
            run = processCommand(view.displayMainMenu());
        }
        view.endGame();
    }
    protected boolean processCommand(String command){
        String input = command.toLowerCase().trim();
        if(input.contains("exit") || input.contains("bye")){
            return false;
        }
        if(input.equals("ls") || input.equals("list all")){
            view.listKnights(data.getKnights());
            return true;
        }
        if(input.equals("list active")){
            view.listKnights(data.getActiveKnights());
            return true;
        }
        if(input.contains("show")){
            input = input.replace("show", "").trim();
            view.showKnight(data.getKnight(input));
            return true;
        }
        if(input.contains("set active")){
            input = input.replace("set active", "").trim();
            try {
                data.setActive(data.getKnight(input));
            } catch (Exception e) {
                return true;
            }
            return true;
        }
        if(input.contains("remove")){
            input = input.replace("remove", "").trim();
            try {
                data.removeActive(data.getKnight(input));
            } catch (Exception e) {
                return true;
            }
            return true;
        }
        if(input.contains("save")){
            input = input.replace("save", "").trim();
            if(input.equals("")){
                data.save("saveData.csv");
            }else{
                data.save(input);
            }
            return true;
        }
        if(input.contains("explore") || input.contains("adventure") || input.contains("quest")){
            engine.initialize();
            engine.runCombat();
            engine.clear();
            return true;
        }
        view.printHelp();
        return true;
    }
}
