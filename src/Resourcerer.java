
//Источник статического прихода ресурсов
public class Resourcerer {
    //пока пусть будет фермой
    private int resourcesPerIterationTime = 10; //пусть будет условный хлеб
    private static int resourcesInStock = 0;

    public Resourcerer(){
        TownArea.newResourcerer(this);
    }

    public static int getResourcesInStock() {
        return resourcesInStock;
    }
    //метод потребления ресурсов
    public static void useResourcesFromStock(int howMuch){
        resourcesInStock-=howMuch;
        if(resourcesInStock<0){
            Game.gameOver();
        }
    }

    public void mining(){
        resourcesInStock = getResourcesInStock() + getResourcesPerIterationTime();
    }

    public int getResourcesPerIterationTime() {
        return resourcesPerIterationTime;
    }
}
