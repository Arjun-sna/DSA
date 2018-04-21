/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa.trees;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author arjun
 */

/**
 * Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of
 projects, where the second project is dependent on the first project). All of a project's dependencies
 must be built before the project is. Find a build order that will allow the projects to be built. If there
 is no valid build order, return an error.
 EXAMPLE
 Input:
 projects: a, b, c, d, e, f
 dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
 Output: f, e, a, b, d, c
 * @author arjun
 */
public class BuildOrder {
  public static void main(String[] args) {
    String[] projects = new String[] {"a", "b", "c", "d", "e", "f"};
    String[][] dependencies =
        new String[][] {{"a", "d"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"}};
    Graph g = buildGraph(projects, dependencies);
    Project[] ordered = orderProjects(g);
    for (Project project : ordered) {
      System.out.println(project.name);
    }
  }

  public static Graph buildGraph(String[] projects, String[][] dependencies) {
    Graph g = new Graph();
    for (String project : projects) {
      g.getOrCreateNode(project);
    }
    for (String[] dependency : dependencies) {
      String parent = dependency[0];
      String child = dependency[1];
      g.addEdge(parent, child);
    }
    return g;
  }

  private static Project[] orderProjects(Graph g) {
    Project[] ordered = new Project[g.projects.size()];
    int endOfList = addNonDependent(ordered, g.projects, 0);
    int tobeprocessed = 0;
    while (tobeprocessed < ordered.length) {
      Project current = ordered[tobeprocessed];
      if (current == null) {
        return null;
      }
      current.children.forEach(child -> {
        child.decrementDependency();
      });
      endOfList = addNonDependent(ordered, current.children, endOfList);
      tobeprocessed++;
    }
    return ordered;
  }

  private static int addNonDependent(Project[] ordered, ArrayList<Project> projects, int index) {
    for (Project project : projects) {
      if (project.dependenciesCount == 0) {
        ordered[index++] = project;
      }
    }
    return index;
  }

  private static class Graph {
    ArrayList<Project> projects = new ArrayList<>();
    public HashMap<String, Project> map = new HashMap<String, Project>();

    public Project getOrCreateNode(String name) {
      if (!map.containsKey(name)) {
        Project p = new Project();
        p.name = name;
        projects.add(p);
        map.put(name, p);
      }
      return map.get(name);
    }

    public void addEdge(String p1, String p2) {
      Project start = getOrCreateNode(p1);
      Project end = getOrCreateNode(p2);
      start.addEdge(end);
    }
  }

  private static class Project {
    public String name;
    public int dependenciesCount = 0;
    public ArrayList<Project> children = new ArrayList<>();
    private final HashMap<String, Project> map = new HashMap<>();

    private void addEdge(Project end) {
      if (!map.containsKey(end)) {
        children.add(end);
        map.put(end.name, end);
        end.incrementDependency();
      }
    }

    private void incrementDependency() {
      dependenciesCount++;
    }

    private void decrementDependency() {
      dependenciesCount--;
    }
  }
}
