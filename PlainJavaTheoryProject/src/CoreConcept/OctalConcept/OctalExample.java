package CoreConcept.OctalConcept;

public class OctalExample {
    // In Java, when an integer literal starts with a "0", it is interpreted as octal (base-8).

    public static void main(String[] args) {
        int a = 010;   // Octal 10 -> Decimal 8
        int b = 07;    // Octal 7  -> Decimal 7
        int c = 011;   // Octal 11 -> Decimal 9
        int d = 0;     // Decimal 0

        /*
            010 is octal (starts with 0), which is 1×8 + 0 = 8 in decimal.
            07 is just 7 in both octal and decimal.
            011 is 1×8 + 1 = 9 in decimal.
            0 is simply zero.
        */

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
    }
}
