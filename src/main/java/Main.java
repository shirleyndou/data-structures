public class Main {

    public static void main(String[] args) {
        ConwayGameOfLife gol = new ConwayGameOfLife(3, 6);
        gol.printCells(); //prints out 1st generation
        gol.nextGeneration();
        gol.printCells(); //prints out second generation
        gol.nextGeneration();


    }
}
