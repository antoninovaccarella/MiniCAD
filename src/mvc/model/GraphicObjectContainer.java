package mvc.model;

import java.util.*;

public class GraphicObjectContainer implements Memento {
    private Map<Integer, List<Integer>> groups = new LinkedHashMap<>(); // < idGruppo, List<id dei vari oggetti> >
    private Map<Integer, GraphicObject> objectMap = new LinkedHashMap<>();

    public GraphicObjectContainer() {
    }

    public GraphicObjectContainer(Map<Integer, List<Integer>> groups, Map<Integer, GraphicObject> objectMap) {
        this.groups = new LinkedHashMap<>();
        this.objectMap = new LinkedHashMap<>();
        for(Map.Entry<Integer, List<Integer>> entry : groups.entrySet()) {
            Integer key = Integer.valueOf(entry.getKey());
            List<Integer> values = new ArrayList<>(entry.getValue());
            this.groups.put(key, values);
        }
        for (Map.Entry<Integer, GraphicObject> entry : objectMap.entrySet()) {
            Integer key = Integer.valueOf(entry.getKey());
            GraphicObject go = ((AbstractGraphicObject) entry.getValue()).clone();
            this.objectMap.put(key, go);
        }
    }

    public Integer addNewGroup(List<Integer> group) {
        Integer newID;
        if(groups.isEmpty())
            newID = 10000;
        else
            newID = (Integer) groups.keySet().toArray()[groups.keySet().size()-1]+1;
        groups.put(newID, group);
        return newID;
    }

    public Integer add(GraphicObject go) {
        Integer newID;
        if(objectMap.isEmpty())
            newID = 1;
        else
            newID = (Integer) objectMap.keySet().toArray()[objectMap.keySet().size()-1]+1;
        objectMap.put(newID, go);
        return newID;
    }//add

    public Map<Integer, GraphicObject> getObjectMap() {
        return objectMap;
    }

    public Map<Integer, List<Integer>> getGroupsMap() {
        return this.groups;
    }

    public void remove(Integer objectID) {
        objectMap.remove(objectID);
    }//remove

    public GraphicObject getObject(Integer objectID) {
        return objectMap.get(objectID);
    }

    public boolean groupExists(Integer groupID) {
        return groups.containsKey(groupID);
    }

    public List<Integer> getGroupElements (Integer groupID) {
        return groups.get(groupID);
    }

    public Set<Integer> getGroups() {
        return groups.keySet();
    }

    public void removeGroup(Integer groupID) {
        groups.remove(groupID);
    }

    public List<GraphicObject> getListGo() {
        return new ArrayList<>(objectMap.values());
    }

}
