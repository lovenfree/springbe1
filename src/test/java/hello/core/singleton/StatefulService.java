package hello.core.singleton;

public class StatefulService {

    private int price;

    public void order(String name, int price){
        System.out.printf("name = "+name +" price = "+price);
        this.price = price;
    }

    public int getPrice(){
        return  price;
    }
}
