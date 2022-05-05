import java.awt.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame("Gravity Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        MyPanel myPanel = new MyPanel();
        frame.setContentPane(myPanel);
        myPanel.setBackground(new Color(0f, 0f, 0f, 0.08f));
        frame.setVisible(true);
    }
}
class MyPanel extends JPanel implements Runnable{
    java.util.List<Planet> planets = new ArrayList<>();
    public MyPanel(){
        Planet sun = new Planet(80, new Color(250, 253, 15), 23, 500, 500, 0, 0);
        planets.add(sun);
        Planet brown = new Planet(20, new Color(101, 67, 33), 0.25, 150, 150, 0.9, -0.7);
        planets.add(brown);
        Planet red = new Planet(30, new Color(255, 0, 0), 0.4, 750, 750, -1.2, 1.2);
        planets.add(red); 
        Planet green = new Planet(20, new Color(0, 0, 255), 0.25, 780, 150, 0.65, 1.3);
        planets.add(green);
        new Thread(this).start();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(Planet planet: planets){
            planet.draw(g);
        }
    }
    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(5);
            } catch(Exception e){
                return;
            }
            for(Planet planet: planets){
                planet.moob(planets);
            }
            double deltaX = planets.get(0).xPos-500;
            double deltaY = planets.get(0).yPos-500;
            for(Planet planet: planets){
                planet.xPos -= deltaX;
                planet.yPos -= deltaY;
            }
            repaint();
        }
    }
}