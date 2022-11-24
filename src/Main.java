import core.CommandFactory;
import core.command.Command;
import core.interpreter.Parser;
import mvc.controller.GraphicObjectPanel;
import mvc.model.*;
import mvc.view.CircleObjectView;
import mvc.view.ImageObjectView;
import mvc.view.RectangleObjectView;

import javax.swing.*;
import java.awt.*;
import java.io.StringReader;
import java.util.Scanner;

public class Main {

    static Memento currentState; //il main è il caretaker per il memento

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        GraphicObjectPanel panel = new GraphicObjectPanel();
        panel.setPreferredSize(new Dimension(400,400));


        panel.installView(RectangleObject.class, new RectangleObjectView());
        panel.installView(CircleObject.class, new CircleObjectView());
        panel.installView(ImageObject.class, new ImageObjectView());

        jFrame.add(new JScrollPane(panel), BorderLayout.CENTER);
        jFrame.setTitle("MiniCAD - Interpreter");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JToolBar toolBar = new JToolBar();
        jFrame.add(toolBar, BorderLayout.NORTH);
        jFrame.pack();
        jFrame.setVisible(true);
        //INTERPRETER
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci il prossimo comando: ");
        String stringCommand = sc.nextLine();
        while(!stringCommand.equals("q")) {
            StringReader reader = new StringReader(stringCommand);
            Parser parser = new Parser(reader);
            CommandFactory factory =  CommandFactory.getInstance();
            Command command = factory.getCommand(parser.getRoot(), panel);
            JButton undoButton = new JButton("undo");
            if(command instanceof Originator) {
                currentState = ((Originator) command).saveState();
                final Memento finalCurrentState = currentState;
                undoButton.addActionListener(l -> {
                    ((Originator) command).undo(finalCurrentState);
                    toolBar.remove(undoButton);
                    toolBar.repaint();
                });
                toolBar.add(undoButton);
            }
            command.execute();
            System.out.println("Inserisci il prossimo comando: ");
            stringCommand = sc.nextLine();
            toolBar.remove(undoButton);
            toolBar.repaint();
        }//while
    }//main
}//Main
