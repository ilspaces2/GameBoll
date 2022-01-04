package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
   private SpriteBatch batch;
    private Background bg;
    private Ball ball;
    private Platform platform;
    private BitmapFont font;
    private Record record;
    @Override
    public void create() {
        bg = new Background();
        platform = new Platform();
        ball = new Ball();
        font = new BitmapFont();
        font.setColor(0, 0, 0, 1);
        batch = new SpriteBatch();
        record = new Record();


    }

    @Override
    public void render() {
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        update();

        batch.begin();
        bg.render(batch);
        font.draw(batch, "Score: " + ball.getCounter(), 50, 550);
        font.draw(batch, "Record: " + record.readerRecord(), 50, 570);
        ball.render(batch);
        platform.render(batch);
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) ball = new Ball();       //Рестарт мячика. Просто создаем новый
        batch.end();

    }

    public void update() {
        platform.moving();
        if (!ball.getLose()) {
            ball.flyBall();
            if (record.readerRecord() < ball.getCounter())
                record.writerRecord(ball.getCounter());
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
//        ball.dispose();
//        bg.dispose();
//        platform.dispose();
    }



}
