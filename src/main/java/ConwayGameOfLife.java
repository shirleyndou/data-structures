public class ConwayGameOfLife {

  int rows;
  int cols;
  int[][] grid;

    public ConwayGameOfLife(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new int[rows][cols];
    }

    /*The printCells function prints out the format of the cells
     in the grid of rows and columns*/


 public void printCells(){
        //Random random = new Random();
        for(int r =0; r<rows; r++)
        {
            StringBuilder deadOrAlive= new StringBuilder();

            for(int c=0; c<cols; c++)
            {
                //this.grid[r][c] = random.nextInt();
                if(this.grid[r][c] ==0) {
                    deadOrAlive.append("+ \t");
                }
                else{
                    deadOrAlive.append("# \t");
                }
            }
            System.out.println(deadOrAlive + "\n");
        }
        System.out.println("___________________");
    }


    public void setDead(int r, int c)
    {
        this.grid[r][c] =0;
    }

    public void setLive(int r, int c)
    {
        this.grid[r][c] =1;
    }

    /*This function checks to see if there are dead or alive neighbours*/
    public int isAliveOrDead(int r, int c)
    {
        if(r<0 || r>=rows){
            return 0;
        }
        if(c<0 || c>=cols)
        {
            return 0;
        }
        return this.grid[r][c];
    }

    public int countLiveNeighbours(int r, int c)
    {
        int count =0;

        count += isAliveOrDead(r-1, c-1); //moves from center to the left (r/x-axis) and to the top (c/y-axis)
        count += isAliveOrDead(r, c-1); //moves from center to thr top(y-axis)
        count += isAliveOrDead(r+1, c-1); // moves to the right (x-axis) and to the top

        count += isAliveOrDead(r-1, c);
        count += isAliveOrDead(r+1,c);

        count += isAliveOrDead(r-1, c+1); //to the right and downwards
        count += isAliveOrDead(r, c+1);
        count += isAliveOrDead(r+1, c+1);

        return count;
    }

    public int[][] nextGeneration()
    {
    int[][] newGrid = new int[rows][cols]; //creating a new grid because i cannot use the old grid to check the state of the cells
        for(int r=0; r<rows; r++)
        {
            for(int c=0; c<cols; c++)
            {
                int liveNeighbour= countLiveNeighbours(r,c);
                if(isAliveOrDead(r,c) ==1)
                {
                    if(liveNeighbour <2) //Any live cell with fewer than two live neighbors dies, as if caused by under population.
                    {
                        newGrid[r][c] =0; //cell dies
                    }
                    else if(liveNeighbour ==2 || liveNeighbour==3) //Any live cell with two or three live neighbors lives on to the next generation.
                    {
                        newGrid[r][c] =1; //cell lives
                    }
                    else if(liveNeighbour >3){ //Any live cell with more than three live neighbors dies, as if by overpopulation.
                        newGrid[r][c]=0; //cell dies
                    }
                    else if(liveNeighbour == 3) //Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
                    {
                        newGrid[r][c] =1; //cell lives
                    }
                }
            }
        }

        return this.grid = newGrid;
    }

}
