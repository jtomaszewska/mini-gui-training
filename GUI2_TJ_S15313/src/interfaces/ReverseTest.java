/**
 *
 *  @author Tomaszewska Justyna S15313
 *
 */

package interfaces;


public class ReverseTest {

  public static void main(String[] args) {
  
        Reversible[] revers = new Reversible[] {
            new ReversibleString("Kot"),
            new ReversibleDouble(2),
            new ReversibleDouble(3),
            new ReversibleString("Pies"),
            new ReversibleString("Ala ma kota i psa"),
            new ReversibleDouble(10),
        };

        System.out.println("Normalne:");
        for (Reversible r : revers) {
          System.out.println(r);
        }

        for (Reversible r : revers) {
          r.reverse();
        }

        System.out.println("Odwrócone:");
        for (Reversible r : revers) {
          System.out.println(r);
        }

        System.out.println("Przywrócone i zmienione:");
        for (Reversible r : revers) {
        	if(r instanceof ReversibleDouble){
        		ReversibleDouble przywroconeRD = ((ReversibleDouble) r);
        		przywroconeRD.reverse();
        		((ReversibleDouble) r).number = przywroconeRD.number + 10;
        	}
        	else{
        		ReversibleString przywroconeRS = ((ReversibleString) r);
        		przywroconeRS.reverse();
        		((ReversibleString) r).text = "Tekst " + przywroconeRS;
        	}
        	System.out.println(r);
        }
      }
    }
