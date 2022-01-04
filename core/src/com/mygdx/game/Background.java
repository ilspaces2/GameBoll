package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Background {
    private Texture bg;
    private Vector2 pos;
    public Background(){
        bg =new Texture("bg.jpg");
        pos =new Vector2(0,0);
    }

    public void render(SpriteBatch batch){
        batch.draw(bg,pos.x,pos.y);
    }


}
