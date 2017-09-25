
import kareltherobot.*; 


/**
 * @author :  A. Zulch
 */
public class BeeperBot extends Robot
{
    //instance variable to store beeper count
    int[] beeperList = new int[13];
    int tempCount = 0;
    
    public BeeperBot(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void findAndCountBeepers() {
        while(frontIsClear()) {
            collectBeeperSteeple();
        }
    }
    
    public int[] getBeeperList() {
            //This will be used to print the beepers found.  No need to modify.
            return beeperList;
    }
    
    public void collectBeeperSteeple() {
        findBeepers();
    }
    public void findBeepers() {
        while(!nextToABeeper() && frontIsClear()){
           move(); 
        }
        pickUpColumn();
        goDown();
        faceEast();
        }
    public void pickUpColumn(){
        tempCount = 0;
        while(nextToABeeper()){
            faceNorth();
            pickBeeper();
            tempCount++;
            move();
        }
        beeperList[0] = tempCount;
    }
    public void goDown(){
        while(frontIsClear()){
            faceSouth();
            move();
        }
    }
    public void faceEast() {
        while(!facingEast()){
            turnLeft();
        }
    }
    public void faceSouth() {
        while(!facingSouth()){
            turnLeft();
        }
    }
    public void faceNorth() {
        while(!facingNorth()) {
            turnLeft();
        }
    }
}

