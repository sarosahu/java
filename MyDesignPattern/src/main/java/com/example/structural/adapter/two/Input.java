package com.example.structural.adapter.two;

/**
 * up() and down() represent the pitch of the plane.
 * left() and right() represent the direction of the plane.
 */
public interface Input {
    public boolean up();
    public boolean down();
    public boolean left();
    public boolean right();
}
