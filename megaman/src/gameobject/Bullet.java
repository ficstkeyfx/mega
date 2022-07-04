package gameobject;

import state.GameWorldState;
import java.awt.Graphics2D;

public abstract class Bullet extends ParticularObject {

    public Bullet(float x, float y, float width, float height, float mass, int damage, GameWorldState gameWorld) {
            super(x, y, width, height, mass, 1, gameWorld);
            setDamage(damage);
    }
    
    public abstract void draw(Graphics2D g2d);

    public void Update(){
        super.Update();
        // Di chuyển viên đạn
        setPosX(getPosX() + getSpeedX());
        setPosY(getPosY() + getSpeedY());
        // Xử lý va chạm đạn
        ParticularObject object = getGameWorld().particularObjectManager.getCollisionWidthEnemyObject(this);
        if(object!=null && object.getState() == ALIVE){   // Đối tượng khác null và đang alive
            setBlood(0); // Làm mất đạn trên màn hình
            object.beHurt(getDamage()); // object bị nhận damage và bị trừ máu
            System.out.println("Bullet set behurt for enemy");
        }
    }
    
}
