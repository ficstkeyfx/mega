package gameobject;

import state.GameWorldState;
import effect.Animation;
import effect.CacheDataLoader;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class RedEyeBullet extends Bullet{
	
    private Animation forwardBulletAnim, backBulletAnim;
    
    public RedEyeBullet(float x, float y, GameWorldState gameWorld) {
            super(x, y, 30, 30, 1.0f, 10, gameWorld);
            forwardBulletAnim = CacheDataLoader.getInstance().getAnimation("redeyebullet");
            backBulletAnim = CacheDataLoader.getInstance().getAnimation("redeyebullet");
            backBulletAnim.flipAllImage();
    }

    
    // trả về đối tượng va chạm 
    @Override
    public Rectangle getBoundForCollisionWithEnemy() {
            // TODO Auto-generated method stub
            return getBoundForCollisionWithMap();
    }
    // Vẽ animation
    @Override
    public void draw(Graphics2D g2) {
            // TODO Auto-generated method stub
        // Vận tốc lớn hơn 0 thì vẽ forward không thì vẽ back
        if(getSpeedX() > 0){          
            forwardBulletAnim.Update(System.nanoTime());
            forwardBulletAnim.draw((int) (getPosX() - getGameWorld().camera.getPosX()), (int) getPosY() - (int) getGameWorld().camera.getPosY(), g2);
        }else{
            backBulletAnim.Update(System.nanoTime());
            backBulletAnim.draw((int) (getPosX() - getGameWorld().camera.getPosX()), (int) getPosY() - (int) getGameWorld().camera.getPosY(), g2);
        }
        //drawBoundForCollisionWithEnemy(g2);
    }
    // Update kế thừa từ cha
    @Override
    public void Update() {
            // TODO Auto-generated method stub
        super.Update();
    }
    
    @Override
    public void attack() {}

}
