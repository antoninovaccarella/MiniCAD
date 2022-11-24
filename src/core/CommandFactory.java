package core;

import core.command.*;
import core.interpreter.SyntaxException;
import core.interpreter.nonterminalexpression.*;
import mvc.controller.GraphicObjectPanel;

import java.util.ArrayList;
import java.util.List;

public class CommandFactory {

    private static CommandFactory instance;

    private CommandFactory() {
    }

    public static CommandFactory getInstance() {
        if(instance == null)
            instance = new CommandFactory();
        return instance;
    }

    public Command getCommand(NonTerminalExpression cmdExpression, GraphicObjectPanel panel) { //tra interprete e comandi
        if(!(cmdExpression instanceof CmdExpression)) {
            throw new SyntaxException("Unknown command.");
        }
        NonTerminalExpression expression = ((CmdExpression) cmdExpression).getNonTerminalExpression();
        if (expression instanceof CreateExpression) {
            CreateExpression createExpression = (CreateExpression) expression;
            if (createExpression.getTypeConstr() instanceof TypeConstrCircleExpression) {
                PosFloatExpression radius = ((TypeConstrCircleExpression) createExpression.getTypeConstr()).getPosFloat();
                PosExpression pos = createExpression.getPos();
                return new CreateCircleCommand(panel, pos.getPosX().getPosFloat(), pos.getPosY().getPosFloat(), radius.getPosFloat());
            }// secondo if
            if (createExpression.getTypeConstr() instanceof TypeConstrRectangleExpression) {
                PosExpression pos = createExpression.getPos();
                PosExpression dim = ((TypeConstrRectangleExpression) createExpression.getTypeConstr()).getPos();
                return new CreateRectangleCommand(panel, pos.getPosX().getPosFloat(), pos.getPosY().getPosFloat(),
                        dim.getPosX().getPosFloat(), dim.getPosY().getPosFloat());
            }// terzo if
            if (createExpression.getTypeConstr() instanceof TypeConstrImageExpression) {
                PosExpression pos = createExpression.getPos();
                String path = ((TypeConstrImageExpression) createExpression.getTypeConstr()).getPath();
                return new CreateImgCommand(panel, pos.getPosX().getPosFloat(), pos.getPosY().getPosFloat(), path);
            }// quarto if
        }//CREATE
        if (expression instanceof RemoveExpression) {
            return new RemoveCommand(((RemoveExpression) expression).getObjID().getObjectID(), panel);
        }//REMOVE
        if (expression instanceof MoveExpression) {
            Integer objectID = ((MoveExpression) expression).getObjectID().getObjectID();
            Float posX = ((MoveExpression) expression).getPos().getPosX().getPosFloat();
            Float posY = ((MoveExpression) expression).getPos().getPosY().getPosFloat();
            Boolean moveOff = ((MoveExpression) expression).isMoveOff();
            return new MoveCommand(objectID, posX, posY, moveOff, panel);
        }//MOVE
        if(expression instanceof ScaleExpression) {
            Integer objectID = ((ScaleExpression) expression).getObjID().getObjectID();
            Float scale = ((ScaleExpression) expression).getPosFloat().getPosFloat();
            return new ScaleCommand(objectID, scale, panel);
        }//SCALE
        if(expression instanceof ListExpression) {
            Boolean groups = ((ListExpression) expression).isGroups();
            return new ListCommand(groups, panel);
        }//LIST ALL e LIST GROUPS
        if (expression instanceof ListObjectIDExpression) {
            Integer objectID = ((ListObjectIDExpression) expression).getObjID().getObjectID();
            return new ListObjectCommand(objectID, panel);
        }//LIST ObjectID
        if (expression instanceof ListTypeExpression) {
            String objectType = ((ListTypeExpression) expression).getTypeExpression().getType();
            return new ListTypeCommand(objectType, panel);
        }//LIST type
        if (expression instanceof GroupExpression) {
            List<Integer> listID = new ArrayList<>();
            for(ObjIDExpression objID: ((GroupExpression) expression).getListID().getObjectList()) {
                listID.add(objID.getObjectID());
            }
            return new GroupCommand(listID, panel);
        }//GROUP
        if (expression instanceof UnGroupExpression) {
            Integer groupID = ((UnGroupExpression) expression).getObjID().getObjectID();
            return new UngroupCommand(groupID, panel);
        }//UNGROUP
        if (expression instanceof AreaExpression) {
            return new AreaCommand(panel);
        }//AREA ALL
        if (expression instanceof AreaObjectIDExpression) {
            Integer objID = ((AreaObjectIDExpression) expression).getObjID().getObjectID();
            return new AreaObjectCommand(objID, panel);
        }//Area Object id
        if (expression instanceof AreaTypeExpression) {
            String objectType = ((AreaTypeExpression) expression).getTypeExpression().getType();
            return new AreaTypeCommand(objectType, panel);
        }//AREA type
        if (expression instanceof PerimeterExpression) {
            return new PerimeterCommand(panel);
        }//PERIMETER ALL
        if (expression instanceof PerimeterObjectIDExpression) {
            Integer objectID = ((PerimeterObjectIDExpression) expression).getObjID().getObjectID();
            return new PerimeterObjectCommand(objectID, panel);
        }//PERIMETER object id
        if (expression instanceof PerimeterTypeExpression) {
            String objectType = ((PerimeterTypeExpression) expression).getTypeExpression().getType();
            return new PerimeterTypeCommand(objectType, panel);
        }//PERIMETER type
        throw new SyntaxException("Unknown command.");
    }//getCommand
}
