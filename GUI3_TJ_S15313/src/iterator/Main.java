/**
 *
 *  @author Tomaszewska Justyna S15313
 *
 */

package iterator;


public class Main {
    public static void main(String... args) {
        int ini = 77031, count = -1, maxel = 0;
    	Hailstone hailstone = new Hailstone(ini);
        for (int h : hailstone) {
            if (h > maxel) maxel = h;
            ++count;
        }
        System.out.println(ini + " " + count + " " + maxel);
    }
}
