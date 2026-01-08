package designpattern.sturucturalpattern;

/*
class Tree{
    // keep changing
    int x;
    int y;

    // they are constant
    int name;
    int color;

    Tree(int x, int y, int name, int color) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.color = color;
    }

    void plant(){}
}*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeType{
    String name;
    String color;
    TreeType(String name, String color){
        this.name = name;
        this.color = color;
    }
}

class Tree{
    // keep changing
    int x;
    int y;

    TreeType treeType;

    Tree(int x, int y, TreeType treeType) {
        this.x = x;
        this.y = y;
        this.treeType = treeType;
    }

    void draw(){
        System.out.println("Drawing tree at " + x + ", " + y+" with name"+treeType.name+" and color"+treeType.color);
    }
}

class Forest{
    List<Tree> trees=new ArrayList<>();

    void plantTree(int x, int y,String name, String color){
        // why to create new object again and again so use map in factory
        // TreeType treeType=new TreeType(name,color);
        //trees.add(new Tree(x,y,0,treeType));

        trees.add(new Tree(x,y,TreeFactory.getTreeType(name,color)));
    }

    void drawTree(){
        for(Tree tree:trees){
            tree.draw();
        }
    }
}

class TreeFactory{
    static Map<String, TreeType> treeTypeMap=new HashMap<String, TreeType>();

    static TreeType getTreeType(String name, String color){
        String key=name+"_"+color;
        if(treeTypeMap.containsKey(key)){
            return treeTypeMap.get(key);
        }
        TreeType treeType=new TreeType(name,color);
        treeTypeMap.put(key,treeType);
        return treeType;
    }
}

public class FlyweightPattern {

    public static void main(String[] args) {
        Forest forest=new Forest();
        for(int i=1;i<10000;i++){
            forest.plantTree(i,i+1,"banana","green");
        }
        forest.drawTree();
    }
}
