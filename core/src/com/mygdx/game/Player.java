package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {
	private Texture texture;
	private Rectangle bounds;
	private Vector2 position;
	public Player() {
		texture = new Texture("assets/edge.png");
		position = new Vector2(MainClass.WIDTH / 2, 0);
		bounds = new Rectangle(position.x, position.y, texture.getWidth(), texture.getHeight());

	}

	public boolean collision(Rectangle ball){
		return ball.overlaps(bounds);
	}
	public void Lmove(){
		position.add(300*Gdx.graphics.getDeltaTime(),0);
		bounds.x = position.x;
		
	}
	public void Rmove(){
		position.add(-300*Gdx.graphics.getDeltaTime(),0);
		bounds.x = position.x;
		
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////// GETTER && SETTERS///////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	
	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public Texture getTexture() {
		return texture;
	}

	public Rectangle getRect() {
		return bounds;
	}



}
