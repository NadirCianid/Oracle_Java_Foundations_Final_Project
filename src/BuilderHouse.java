

public class BuilderHouse {
    public BuilderHouse(TownHall townHall){
        TownArea.newBuilderHouse(this);
        townHall.newBuilder(new Builder(townHall));
    }
}
