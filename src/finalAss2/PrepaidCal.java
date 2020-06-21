package finalAss2;

public class PrepaidCal extends PrepaidBox_Envelope {

    public PrepaidCal (double totalPrice){
        super(totalPrice);
    }

    public double prepaidCal (double weight,int quantity){
        double price=0;

        if(weight<=500){
            price=7.31;
        }if(weight>500&&weight<=1000){
            price=10.49;
        }if(weight>1000&&weight<=2000){
            price=13.78;
        }if(weight>2000&&weight<=5000){
            price=21.20;
        }if(weight>5000&&weight<=10000){
            price=31.80;
        }
        totalPrice=price*quantity;
        return totalPrice;
    }
}
