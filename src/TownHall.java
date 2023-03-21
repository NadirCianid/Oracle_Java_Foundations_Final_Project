
import java.util.ArrayList;

public class TownHall {
    private Treasury treasury;
    private  ArrayList<Builder> freeBuilders = new ArrayList<Builder>();
    private  ArrayList<Builder> busyBuilders = new ArrayList<Builder>();
    private  ArrayList<String> buildingTypes = new ArrayList<String>(); // TODO через этот список организовать выбор здания
    public TownHall(){
        getFreeBuilders().add(new Builder(this));
        getFreeBuilders().add(new Builder(this));

        treasury = new Treasury(100);
    }

    public  ArrayList<Builder> getFreeBuilders() {
        return freeBuilders;
    }
    public void newBuilder(Builder builder){
        getFreeBuilders().add(builder);
    }

    public  ArrayList<Builder> getBusyBuilders() {
        return busyBuilders;
    }


    //метод, передающий заказ на постройку строителю
    public String orderForBuilder(String buildingType){
        String response = "";
        if(getFreeBuilders().size()>=1){
            Builder builder = getFreeBuilders().remove(getFreeBuilders().size()-1); //из списка свободных строителей строитель переходит в список занятых

            response += builder.startBuilding(buildingType);
        }
        else response = "Все строители заняты!";
        return response;
    }

    public String reviewTownArea(){
        return TownArea.getBuildingsInfo();
    }

    public void DemolishABuilding(Builder builder){

    }


    public String checkBuilders(){
        return  "Свободных строителей сейчас "+freeBuilders.size()+
                "\nЗанятых строителей сейчас "+busyBuilders.size();
    }


    public void Initialize(){
        buildingTypes.add("DwellingHouse");
        buildingTypes.add("BuilderHouse");
        buildingTypes.add("CraftsmanHouse");
        buildingTypes.add("DefenseBuilding");
        buildingTypes.add("CaravanManShop");
        buildingTypes.add("Resourcerer(Farm or mine)");
    }

    public Treasury getTreasury() {
        return treasury;
    }
}
