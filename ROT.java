public class ROT extends Algorithms
{
    private final int quantum;
    private int remainingQuantum;

    public ROT (SimulationDataGenerator data)
    {
        super(data);
        quantum = Main.ROTquantum;
        remainingQuantum = quantum;
    }

    public int execute()
    {
        while(!readyProcesses.isEmpty() || !data.isEmpty())
        {
            extendQueue();
            processorTimer++;

            if (!readyProcesses.isEmpty())
            {
                remainingQuantum--;

                if (readyProcesses.get(0).calculate())
                {
                    readyProcesses.get(0).setFinishTime(processorTimer);
                    finishedProcesses.add(readyProcesses.get(0));
                    readyProcesses.remove(0);
                    remainingQuantum = quantum;
                }

                if (remainingQuantum == 0)
                {
                    readyProcesses.add(readyProcesses.get(0));
                    readyProcesses.remove(0);
                    remainingQuantum = quantum;
                }
            }

        }

        return averageWaitingTime();
    }
}