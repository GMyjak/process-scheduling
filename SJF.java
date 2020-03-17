import java.util.Collections;
import java.util.Comparator;


public class SJF extends Algorithms
{
    private Process currentProcess;

    public SJF(SimulationDataGenerator data)
    {
        super(data);
    }

    public int execute()
    {
        while (!readyProcesses.isEmpty() || !data.isEmpty() || !(currentProcess==null))
        {
            extendQueue();
            Collections.sort(readyProcesses, new Comp());

            processorTimer++;

            //Wypieranie procesu do przetworzenia

            if (currentProcess == null)
            {
                if (!readyProcesses.isEmpty())
                {
                    currentProcess = readyProcesses.get(0);
                    readyProcesses.remove(0);
                }
            }

            //Wykonywanie procesu

            if (currentProcess != null)
            {
                if (currentProcess.calculate())
                {
                    currentProcess.setFinishTime(processorTimer);
                    finishedProcesses.add(currentProcess);
                    currentProcess = null;
                }
            }

        }

        return averageWaitingTime();
    }

    private class Comp implements Comparator<Process>
    {
        public int compare(Process p1, Process p2)
        {
            return (p1.getRemainingTime() - p2.getRemainingTime());
        }
    }
}