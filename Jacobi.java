import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author OZGUR
 */
public class Jacobi {

    /**
     * @param args the command line arguments
     */
    private double x1, x2, x3;//variables continuation values
    private double td; //tolerance value
    private double x1FirstValue, x2FirstValue, x3FirstValue;// variables first values
    private Scanner scan = new Scanner(System.in);
    private DecimalFormat frm = new DecimalFormat("#.####");

    public Jacobi(double td, double x1FirstValue, double x2FirstValue, double x3FirstValue) {
        this.td = td;
        this.x1FirstValue = x1FirstValue;
        this.x2FirstValue = x2FirstValue;
        this.x3FirstValue = x3FirstValue;
    }

    double x1Hesapla(double x1, double x2, double x3) {
        return (1 / 5.0) * (2 + x2 - 2 * x3);
    }

    double x2Hesapla(double x1, double x2, double x3) {
        return (1 / 5.0) * (-2 + x1 + 2 * x3);
    }

    double x3Hesapla(double x1, double x2, double x3) {
        return (1 / 4.0) * (4 + 2 * x1 - x2);
    }

    public void calculateJacobi() {
        x1FirstValue = x2FirstValue = x3FirstValue = 0;
        int i = 1;
        while (true) {
            x1 = x1Hesapla(x1FirstValue, x2FirstValue, x3FirstValue);
            x2 = x2Hesapla(x1FirstValue, x2FirstValue, x3FirstValue);
            x3 = x3Hesapla(x1FirstValue, x2FirstValue, x3FirstValue);
            System.out.println(i + ".iteration:\n" + "x1: " + frm.format(x1) + "\t\t\t\t" + "x2: " + frm.format(x2) + "\t\t\t\t" + " x3: " + frm.format(x3));
            if ((Math.abs(x1 - x1FirstValue)) <= td && (Math.abs(x2 - x2FirstValue)) <= td && (Math.abs(x3 - x3FirstValue)) <= td) {
                break;
            }
            x1FirstValue = x1;
            x2FirstValue = x2;
            x3FirstValue = x3;
            i++;
        }

    }

}
