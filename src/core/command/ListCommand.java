package core.command;

import mvc.controller.GraphicObjectPanel;
import mvc.model.GraphicObject;

import java.util.List;
import java.util.Set;

public class ListCommand extends AbstractListCommand {

    private boolean groups;

    public ListCommand(boolean groups, GraphicObjectPanel panel) {
        super(panel);
        this.groups = groups;
    }


    @Override
    public Boolean execute() {
        if(!groups) { //caso ls all
           List<GraphicObject> objectList = panel.getGoContainer().getListGo();
           StringBuilder sb = new StringBuilder();
           sb.append("Object List: { ");
           for (int i=0; i< objectList.size(); i++) { // per avere in output es. {[1: rectangle], [2:circle]}
               sb.append("[");
               sb.append(i);
               sb.append(": ");
               sb.append(objectList.get(i).getType());
               sb.append("], ");
           }//for
            sb.append("}");
           System.out.println(sb.toString());
        }//if
        else { //caso ls groups
           Set<Integer> groups = panel.getGoContainer().getGroups();
           StringBuilder sb = new StringBuilder();
            sb.append("Group List: { ");
           for(Integer grpID: groups) {
                sb.append(grpID);
                sb.append(", ");
           }
           sb.append("}");
           System.out.println(sb.toString());
        }

        return true;
    }
}
