package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Platform {
    private Texture platform;
    static private Vector2 pos;
    private int speed;

    public Platform() {
        platform = new Texture("bronze_tile_walkway.png" );
        pos = new Vector2(350, 1);
        speed = 4;
    }

    static public Vector2 getPosPlatform() {
        return pos;
    }

    public void moving() {
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && pos.x != 0) pos.x -= speed;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && pos.x != 660) pos.x += speed;
    }

    public void render(SpriteBatch batch) {
        batch.draw(platform, pos.x, pos.y);
    }

}
