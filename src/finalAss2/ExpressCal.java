package finalAss2;

public class ExpressCal extends PosExpress{

    public ExpressCal(double totalprice){
        super(totalprice);
    }
    public double expressCal(double weight, int quantity){

        double price=0;

        if(weight<=100){
            price=3.18;
        }if(weight>100&&weight<=250){
            price=3.71;
        }if(weight>250&&weight<=500){
            price=4.77;
        }if(weight>500&&weight<=1000){
            price=7.42;
        }
        totalPrice =price*quantity;
        return totalPrice;
    }
}
