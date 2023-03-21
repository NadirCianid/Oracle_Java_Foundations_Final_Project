

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Main extends Application {
    static Game game;
    
    //панели строительства и просмотра информации

    @FXML
    private  VBox buildingVBox;

    @FXML
    private  VBox infoVBox;
    //панель вывода информации по ходу игры (между шагами и после некоторых действий)

    @FXML
    private StackPane infoStackPane;

    @FXML
    private Text infoText;

    //кнопка вывода панели строительства
    public void buildPane(ActionEvent event) throws IOException {
        if(!game.isGameOver()){
            if(getInfoVBox().isVisible() || getInfoStackPane().isVisible()){
                getInfoVBox().setVisible(false);
                getInfoStackPane().setVisible(false);
            }

            getBuildingVBox().setVisible(!getBuildingVBox().isVisible());
        }
    }
    //кнопка вывода панели информации
    public void infoPane(ActionEvent event) throws IOException {
        if(!game.isGameOver()){
            if(getBuildingVBox().isVisible() || getInfoStackPane().isVisible()){
                getBuildingVBox().setVisible(false);
                getInfoStackPane().setVisible(false);
            }

            getInfoVBox().setVisible(!getInfoVBox().isVisible());
        }
    }
    //кнопки вывода информации
    public void showBuildingsInTheAreaInfo(ActionEvent event) throws IOException {
        if(!game.isGameOver()){
            getInfoVBox().setVisible(false);
            getInfoStackPane().setVisible(true);
            String info = game.getTownHall().reviewTownArea();
            getInfoText().setText(info);
        }
    }

    public void showBuildersInfo(ActionEvent event) throws IOException {
        if(!game.isGameOver()){
            getInfoVBox().setVisible(false);
            getInfoStackPane().setVisible(true);
            String info = game.getTownHall().checkBuilders();
            getInfoText().setText(info);
        }
    }

    public void showTreasuryInfo(ActionEvent event) throws IOException {
        if(!game.isGameOver()){
            getInfoVBox().setVisible(false);
            getInfoStackPane().setVisible(true);
            String info = "В вашем распоряжении "+game.getTownHall().getTreasury().getTreasury()+" денег.\n";
            getInfoText().setText(info);
        }
    }

    public void showResourcesInfo(ActionEvent event) throws IOException {
        if(!game.isGameOver()){
            getInfoVBox().setVisible(false);
            getInfoStackPane().setVisible(true);
            String info = "У вас накопилось "+ Resourcerer.getResourcesInStock()+" ну допустим хлеба.\n";
            getInfoText().setText(info);
        }
    }
//  кнопки строительства
    public void buildBuilderHouse(ActionEvent event) throws IOException {
        if(!game.isGameOver()){
            newLog(game.getTownHall().orderForBuilder( "BuilderHouse"));
            game.getTownHall().getTreasury().spendMoney(30);
        }
    }

    public void buildCraftsmanHouse(ActionEvent event) throws IOException {
        if(!game.isGameOver()){
            newLog(game.getTownHall().orderForBuilder( "CraftsmanHouse"));
            game.getTownHall().getTreasury().spendMoney(20);
        }
    }

    public void buildResourcerer(ActionEvent event) throws IOException {
        if(!game.isGameOver()){
            newLog(game.getTownHall().orderForBuilder( "Resourcerer(Farm or mine)"));
            game.getTownHall().getTreasury().spendMoney(30);
        }
    }

    public void buildCaravanManShop(ActionEvent event) throws IOException {
        if(!game.isGameOver()){
            newLog(game.getTownHall().orderForBuilder( "CaravanManShop"));
            game.getTownHall().getTreasury().spendMoney(10);
        }
    }

    public void buildDefenseBuilding(ActionEvent event) throws IOException {
        if(!game.isGameOver()){
            newLog(game.getTownHall().orderForBuilder( "DefenseBuilding"));
            game.getTownHall().getTreasury().spendMoney(100);
        }
    }

    public void buildDwellingHouse(ActionEvent event) throws IOException {
        if(!game.isGameOver()){
            newLog(game.getTownHall().orderForBuilder( "DwellingHouse"));
            game.getTownHall().getTreasury().spendMoney(5);
        }
    }
    //время, в которое началась предидущая итерация
    private int previousIteration = 0;
    //метод, в котором выполняется обновление всех объектов
    public void update(){
        System.out.println(game.currentTime);
        if(game.currentTime>=previousIteration+game.getIterationTime() && !game.isGameOver()) {
            String newDayMessage=
            "Прошло " + Game.getIterationTime() + " часов.\n"+
            game.buildersUpdate()+"\n"+
            game.resourcerersUpdate()+"\n"+
            game.craftsmenUpdate()+"\n"+
            game.dwellingHousesUpdate()+"\n";

            if(game.isGameOver()){
                newLog("Game Over!");
            }
            else newLog(newDayMessage);


            previousIteration = game.currentTime;
        }
    }
    //метод вывода сообщения о проигрыше
    public void gameOver(){
        newLog("GameOver");
    }
    //метод вывода информации
    private void newLog(String newDayMessage) {
        try {
            buildingVBox.setVisible(false);
            infoVBox.setVisible(false);

            infoStackPane.setVisible(true);

            infoText.setText(newDayMessage);
        }
        catch (Exception e){
            System.out.println("error in newLog");
        }


    }



    public static void main(String[] args){

        launch(args);

    }
    public static int countDownSeconds=0;


    @Override
    public void start(Stage primaryStage) throws Exception {
        game = new Game(this);

        //часть кода отвечающаяя за время
        int AllSeconds=10000;
        SimpleIntegerProperty seconds = new SimpleIntegerProperty(countDownSeconds);

        //в данном методе добавляются монеты в зависимости от множителя
         Timeline timeLine = new Timeline(
                new KeyFrame(Duration.seconds(1), (action ->{
                    seconds.set(seconds.intValue() + 1);

                    game.currentTime++;
                }))
        );
        timeLine.setCycleCount(AllSeconds);

        timeLine.play();

        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);



        primaryStage.getIcons().add(new Image("/Images/Icon.png"));
        primaryStage.show();


    }


    public VBox getBuildingVBox() {
        return buildingVBox;
    }

    public VBox getInfoVBox() {
        return infoVBox;
    }

    public StackPane getInfoStackPane() {
        return infoStackPane;
    }

    public Text getInfoText() {
        return infoText;
    }


}