package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class MainClass extends ApplicationAdapter {
	public static final int WIDTH = 650;
	public static final int HEIGHT = 480;
	private final int BRICK_AMOUNT = 52;
	private final int BRICKS_IN_ROW = 13;
	private SpriteBatch batch;
	private Ball ball;
	private Player player;
	private Array<Brick> brick;
	private int j=0,k=0;
	
	@Override
	public void create() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		batch = new SpriteBatch();
		ball = new Ball();
		brick = new Array<Brick>(10);
		player = new Player();
		for (int i = 0; i < BRICK_AMOUNT; i++) {
			if(j==BRICKS_IN_ROW)
			{
			j=0;
			 k = k+31;
			}
			brick.add(new Brick());
			brick.get(i).setPosition(j * brick.get(i).getTexture().getWidth(), HEIGHT-k);
			j++;
		}

	}

	public void handleInput() {

		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			player.Lmove();
		}
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			player.Rmove();
		}

	}

	public void update() {
		ball.update();
		for (int i = 0; i < brick.size; i++) {
		if (brick.get(i).collision(ball.getBounds())) {
			ball.setVerticalVelocity(ball.getVerticalVelocity()-10);
				brick.get(i).setPosition(700, 0);
				brick.removeIndex(i);
			}
		}
		if (player.collision(ball.getBounds())) {
			ball.setVerticalVelocity(ball.getVerticalVelocity()+10);
		}
		if(ball.getPositon().y<-10)
		{
		ball.getPositon().x=player.getPosition().x;
		ball.getPositon().y=player.getPosition().y+player.getTexture().getHeight();
		ball.lifes--;
		if(ball.lifes<=0)
		{
			Gdx.app.exit();
		}
		
		
		}
		
	}

	
	@Override
	public void render() {
		update();
		handleInput();
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(ball.getTexture(), ball.getPositon().x, ball.getPositon().y);

		for (int i = 0; i < brick.size; i++) {
			batch.draw(brick.get(i).getTexture(), brick.get(i).getPosition().x, brick.get(i).getPosition().y);
		}
		batch.draw(player.getTexture(), player.getPosition().x, player.getPosition().y);
		batch.end();
		
		System.out.println(ball.getBounds());
		System.out.println(ball.getPositon());
	}

	@Override
	public void dispose() {
		batch.dispose();
	}
}
