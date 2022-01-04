package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Ball  {
    private Texture ball;
    private Vector2 pos;
    private int speed,counter;
    private boolean keyVertical = true, keyHorizontal = true, lose;
    private Sound dropSound = Gdx.audio.newSound(Gdx.files.internal("dropSound.mp3"));
    private Sound loseSound = Gdx.audio.newSound(Gdx.files.internal("loseSound.mp3"));


    public Ball() {
        ball = new Texture("circle_PNG79 (1).png");
        pos = new Vector2(Platform.getPosPlatform().x+35, Platform.getPosPlatform().y+40);
        speed = 7;
        lose=false;

    }
    public int getCounter(){
        return this.counter;
    }

    public boolean getLose(){
        return this.lose;
    }

    public void flyBall() {
        if (pos.y<0){
            lose=true;
            loseSound.play();
        }

        if (pos.y > -5 && keyVertical) {  //мяч летит вниз
            pos.y -= speed;
            if (pos.y < Platform.getPosPlatform().y + 40 && pos.x + 28 >= Platform.getPosPlatform().x && pos.x <= Platform.getPosPlatform().x + 88) {
                dropSound.play();
                counter++;
                keyVertical = false;
            }
        }
        if (pos.y < 600 && !keyVertical) {  //мяч летит вверх
            pos.y += speed;
            if (pos.y > 550) keyVertical = true;
        }


    if (pos.x > -10 && keyHorizontal && pos.y > 0) {  //мяч летит вправо
        pos.x += speed;
        if (pos.x > 740) keyHorizontal = false;
    }


            if (pos.x < 800 && !keyHorizontal && pos.y > 0) {  //мяч летит влево
                pos.x -= speed;
                if (pos.x < 0) keyHorizontal = true;
            }

    }


    public void render(SpriteBatch batch) {
        batch.draw(ball, pos.x, pos.y);
    }


}
