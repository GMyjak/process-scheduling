/** Prosta klasa rozszerzająca klasę Random
 *  Posiada jedną metodę - nextBoundedInt losującą liczbę całkowitą z podanego zakresu [od, do]
 */

import java.util.Random;

public class RNG extends Random
{
    public RNG()
    {
        super();
    }

    public int nextBoundedInt(int min, int max)
    {
        return nextInt(max-min+1)+min;
    }
}
