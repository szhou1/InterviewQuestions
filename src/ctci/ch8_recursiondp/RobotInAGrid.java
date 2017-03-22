package ctci.ch8_recursiondp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

public class RobotInAGrid {
    
    class Point {
        int row;
        int col;
        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    public ArrayList<Point> getPath(int [][] maze) {
        ArrayList<Point> path = new ArrayList<Point>();
        HashSet<Point> failedPoints = new HashSet<Point>();
        if(getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
            return path;
        }
        return null;
    }

    public boolean getPath(int [][] maze, 
            int row, int col, 
            ArrayList<Point> path, 
            HashSet<Point> failedPoints) {
//        System.out.println(row + " " + col);
        
        if(col < 0 || row < 0 || 
                col > maze.length-1 || 
                row > maze[0].length-1 || 
                maze[row][col] == 1) {
            return false;
        }
        
        Point p = new Point(row, col);
        
        if(failedPoints.contains(p)) {
            return false;
        }
        
        boolean isAtOrigin = (row == 0) && (col == 0);
        
        if(isAtOrigin || 
                getPath(maze, row, col - 1, path, failedPoints) ||
                getPath(maze, row + 1, col, path, failedPoints) ||
                getPath(maze, row - 1, col, path, failedPoints) ||
                getPath(maze, row, col + 1, path, failedPoints)) {
            path.add(p);
            return true;
        }
        
        failedPoints.add(p);
        return false;
        
    }
    
    @Test
    public void test() {
        int [][] maze = {
                {0, 1, 1, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0}
        };
        
        List<Point> path = getPath(maze);
        for(Point p : path) {
            System.out.println(p.row + ", " + p.col);
        }
    }
}
