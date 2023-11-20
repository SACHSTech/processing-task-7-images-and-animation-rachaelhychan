import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

    /**
    * Images Moving Animation
    * @author: Rachael Chan
    */
	
    PImage imgBackground;
    PImage imgEmoji;
    PImage imgNerdEmoji;
    float fltCircleY;
    float fltCircleX;
    float fltEmojiX;
    float fltEmojiY;
    double dblEmojiX;
    double dblParabolaY;
    float fltNerdEmojiX;
    float fltNerdEmojiY;

    public void settings() {
        size(400, 400);
    }

    public void setup() {
        background(0);

        // upload background image
        imgBackground = loadImage("https://png.pngtree.com/background/20220718/original/pngtree-aesthetic-background-simple-hd-picture-image_1660220.jpg");

        // upload crying emoji and resize crying emoji to 50 x 50
        imgEmoji = loadImage("https://cdn-icons-png.flaticon.com/512/4160/4160714.png");
        imgEmoji.resize(50, 50);

        // upload nerd emoji and resize nerd emoji to 50 x 50
        imgNerdEmoji = loadImage("https://static-00.iconduck.com/assets.00/nerd-face-emoji-2048x2048-o74dq92a.png");
        imgNerdEmoji.resize(50, 50);

        // set starting positions of objects
        fltCircleY = 0;
        fltCircleX = 0;
        fltEmojiX = 0;
        fltEmojiY = 0;
        fltNerdEmojiX = 0;
        fltNerdEmojiY = 400;
    }

    public void draw() {

        // draw background image
        image(imgBackground, 0, 0);

        // Call the method drawCircle to draw a circle
        drawCircle();

        // Call the method drawNerd to draw the nerd emoji
        drawNerd();

        // Call the method drawCrying to draw the crying emoji
        drawCrying();

    }

    /**
    * Draws circle that moves from top left of screen to bottom right
    *
    * @param none
    * @return none
    *
    */
    public void drawCircle(){
        // draw circle 50 x 50
        ellipse(fltCircleX, fltCircleY, 50, 50);

        // allow for circle to move with each frame redraw
        fltCircleX = fltCircleX + 1;
        fltCircleY = fltCircleY + 1;

        // edge detection for y-axis and reset to original position
        if(fltCircleY > height) {
            fltCircleY = 0;
        }

        // edge detection for x-axis and reset to original position
        if(fltCircleX > width) {
            fltCircleX = 0;
        }

    }

    /**
    * Draws nerd emoji that moves from bottom left of screen to top right
    *
    * @param none
    * @return none
    *
    */
    public void drawNerd(){
        // draw nerd emoji
        image(imgNerdEmoji, fltNerdEmojiX, fltNerdEmojiY);

        // allow for nerd emoji to move from bottom left corner to top right corner with each frame redraw
        fltNerdEmojiX = fltNerdEmojiX + 1;
        fltNerdEmojiY = fltNerdEmojiY - 1;

        // edge detection for x-axis and reset to original position
        if(fltNerdEmojiX > width){
            fltNerdEmojiX = 0;
        }

        // edge detection for y-axis and reset to original position
        if(fltNerdEmojiY < 0){
            fltNerdEmojiY = 400;
        }
    }

    /**
    * Draws crying emoji that moves in a parabolic motion
    *
    * @param none
    * @return none
    *
    */
    public void drawCrying(){
        // draw crying emoji
        image(imgEmoji, fltEmojiX, fltEmojiY);

        // set x-axis movement 
        fltEmojiX = fltEmojiX + 1;

        // set y-axis movement for a parabolic shape
        dblEmojiX = (double) (fltEmojiX - 180) / 10.8;
        dblParabolaY = Math.pow(dblEmojiX, 2);
        fltEmojiY = (float) dblParabolaY;

        // set edge detection for crying emoji in y-axis
        if(fltEmojiY > height) {
            fltEmojiY = 0;
        }

        // set edge detection for crying emoji in x-axis
        if(fltEmojiX > width) {
            fltEmojiX = 0;
        }
    }

}