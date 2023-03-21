
public class DwellingHouse {
    private int dwellersCount; //число жителей дома
    private final int timeToGrowPopulation = Game.getIterationTime()*5;
    private final int populationDecreasingTime = Game.getIterationTime()*10;
    private int populationGrowthDuration = 0;
    private int resourcesPerDay = 5;
    private int populationDecreasingDuration = 0;
    public DwellingHouse(){
        dwellersCount = 2;
        TownArea.newDwellingHouse(this);
    }

    //рост численности в несколько раундов с потреблением ресурсов
    public String PopulationGrowth(){
        populationGrowthDuration+=Game.getIterationTime();
        Resourcerer.useResourcesFromStock(resourcesPerDay);
        if(populationGrowthDuration>= timeToGrowPopulation){
            Resourcerer.useResourcesFromStock(resourcesPerDay);
            resourcesPerDay++;
            dwellersCount = getDwellersCount() + 1;
             return  "Пополнение в некоем доме";
        }
        return "";
    }
    //убыль численности с уменьшением затрат ресурсов населения
    public String  PopulationDecrease(){
        populationDecreasingDuration+=Game.getIterationTime();
        if(populationDecreasingTime>= populationDecreasingDuration){
            dwellersCount = getDwellersCount() - 1;


            resourcesPerDay--;
            return  "Царство ему небесное";
        }
        return "";
    }

    public void Upgrade(){

    }

    public int getDwellersCount() {
        return dwellersCount;
    }
}
