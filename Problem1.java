
import kareltherobot.*; 


/**
 * @author :  A. Zulch
 */
public class Problem1 extends Robot
{
    int[] beeperRow = new int[8];
    int tempCount = 0;
    int index = 0;
    int tempIndex = 0;
    int[] sortingArray = new int[8];
    int sortingIndex = 0;
    public Problem1(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void sortBeepers() {
        arriveAtRow();
        for (int i = 0; i < 8; i++){
            pickUpRow();
        }
        sortOrder();
        putDownRow();
    }
    public void arriveAtRow(){
        while (frontIsClear()){
            move();
        }
        faceSouth();
        while (frontIsClear()){
            move();
        }
    }
    public void pickUpRow(){
        while(nextToABeeper()){
            faceNorth();
            pickBeeper();
            tempCount++;
            move();
        }
        beeperRow[index] = tempCount;
        resetPosition();
    }
    public void resetPosition() {
        faceSouth();
        while (frontIsClear()){
            move();
        }
        faceEast();
        move();
        tempCount = 0;
        index++;
        printArray();
    }
    public void printArray() {
        System.out.println();
        for (int value: beeperRow) {
            System.out.print(value + " , ");
        }
        System.out.println();
    }
    public void printSortingArray() {
        System.out.println("Sorted Array");
        for (int value: sortingArray) {
            System.out.print(value + " / ");
        }
        System.out.println();
    }
    public void sortOrder() {
        for (int i = 0; i < 7; i++) {
            int smallest = beeperRow[i];
            for(int j = i + 1; j < 7; j++) {
                
                
                if (beeperRow[j] < smallest) {
                    smallest = beeperRow[j];
                    //sortingArray[sortingIndex + 1] = beeperRow[tempIndex];
                    //printSortingArray();
                }
                
            }
            sortingArray[i] = smallest;
            
        }
        printArray();
        printSortingArray();
    }
    
    public void putDownRow() {
        
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
    public void faceWest() {
        while(!facingWest()){
            turnLeft();
        }
    }
}

