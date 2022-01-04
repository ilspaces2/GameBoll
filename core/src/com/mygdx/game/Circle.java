package com.mygdx.game;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Circle  {
        private float radius;
        private Vector2 pos;



    public Circle (float x,float y ,float radius){

        ShapeRenderer shapeRenderer = new ShapeRenderer();
    shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
    shapeRenderer.setColor(Color.BLUE);
    shapeRenderer.circle(x,y,radius);
    shapeRenderer.end();
}

    public void moving(float xAmount, float yAmount){
        pos.x += xAmount;
        pos.y += yAmount;
    }

}
