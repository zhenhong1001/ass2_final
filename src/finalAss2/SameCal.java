package finalAss2;

public class SameCal extends SameDay {
    double surcharge=0;
    double domestic_charge=0;

    public SameCal (double payment){
        super(payment);
    }

    public double Local(double weight, int quantity){

        if(weight<500){
            domestic_charge=4.90;
            surcharge=6.00;
        }
        if(weight>=500&&weight<750){
            domestic_charge=5.70;
            surcharge=6.00;
        }
        if(weight>=750&&weight<=1000){
            domestic_charge = 6.50;
            surcharge = 6.00;
        }
        payment = (domestic_charge + surcharge)*quantity;
        return payment;
    }

    public double Cross(double weight, int quantity) {

        if (weight < 500) {
            domestic_charge = 5.40;
            surcharge = 7.50;
        }
        if (weight >= 500 && weight < 750) {
            domestic_charge = 6.40;
            surcharge = 7.50;
        }
        if (weight >= 750 && weight <= 1000) {
            domestic_charge = 7.40;
            surcharge = 7.50;
        }
        payment = (domestic_charge + surcharge)*quantity;
        return payment;
    }
}
