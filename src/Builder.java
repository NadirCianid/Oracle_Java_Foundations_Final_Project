
public class Builder {
    private int buildingDuration=0;
    private String buildingType;
    private int timeToBuild=Game.getIterationTime()*3;
    private  TownHall townHall;

    public Builder(TownHall townHall){

        this.townHall = townHall;

    }
    //обновление с приходом новго дня
    public String newDay(){
        buildingDuration+=Game.getIterationTime();
        if(buildingDuration >= timeToBuild){ //если прошло три дня, то здание достраивается
            switch (buildingType) {
                case "DwellingHouse":
                    DwellingHouse newDwellingHouse= new DwellingHouse();
                    townHall.getFreeBuilders().add(                                            //Строитель выходит из списка занятых строителей
                            townHall.getBusyBuilders().remove(townHall.getBusyBuilders().size()-1)); //Чувствую здесь может быть проблема, что выйдет не тот строитель,который должен ((((((
                    System.out.printf("Строительство "+ buildingType +" завершилось\n");
                    break;
                case "BuilderHouse":
                    BuilderHouse newBuilderHouse = new BuilderHouse(townHall);
                    townHall.getFreeBuilders().add(                                            //Строитель выходит из списка занятых строителей
                            townHall.getBusyBuilders().remove(townHall.getBusyBuilders().size()-1)); //Чувствую здесь может быть проблема, что выйдет не тот строитель,который должен ((((((
                    System.out.printf("Строительство "+ buildingType +" завершилось\n");
                    break;
                case "CraftsmanHouse":
                    CraftsmanHouse newCraftsmanHouse = new CraftsmanHouse();
                    townHall.getFreeBuilders().add(                                            //Строитель выходит из списка занятых строителей
                            townHall.getBusyBuilders().remove(townHall.getBusyBuilders().size()-1)); //Чувствую здесь может быть проблема, что выйдет не тот строитель,который должен ((((((
                    System.out.printf("Строительство "+ buildingType +" завершилось\n");
                    break;
                case "DefenseBuilding":
                    DefenseBuilding newDefenseBuilding = new DefenseBuilding();
                    townHall.getFreeBuilders().add(                                            //Строитель выходит из списка занятых строителей
                            townHall.getBusyBuilders().remove(townHall.getBusyBuilders().size()-1)); //Чувствую здесь может быть проблема, что выйдет не тот строитель,который должен ((((((
                    System.out.printf("Строительство "+ buildingType +" завершилось\n");
                    break;
                case "CaravanManShop":
                    CaravanManShop newCaravanManShop = new CaravanManShop();
                    townHall.getFreeBuilders().add(                                            //Строитель выходит из списка занятых строителей
                            townHall.getBusyBuilders().remove(townHall.getBusyBuilders().size()-1)); //Чувствую здесь может быть проблема, что выйдет не тот строитель,который должен ((((((
                    System.out.printf("Строительство "+ buildingType +" завершилось\n");
                    break;
                case "Resourcerer(Farm or mine)":
                    Resourcerer newResourcerer = new Resourcerer();
                    townHall.getFreeBuilders().add(                                            //Строитель выходит из списка занятых строителей
                            townHall.getBusyBuilders().remove(townHall.getBusyBuilders().size()-1)); //Чувствую здесь может быть проблема, что выйдет не тот строитель,который должен ((((((
                    System.out.printf("Строительство "+ buildingType +" завершилось\n");
                    break;
                default:
                    System.out.print("Ошибка ввода.");
                    break;
            }
            buildingDuration = 0;
            return "Строительство "+ buildingType +" завершилось\n";
        }
        return "";
    }
    //обозначение начала строительства, которое закончится через 3 дня
    public  String  startBuilding(String buildingType){
        townHall.getBusyBuilders().add(this);
        this.buildingType = buildingType;
        return "Строительство "+ buildingType +" началось\n";
    }


}
