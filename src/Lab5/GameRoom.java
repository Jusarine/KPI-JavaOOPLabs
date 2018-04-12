package Lab5;

import java.util.*;

public class GameRoom {
    /** USDs */
    private float money;
    private MyLinkedList<Toy> toys;


    public GameRoom(float money) {
        this.money = money;
        initToys();
    }

    /**
     * randomly initialize toys list
     */
    private void initToys(){
        toys = new MyLinkedList<>();
        Toy temp;
        while(true){
            temp = chooseToy();
            money -= temp.prize;
            if (money > 0){
                toys.add(temp);
            }
            else{
                break;
            }
        }
    }

    /**
     *
     * @return randomly chose toy: ball, car, doll or cube
     */
    private Toy chooseToy(){
        Random random = new Random();
        Toy toy = null;
        switch(random.nextInt(4)){
            case 0:
                toy = new Ball();
                break;
            case 1:
                toy = new Car();
                break;
            case 2:
                toy = new Doll();
                break;
            case 3:
                toy = new Cube();
                break;

        }
        return toy;
    }

    /**
     * sort toys by size
     */
    public void sortBySize(){
        Collections.sort(toys, Comparator.comparing(o -> o.size));
        System.out.println("Sorted by size: " + toys);
    }

    /**
     * sort toys by color
     */
    public void sortByColor(){
        Collections.sort(toys, Comparator.comparing(o -> o.color));
        System.out.println("Sorted by color: " + toys);
    }

    /**
     * sort toys by prize
     */
    public void sortByPrize(){
        Collections.sort(toys, Comparator.comparing(o -> o.prize));
        System.out.println("Sorted by prize: " + toys);
    }

    /**
     * sort toys by age
     */
    public void sortByAge(){
        Collections.sort(toys, Comparator.comparing(o -> o.minAge));
        System.out.println("Sorted by age: " + toys);
    }

    /**
     *
     * @param minPrize lower bound of range
     * @param maxPrize upper bound of range
     * @return toy list with prize between minPrize and maxPrize
     */
    public MyLinkedList<Toy> find(float minPrize, float maxPrize){
        MyLinkedList<Toy> toysInRange = new MyLinkedList<>();

        for (Toy toy : toys) {
            if (toy.prize >= minPrize && toy.prize <= maxPrize) {
                toysInRange.add(toy);
            }
        }
        System.out.println("Found in range [" + minPrize + ", " +  maxPrize + "]: " + toysInRange);
        return toysInRange;
    }

}
