import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Question 2 in Maman11
 * Code written by Natanel Fishman.
 *
 * This JavaFX application displays a drawing consisting of a matrix of lines with a space of 10 pixels between lines
 * The size is 20X20 because of the picture in the Maman.
 * It randomly fills 10% of the cells(slots) ensuring that the random operation does not repeat the same square twice.
 */

public class MyProjectController {

    // Reference to the Canvas element in the FXML file
    @FXML
    private Canvas canv;
    // GraphicsContext for drawing on the Canvas
    private GraphicsContext gc;
    // Size of the grid
    // It is possible to adjust the number of matrix squares by dividing size of the canvas/10px, 
    // The class chat said that this is not necessary.
    final int SIZE = 20;
    // Number of marked squares to get 10%. Equals 40, I did it as a formula for easier use.
    final int MARK = (int) (0.1 * SIZE * SIZE); // 10% of the total cells formula
    // Width of each square in the grid
    final int WIDTH = 10;
    
    // Array to keep track of filled cells
    private boolean[][] filledCells;
    
    // Method called when the FXML file is loaded
    public void initialize() {
        // Initialize the GraphicsContext
        gc = canv.getGraphicsContext2D();
    }

    // Method to handle button click event
    @FXML
    void drawPressed(ActionEvent event) {
        // Clear the canvas before drawing
        gc.clearRect(0, 0, canv.getWidth(), canv.getHeight());
        // Clear filledCells array
        filledCells = new boolean[SIZE][SIZE];
        
        // Draw grid lines
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                gc.setFill(Color.BLACK);
                gc.strokeRect(i * WIDTH, j * WIDTH, WIDTH, WIDTH);
            }
        }
        
        // Fill 10% random squares
        int filledCount = 0;
        Random random = new Random();
        while (filledCount < MARK) {
            // Generate random coordinates
            int randomX = random.nextInt(SIZE);
            int randomY = random.nextInt(SIZE);
            
            // Check if the cell is already filled
            if (!filledCells[randomX][randomY]) {
                // Fill the square at the random coordinates
                gc.setFill(Color.BLACK);
                gc.fillRect(randomX * WIDTH, randomY * WIDTH, WIDTH, WIDTH);
                filledCells[randomX][randomY] = true;
                filledCount++;
            }
        }
    }
}