/** Klasa rozszerzjąca klasę ArrayList
 *  Służy do generowania losowego ciągu procesów
 *  W konstruktorze generuje dane wprowadzane do ArrayListy
 *  Pobiera dane ze statycznych pól klasy Main
 */

import java.util.ArrayList;
import java.util.Collections;

public class SimulationDataGenerator extends ArrayList<Process>
{
    public SimulationDataGenerator()
    {
        super();
        RNG rng = new RNG();
        int numberOfProcesses = rng.nextBoundedInt(Main.minAmountOfProcesses, Main.maxAmountOfProcesses);
        for (int i=0; i<numberOfProcesses; i++)
        {
            int submitTime = (rng.nextInt(5)%5)*rng.nextInt(Main.maxSubmitTime)/4;
            if (rng.nextInt(5)%5 == 0)
            {
                add(new Process(rng.nextBoundedInt(Main.minProTimeUs, Main.maxProTimeUs), submitTime));
            }
            else
            {
                add(new Process(rng.nextBoundedInt(Main.minProTimeSys, Main.maxProTimeSys), submitTime));
            }
        }
        Collections.sort(this);
    }

    public String toString()
    {
        String sb = "\nRandom sequence of processes:\n-------------------------\n";
        for(Process p : this)
        {
            sb = sb + p;
        }
        return sb;
    }

    public SimulationDataGenerator clone()
    {
        SimulationDataGenerator temp = new SimulationDataGenerator();
        temp.clear();
        for (Process p : this)
        {
            temp.add(p.clone());
        }
        return temp;
    }
}
