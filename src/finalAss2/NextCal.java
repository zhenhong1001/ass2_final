package finalAss2;

import java.io.IOException;

public class NextCal extends NextDay{

    public NextCal (double charge1) {
        super(charge1);
    }

    public double zone1(double weight, int quantity){
        if (weight <= 2000) {
            if (weight <= 2000) {
                charge1 = (4.90 + (weight - 500) / 250 * 0.80)*quantity;
            }
            if (weight <= 500) {
                charge1 = 4.90*quantity;
            }
        }
        if (weight > 2000) {
            if (weight <= 2500) {
                charge1 = 10.50*quantity;
            }
            if (weight > 2500) {
                charge1 = (10.50 + (weight - 2500) / 500 * 0.50)*quantity;
            }
        } return charge1;
    }

    public double zone2(double weight, int quantity){
        if (weight <= 2000) {
            if (weight <= 2000) {
                charge1 = (5.40 + (weight - 500) / 250 * 1.00) * quantity;
            }
            if (weight <= 500) {
                charge1 = 5.40 * quantity;
            }
        }
        if (weight > 2000) {
            if (weight <= 2500) {
                charge1 = 16.00 * quantity;
            }
            if (weight > 2500) {
                charge1 = (16.00 + (weight - 2500) / 500 * 2.00) * quantity;
            }
        } return charge1;
    }

    public double zone3(double weight, int quantity){
        if (weight <= 2000) {
            if (weight <= 2000) {
                charge1 = (6.90 + (weight - 500) / 250 * 1.50) * quantity;
            }
            if (weight <= 500) {
                charge1 = 6.90 * quantity;
            }
        }
        if (weight > 2000) {
            if (weight <= 2500) {
                charge1 = 21.00 * quantity;
            }
            if (weight > 2500) {
                charge1 = (21.00 + (weight - 2500) / 500 * 3.00) * quantity;
            }
        } return charge1;
    }

    public double zone4(double weight, int quantity){
        if (weight <= 2000) {
            if (weight <= 2000) {
                charge1 = (7.40 + (weight - 500) / 250 * 1.50) * quantity;
            }
            if (weight <= 500) {
                charge1 = 7.40 * quantity;
            }
        }
        if (weight > 2000) {
            if (weight <= 2500) {
                charge1 = 26.00 * quantity;
            }
            if (weight > 2500) {
                charge1 = (26.00 + (weight - 2500) / 500 * 3.50) * quantity;
            }
        } return charge1;
    }

    public double zone5(double weight, int quantity){
        if (weight <= 2000) {
            if (weight <= 2000) {
                charge1 = (7.90 + (weight - 500) / 250 * 2.00) * quantity;
            }
            if (weight <= 500) {
                charge1 = 7.90 * quantity;
            }
        }
        if (weight > 2000) {
            if (weight <= 2500) {
                charge1 = 31.00 * quantity;
            }
            if (weight > 2500) {
                charge1 = (31.00 + (weight - 2500) / 500 * 4.00) * quantity;
            }
        } return charge1;
    }
}