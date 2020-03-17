/**Podstawowa klasa reprezentująca proces
 * Posiada 2 główne parametry: processingTime - czas fazy procesora, submitTime - czas zgłoszenia gotowości do wykonania
 * reszta pól to pola pomocnicze służące do obliczania średniego czasu oczekiwania i katalogowania procesów
 */

public class Process implements Comparable<Process>
{
    private static int idCounter = 1;
    private int id;
    private int processingTime;
    private int submitTime;
    private int remainingTime;
    private int finishTime;

    public Process(int processingTime, int submitTime)
    {
        id = idCounter;
        idCounter++;
        this.processingTime = processingTime;
        this.submitTime = submitTime;
        remainingTime = processingTime;
    }

    public String toString()
    {
        return "Process id: " + id + "\nSubmit time: " + submitTime + "ms\nProcessing time: " +
                processingTime +  "ms\n-------------------------\n";
    }

    public int compareTo(Process c)
    {
        return submitTime - c.submitTime;
    }

    public boolean calculate()
    {
        remainingTime--;
        if(remainingTime == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public int getSubmitTime()
    {
        return submitTime;
    }

    public void setFinishTime(int timer)
    {
        finishTime = timer;
    }

    public int getTotalWaitingTime()
    {
        int temp;
        temp = finishTime - submitTime - processingTime;
        return temp;
    }

    public int getRemainingTime()
    {
        return remainingTime;
    }

    public Process clone()
    {
        return new Process(processingTime, submitTime);
    }
}
