package core.command;

import mvc.controller.GraphicObjectPanel;
import mvc.model.GraphicObject;

import java.util.List;

public class ListTypeCommand extends AbstractListCommand {

    private String objectType;

    public ListTypeCommand(String objectType, GraphicObjectPanel panel) {
        super(panel);
        this.objectType = objectType;
    }

    @Override
    public Boolean execute() {
        List<GraphicObject> objectList = panel.getGoContainer().getListGo();
        StringBuilder sb = new StringBuilder();
        sb.append("Objects of type ");
        sb.append(objectType);
        sb.append(": [");
        for(int i=0; i<objectList.size();i++) {
            if(objectType.equals(objectList.get(i).getType())) {
                sb.append(i);
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
        return true;
    }
}
