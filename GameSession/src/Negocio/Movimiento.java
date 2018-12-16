package Negocio; 
public class Movimiento { 
    public int x;
    public int y;
    public Player owner;
    public char type;
    public Movimiento(int x, int y, char type) {
        this.x = x;
        this.y = y; 
        this.type = type;
    }
    public Movimiento(int x, int y, Player owner, char type) {
        this.x = x;
        this.y = y;
        this.owner = owner;
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "GamePlay{" + "x=" + x + ", y=" + y + ", owner=" + owner + ", type=" + type + '}';
    }
    
}