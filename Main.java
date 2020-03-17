/**
 * Projekt na labolatoria z systemów operacyjnych
 * Symuluje obsługę procesów przez procesor
 * Bada średni czas oczekiwania procesów dla różnych algorytmów
 */

/**Klasa main
 * Zawiera pola statyczne pobierane jako dane wejściowe do generatora procesów oraz do algorytmów
 * W metodzie main() znajduje się projekt testu
 */

public class Main
{
    public static int minAmountOfProcesses = 100;
    public static int maxAmountOfProcesses = 100;
    public static int maxSubmitTime = 1000;

    public static int minProTimeSys = 1;
    public static int maxProTimeSys = 10;
    public static int minProTimeUs = 8;
    public static int maxProTimeUs = 40;

    public static int ROTquantum = 10;

    public static int numberOfTests = 100;

    public static void main(String [] args)
    {
        Algorithms fcfsAlgorithm;
        Algorithms sjfAlgorithm;
        Algorithms sjfxAlgorithm;
        Algorithms rotAlgorithm;

        SimulationDataGenerator data;

        int fcfsTotal = 0;
        int sjfTotal  = 0;
        int sjfxTotal = 0;
        int rotTotal  = 0;

        for (int i=0; i<numberOfTests; i++)
        {
            data = new SimulationDataGenerator();

            fcfsAlgorithm = new FCFS(data.clone());
            sjfAlgorithm  = new SJF(data.clone());
            sjfxAlgorithm = new SJFx(data.clone());
            rotAlgorithm  = new ROT(data.clone());

            fcfsTotal = fcfsTotal + fcfsAlgorithm.execute();
            sjfTotal  = sjfTotal  + sjfAlgorithm.execute();
            sjfxTotal = sjfxTotal + sjfxAlgorithm.execute();
            rotTotal  = rotTotal  + rotAlgorithm.execute();
        }

        System.out.println("FCFS: " + (fcfsTotal/numberOfTests));
        System.out.println("SJF: " + (sjfTotal/numberOfTests));
        System.out.println("SJFx : " + (sjfxTotal/numberOfTests));
        System.out.println("ROT: " + (rotTotal/numberOfTests));
    }
}
