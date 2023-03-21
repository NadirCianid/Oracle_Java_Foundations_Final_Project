
import java.util.ArrayList;

public class TownArea {

    private static ArrayList<BuilderHouse> builderHouses = new ArrayList<BuilderHouse>();
    private static ArrayList<CraftsmanHouse> craftsmanHouses = new ArrayList<CraftsmanHouse>();
    private static ArrayList<DefenseBuilding> defenseBuildings = new ArrayList<DefenseBuilding>();
    private static ArrayList<Resourcerer> resourcerers = new ArrayList<Resourcerer>();
    private static ArrayList<DwellingHouse> dwellingHouses = new ArrayList<DwellingHouse>();
    private  static ArrayList<CaravanManShop> caravanManShops = new ArrayList<CaravanManShop>();




    // TODO наследовать все здания от класса Building и решить эту проблему)
    public static void newBuilderHouse(BuilderHouse builderHouse){
        builderHouses.add(builderHouse);
    }
    public static void newCraftsmanHouse(CraftsmanHouse craftsmanHouse){
        craftsmanHouses.add(craftsmanHouse);
    }
    public static void newResourcerer(Resourcerer resourcerer){
        resourcerers.add(resourcerer);
    }
    public static void newDwellingHouse(DwellingHouse dwellingHouse){
        dwellingHouses.add(dwellingHouse);
    }
    public static void newCaravanManShop(CaravanManShop caravanManShopToBuild){
        caravanManShops.add(caravanManShopToBuild);
    }
    public static void newDefenseBuilding(DefenseBuilding defenseBuilding){
        defenseBuildings.add(defenseBuilding);
    }

    public static String getBuildingsInfo(){
        int buildingsCount = builderHouses.size() +
                caravanManShops.size() +
                craftsmanHouses.size() +
                defenseBuildings.size() +
                dwellingHouses.size() +
                resourcerers.size();

        if(buildingsCount !=0){
            return "В округе "+builderHouses.size()+" домиков строителей."+
                    "В округе "+caravanManShops.size()+" лавок торговца."+
                    "В округе "+craftsmanHouses.size()+" мастерских."+
                    "В округе "+defenseBuildings.size()+" защитных построек."+
                    "В округе "+dwellingHouses.size()+" жилых домов."+
                    "В округе "+resourcerers.size()+" ресурсеров.\n";
        } else {
            return "В округе есть только ваша ратуша.\n";
        }
    }

//    public  int count(BuilderHouse builderHouse){
//        int villagersCount = 0;
//        for(BuilderHouse building: builderHouses){
//            villagersCount += building.getBuilderHouses();
//        }
//        return villagersCount;
//    }
    public static ArrayList<BuilderHouse> getBuilderHouses() {return builderHouses; }

    public static ArrayList<CraftsmanHouse> getCraftsmanHouses() {
        return craftsmanHouses;
    }

    public static ArrayList<DefenseBuilding> getDefenseBuildings() {
        return defenseBuildings;
    }

    public static ArrayList<Resourcerer> getResourcerers() {
        return resourcerers;
    }

    public static ArrayList<DwellingHouse> getDwellingHouses() {
        return dwellingHouses;
    }

    public static ArrayList<CaravanManShop> getCaravanManShop() {
        return caravanManShops;
    }
}
