package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Brick {


	Texture texture;
	Vector2 position;
	Rectangle bounds;

	public Brick() {
		position = new Vector2();
		texture = new Texture("assets/brick.png");
		bounds = new Rectangle(position.x, position.y, texture.getWidth(), texture.getHeight());
	}

	public boolean collision(Rectangle ball) {
		return ball.overlaps(bounds);

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////// GETTER && SETTERS///////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void setPosition(float x, float y) {
		this.position.x = x;
		this.position.y = y;
		bounds.x = x;
		bounds.y = y;
	}

	public Vector2 getPosition() {
		return position;
	}

	public Texture getTexture() {
		return texture;
	}
	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public Rectangle getBounds() {
		return bounds;
	}
	public int getHeight() {
		return this.texture.getHeight();
	}
}
