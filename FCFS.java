public class FCFS extends Algorithms
{
    public FCFS(SimulationDataGenerator data)
    {
        super(data);
    }

    public int execute()
    {
        while(!readyProcesses.isEmpty() || !data.isEmpty())
        {
            extendQueue();
            processorTimer++;
            if (!readyProcesses.isEmpty())
            {
                if (readyProcesses.get(0).calculate())
                {
                    readyProcesses.get(0).setFinishTime(processorTimer);
                    finishedProcesses.add(readyProcesses.get(0));
                    readyProcesses.remove(0);
                }
            }
        }
        return averageWaitingTime();
    }
}
