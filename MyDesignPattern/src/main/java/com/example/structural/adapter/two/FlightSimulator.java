package com.example.structural.adapter.two;

/**
 * This is a simple flight simulator design. A player can fly different kinds of planes.
 * To control the plane, we have mapped the input to some keys on the keyboards.
 * To go up and down --> mapped the up and down arrow keys
 * To go left and right --> mapped to left and right arrow keys.
 *
 * A player can also use a different kinds of input device to control the plane. e.g.
 * a player can use a game controller. That is why we want to design our game in such a
 * way that a player can use any kind of controller to control the plane. Therefore, we
 * don't want to hard code the game input to a keyboard. We want to have a design where
 * the game can take any kind of controller.
 *
 * Let's start the design.
 * -> Add input class (interface) and KeyBoard class
 * -> We designed the above and here game() will show how it works.
 *
 * Now lets say we want to port our game to the mobile platform and we would like to take
 * input from an accelerometer. Let's assume that the accelerometer class already exists
 * which is created by someone else. We want to use this in our platform.
 *
 * Let's create this class here just to demonstrate the design. However, it's assumed that
 * this class is already there to use.
 *
 * We have added AccelerometerAdapter class.
 * Here we have demonstrated the object adapter that uses an existing interface (Accelerometer) which is not
 * compatible with the target interface (Input).
 *
 *
 */
public class FlightSimulator {
    public static void game(Input input) {
        int count = 5;
        while (count != 0) {
            System.out.println("---------------->");
            if (input.up()) {
                System.out.println("Pitch up");
            } else if (input.down()) {
                System.out.println("Pitch down");
            } else {
                System.out.println("Plane is level");
            }

            if (input.left()) {
                System.out.println("Plane is turning left.");
            } else if (input.right()) {
                System.out.println("Plane is turning right.");
            } else {
                System.out.println("Plane is flying straight.");
            }

            --count;
        }
    }
    public static void main(String[] args) {
        System.out.println("\nNot Using adapter");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
        KeyBoard keyBoard = new KeyBoard();
        game(keyBoard);

        System.out.println("\nUsing object adapter");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");

        AccelerometerAdapter adapter = new AccelerometerAdapter();
        game(adapter);

        System.out.println("\nUsing class adapter");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");

        AcceleClassAdapter acceleClassAdapter = new AcceleClassAdapter();
        game(acceleClassAdapter);
    }
}
