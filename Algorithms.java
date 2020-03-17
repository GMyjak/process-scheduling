/** klasa abstrakcyjna Algorithms
 *  posiada metody uniwersalne dla każdego z algorytmów:
 *  extendQueue - sprawdza, czy jakieś procesy zgłosiły gotowość do wykonania, jeśli tak - dołącza je do kolejki
 *  averageWaitingTime - oblicza ŚCO dla danego algorytmu na podstawie danych zebranych w liście procesów obsłużonych **/

import java.util.ArrayList;

abstract class Algorithms
{
    protected int processorTimer;
    protected SimulationDataGenerator data;
    protected int dataCollectionSize;
    protected ArrayList<Process> readyProcesses;
    protected ArrayList<Process> finishedProcesses;

    public Algorithms(SimulationDataGenerator data)
    {
        processorTimer = 0;
        this.data = data;
        dataCollectionSize = data.size();
        readyProcesses = new ArrayList<>();
        finishedProcesses = new ArrayList<>();
    }

    protected void extendQueue()
    {
        if(!data.isEmpty())
        {
            if (processorTimer == data.get(0).getSubmitTime())
            {
                readyProcesses.add(data.get(0));
                data.remove(0);
                extendQueue();
            }
        }
    }

    protected int averageWaitingTime()
    {
        int temp = 0;
        for (Process p : finishedProcesses)
        {
            temp = temp + p.getTotalWaitingTime();
        }
        temp = temp / dataCollectionSize;
        return temp;
    }

    abstract int execute();
}
