package arjun.dsa.DP;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/**
 * Robot in a Grid: Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
 * The robot can only move in two directions, right and down, but certain cells are "off limits" such that
 * the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to
 * the bottom right.
 */
public class RobotsInGrid {
  static HashSet<Point> failedPoints = new HashSet<>();
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int rows = in.nextInt();
    int cols = in.nextInt();
    boolean maze[][] = new boolean[rows][cols];
    maze[0][1] = true;
    maze[1][0] = true;

    ArrayList<Point> path = new ArrayList<>();
    if (getPath(maze, maze.length - 1, maze[0].length - 1, path)) {
      System.out.println("found path");
    } else {
      System.out.println("not found path");
    }
  }

  private static boolean getPath(boolean[][] maze, int r, int c, ArrayList<Point> path) {
    if (r < 0 || c < 0 || maze[r][c]) {
      return false;
    }
    final Point point = new Point(r, c);
    if (failedPoints.contains(point)) {
      return false;
    }

    boolean isAtOrigin = r == 0 && c == 0;

    if (isAtOrigin || getPath(maze, r - 1, c, path) || getPath(maze, r, c - 1, path)) {
      path.add(point);
      return true;
    }
    failedPoints.add(point);
    return false;
  }
}