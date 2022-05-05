import java.awt.*;
public class Planet {
    int radius;
    Color color;
    double gravity;
    double xPos;
    double yPos;
    double xSpeed;
    double ySpeed;
    double gwabitasonalQwanstunt = 50;
    public Planet(int radius,  Color color, double gravity, double xPos, double yPos, double xSpeed, double ySpeed){
        this.radius = radius;
        this.color = color;
        this.gravity = gravity;
        this.xPos = xPos;
        this.yPos = yPos;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed; 
    }
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval((int)xPos-radius, (int)yPos-radius, radius*2, radius*2);
    }
    public void moob(java.util.List<Planet> planets){
        for(Planet planet: planets){
            if(planet == this){
                continue;
            }
            double distance = Math.sqrt(Math.pow(planet.xPos - xPos, 2) + Math.pow(planet.yPos - yPos, 2));
            double theta = Math.acos((planet.xPos-xPos)/distance);
            double force = gwabitasonalQwanstunt*gravity*planet.gravity/(distance*distance);
            xSpeed += force * Math.cos(theta)/gravity;
            ySpeed += force * Math.sin(theta)/gravity * (yPos < planet.yPos ? 1 : -1);
        }
        xPos += xSpeed;
        yPos += ySpeed;
    }
} 
