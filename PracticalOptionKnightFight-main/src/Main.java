public class Main {
    private static String gameData = "gamedata.csv";
    private static String saveData = "knights.csv";
    public static void main(String[] args){
        processArgs(args);

        //problem is with args I think
        GameData data = new CSVGameData(gameData, saveData);
        GameView view  = new ConsoleView();
        CombatEngine engine = new CombatEngine(data, view);
        GameController controller = new GameController(data, view, engine);
        controller.start();
    }
    private static void processArgs(String[] args){
         for(String arg : args){
            System.out.println(arg);
             if(arg.contains("--data")){
                 gameData = arg.substring(arg.indexOf("=") + 1);
             }else{
                 saveData = arg;
             }
         }
     }
}
