
import java.util.Scanner;

public class Game       {
    public int currentTime = 0;

    private static int iterationTime = 5;//время которое проходит за итерацию игрового цикла

    public static Scanner scanner = new Scanner(System.in);
    private TownHall townHall = new TownHall();
    private static Main main;
    private static boolean gameOver = false;
    public Game(Main main){
        this.main = main;
    }


    //метод обновления ферм
    public String  resourcerersUpdate(){
        int newResources = 0;
        for (Resourcerer resourcerer:TownArea.getResourcerers()) {
            resourcerer.mining();
            newResources += resourcerer.getResourcesPerIterationTime();
        }
        return "Было произведено "+newResources+" ну допустим хлеба";
    }
    //метод обновления мастерских
    public String craftsmenUpdate(){
    return "";
    }
    //метод обновления жилых домов
    public  String dwellingHousesUpdate(){
        String response = "";

        for(DwellingHouse dwellingHouse : TownArea.getDwellingHouses()){
            response += dwellingHouse.PopulationDecrease();
            response += dwellingHouse.PopulationGrowth();
        }
        return response;
    }

    public String buildersUpdate(){
        String response = "";

        System.out.println("Проверка строителей");
        for(int i=0;townHall.getBusyBuilders().size()>i;i++){

            response += townHall.getBusyBuilders().get(i).newDay()+"\n";
        }


        System.out.println(" занятых строителей "+ getTownHall().getBusyBuilders().size());
        return response;
    }

    public static void gameOver(){

        main.gameOver();
        gameOver = true;
    }

    public static int getIterationTime() {
        return iterationTime;
    }

    public TownHall getTownHall() {
        return townHall;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
