
public class Treasury {
    private int treasury;

    public Treasury(int startCapital){
        treasury = startCapital;
    }

    public int getTreasury() {
        return treasury;
    }
    public void spendMoney(int howMuch){
        treasury-=howMuch;
        if(treasury<0){
           Game.gameOver();
        }
    }
    public void earnMoney(int howMuch){
        treasury+=howMuch;
    }
}
