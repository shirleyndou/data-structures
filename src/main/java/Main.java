public class Main {

    public static void main(String[] args) {
        ConwayGameOfLife gol = new ConwayGameOfLife(3, 6);
        gol.setLive(0, 2);
        gol.setLive(1,2);
        gol.setLive(1,3);
        gol.setLive(1,4);

        gol.printCells();

        gol.nextGeneration();

        gol.printCells();

        gol.nextGeneration();

        //gol.printCells();


    }
}
