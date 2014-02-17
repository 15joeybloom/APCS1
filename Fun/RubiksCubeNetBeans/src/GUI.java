/**
 * @author Joey Bloom
 * Assignment #
 *
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;

@SuppressWarnings("StaticNonFinalUsedInInitialization")
public class GUI extends JFrame
{
    private class PenListener implements ActionListener
    {
        private Color color;
        private Cursor cursor;
        public PenListener(Color c, Cursor s)
        {
            color = c;
            cursor = s;
        }
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(editMode.isSelected())
            {
                penColor = color;
                selected = (JRadioButton) e.getSource();
                setCursor(cursor);
            }
        }
    }
    /**
     * when a square is clicked:
     * if in edit mode:
     *      get the square that was clicked
     *      set its background to the current pen color
//      *      if the pen color is black:
//      *          set the border to white
//      *      else
//      *          set the border to black
     *      set the message label to "Building Cube"
     */
    private class SquareListener implements MouseListener
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            if(editMode.isSelected())
            {
                JPanel src = (JPanel) e.getSource();
                src.setBackground(penColor);
//                 if(penColor.equals(Color.black))
//                 {
//                     src.setBorder(
//                         BorderFactory.createLineBorder(
//                         Color.white));
//                 }
//                 else
//                 {
//                     src.setBorder(
//                         BorderFactory.createLineBorder(
//                         Color.black));
//                 }
                messageLabel.setText("Building Cube");

            }
        }
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
    }
    /**
     * In edit mode:
     * move buttons are disabled
     * preset box is disabled
     * go button is disabled
     * scramble is disabled
     * cursor is set to penColor
     * message is set to "Building Cube"
     */
    private class EditListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            setEnabledMoveButtons(false);
            presets.setEnabled(false);
            go.setEnabled(false);
            scramble.setEnabled(false);
            selected.doClick();
            messageLabel.setText("Building Cube");

//            if(penColor.equals(Color.blue))
//                setCursor(cursors[0]);
//
//            else if(penColor.equals(Color.red))
//                setCursor(cursors[1]);
//
//            else if(penColor.equals(Color.yellow))
//                setCursor(cursors[2]);
//
//            else if(penColor.equals(Color.green))
//                setCursor(cursors[3]);
//
//            else if(penColor.equals(Color.orange))
//                setCursor(cursors[4]);
//
//            else if(penColor.equals(Color.white))
//                setCursor(cursors[5]);
//
//            else if(penColor.equals(Color.black))
//                setCursor(cursors[6]);
//
//            else
//                setCursor(Cursor.DEFAULT_CURSOR);

        }
    }
    /**
     * In play mode:
     * try
     *      update cube
     * if fail
     *      return to edit mode
     *      display error message
     * if succeed
     * move buttons are enabled
     * preset box is enabled
     * go button is enabled
     * scramble button is enabled
     * //cube is displayed for security
     * cursor is set to default
     * message label is set to "cube build successful: begin playing"
     */
    private class PlayListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                updateCube();
            }
            catch(NoSuchPieceException ex)
            {
                editMode.doClick();
                messageLabel.setText(ex.getMessage());
                return;
            }
            setEnabledMoveButtons(true);
            presets.setEnabled(true);
            go.setEnabled(true);
            scramble.setEnabled(true);
//            displayCube();
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            messageLabel.setText("Cube build successful: Begin playing!");
        }
    }
    /**
     * When a move button is clicked:
     * execute the move
     * display the cube
     */
    private class MoveListener implements ActionListener
    {
        @Override
        @SuppressWarnings("ConvertToStringSwitch")
        public void actionPerformed(ActionEvent e)
        {
            String move = ((JButton)e.getSource()).getText();
            if(move.equals("R ")) {cube.r();}
            else if(move.equals("Ri")) {cube.ri();}
            else if(move.equals("R2")) {cube.r2();}
            else if(move.equals("U ")) {cube.u();}
            else if(move.equals("Ui")) {cube.ui();}
            else if(move.equals("U2")) {cube.u2();}
            else if(move.equals("F ")) {cube.f();}
            else if(move.equals("Fi")) {cube.fi();}
            else if(move.equals("F2")) {cube.f2();}
            else if(move.equals("L ")) {cube.l();}
            else if(move.equals("Li")) {cube.li();}
            else if(move.equals("L2")) {cube.l2();}
            else if(move.equals("D ")) {cube.d();}
            else if(move.equals("Di")) {cube.di();}
            else if(move.equals("D2")) {cube.d2();}
            else if(move.equals("B ")) {cube.b();}
            else if(move.equals("Bi")) {cube.bi();}
            else if(move.equals("B2")) {cube.b2();}
            else
            {
                System.err.println("Uh-oh");
            }

            displayCube();
        }
    }
    /**
     * When go is clicked:
     * get the preset selection
     * set the cube to the preset
     * display the cube
     */
    private class GoListener implements ActionListener
    {
        @Override
        @SuppressWarnings("ConvertToStringSwitch")
        public void actionPerformed(ActionEvent e)
        {
            String selection =
                (String) presets.getSelectedItem();
            if(selection.equals("Solved"))
            {
                cube = new RubiksCube();
            }
            else if(selection.equals("Checkerboard"))
            {
                cube = new RubiksCube(RubiksCube.RubiksCubeState.CHECKERBOARD);
            }
            else if(selection.equals("Lines"))
            {
                cube = new RubiksCube(RubiksCube.RubiksCubeState.LINES);
            }
            displayCube();
        }
    }
    /**
     * When scramble is clicked:
     * scramble the cube
     * display scrambled cube
     */
    private class ScrambleListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            cube = new RubiksCube(new Random());
            displayCube();
        }
    }
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new GUI("Rubik's Cube by Boom");
            }
        });
    }

    private static Image bluePic;
    private static Image redPic;
    private static Image yellowPic;
    private static Image greenPic;
    private static Image orangePic;
    private static Image whitePic;
//     private static Image blackPic;
    static
    {
        try{bluePic = ImageIO.read(new File("images\\blue.jpg"));}
        catch(IOException e){bluePic = null;}

        try{redPic = ImageIO.read(new File("images\\red.jpg"));}
        catch(IOException e){redPic = null;}

        try{yellowPic = ImageIO.read(new File("images\\yellow.jpg"));}
        catch(IOException e){yellowPic = null;}

        try{greenPic = ImageIO.read(new File("images\\green.jpg"));}
        catch(IOException e){greenPic = null;}

        try{orangePic = ImageIO.read(new File("images\\orange.jpg"));}
        catch(IOException e){orangePic = null;}

        try{whitePic = ImageIO.read(new File("images\\white.jpg"));}
        catch(IOException e){whitePic = null;}

//         try{blackPic = ImageIO.read(new File("images/black.jpg"));}
//         catch(IOException e){blackPic = null;}
    }

    private JRadioButton blue;
    private JRadioButton red;
    private JRadioButton yellow;
    private JRadioButton green;
    private JRadioButton orange;
    private JRadioButton white;
//     private JRadioButton black;
    private JRadioButton selected;
    private ButtonGroup colorButtons;

    private Color penColor;
    private static final Cursor[] cursors;
    static
    {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Point hotspot = new Point(0,0);
        cursors = new Cursor[6];
        cursors[0] = tk.createCustomCursor(
                    bluePic, hotspot, "blue");
        cursors[1] = tk.createCustomCursor(
                    redPic, hotspot, "red");
        cursors[2] = tk.createCustomCursor(
                    yellowPic, hotspot, "yellow");
        cursors[3] = tk.createCustomCursor(
                    greenPic, hotspot, "green");
        cursors[4] = tk.createCustomCursor(
                    orangePic, hotspot, "orange");
        cursors[5] = tk.createCustomCursor(
                    whitePic, hotspot, "white");
//         cursors[6] = tk.createCustomCursor(
//                     blackPic, hotspot, "black");
    }

    private JPanel[] lFace;
    private JPanel[] uFace;
    private JPanel[] fFace;
    private JPanel[] dFace;
    private JPanel[] rFace;
    private JPanel[] bFace;
    private JPanel[][] faces;
    private JPanel[] facePanels;

    private JRadioButton editMode;
    private JRadioButton playMode;
    private ButtonGroup modeButtons;
    private JPanel modeButtonPanel;

    private JButton[][] moveButtons;
    private JPanel moveButtonsPanel;
    private JComboBox presets;
    private JButton go;
    private JButton scramble;

    //top-level components
    private JPanel cubeUI;
    private JLabel messageLabel;
    private JPanel colorButtonsPanel;
    private JPanel playPanel;

    private RubiksCube cube;

    public GUI()
    {
        this("");
    }
    public GUI(String title)
    {
        super(title);
        setLayout(new BorderLayout());
        setSize(600,600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //blue is default selection
        blue = new JRadioButton(new ImageIcon(bluePic), true);
        red = new JRadioButton(new ImageIcon(redPic));
        yellow = new JRadioButton(new ImageIcon(yellowPic));
        green = new JRadioButton(new ImageIcon(greenPic));
        orange = new JRadioButton(new ImageIcon(orangePic));
        white = new JRadioButton(new ImageIcon(whitePic));
//         black = new JRadioButton(new ImageIcon(blackPic));
        selected = blue;
        colorButtons = new ButtonGroup();
        blue.addActionListener(new PenListener(Color.blue,cursors[0]));
        red.addActionListener(new PenListener(Color.red, cursors[1]));
        yellow.addActionListener(new PenListener(Color.yellow, cursors[2]));
        green.addActionListener(new PenListener(Color.green, cursors[3]));
        orange.addActionListener(new PenListener(Color.orange, cursors[4]));
        white.addActionListener(new PenListener(Color.white, cursors[5]));
//         black.addActionListener(new PenListener(Color.black, cursors[6]));
        colorButtons.add(blue);
        colorButtons.add(red);
        colorButtons.add(yellow);
        colorButtons.add(green);
        colorButtons.add(orange);
        colorButtons.add(white);
//         colorButtons.add(black);

        //blue is default selection
        penColor = Color.blue;

        faces = new JPanel[6][];
        for(int i = 0; i < 6; i++)
        {
            faces[i] = new JPanel[9];
            for(int j = 0; j < 9; j++)
            {
                faces[i][j] = new JPanel();
                faces[i][j].setBorder(
                    BorderFactory.createLineBorder(
                    Color.black));
                if(j != 4)
                {
                    faces[i][j].addMouseListener(
                        new SquareListener());
                }
            }
        }
        lFace = faces[0];
        uFace = faces[1];
        fFace = faces[2];
        dFace = faces[3];
        rFace = faces[4];
        bFace = faces[5];
        for(JPanel sq : lFace)
        {
            sq.setBackground(Color.white);
        }
        for(JPanel sq : uFace)
        {
            sq.setBackground(Color.blue);
        }
        for(JPanel sq : fFace)
        {
            sq.setBackground(Color.red);
        }
        for(JPanel sq : dFace)
        {
            sq.setBackground(Color.green);
        }
        for(JPanel sq : rFace)
        {
            sq.setBackground(Color.yellow);
        }
        for(JPanel sq : bFace)
        {
            sq.setBackground(Color.orange);
        }

        facePanels = new JPanel[6];
        for(int i = 0; i < 6; i++)
        {
            facePanels[i] = new JPanel(new GridLayout(3,3));
            for(JPanel sq : faces[i])
            {
                facePanels[i].add(sq);
            }
        }

        //edit mode is default selection
        editMode = new JRadioButton("Edit Mode",true);
        playMode = new JRadioButton("Play Mode");
        editMode.addActionListener(new EditListener());
        playMode.addActionListener(new PlayListener());
        modeButtons = new ButtonGroup();
        modeButtons.add(editMode);
        modeButtons.add(playMode);
        modeButtonPanel = new JPanel();
        modeButtonPanel.setBorder(BorderFactory.
            createEmptyBorder(25,0,0,0));
        modeButtonPanel.add(editMode);
        modeButtonPanel.add(playMode);

        moveButtons = new JButton[6][3];
        moveButtons[0][0] = new JButton("U ");
        moveButtons[1][0] = new JButton("D ");
        moveButtons[2][0] = new JButton("R ");
        moveButtons[3][0] = new JButton("L ");
        moveButtons[4][0] = new JButton("F ");
        moveButtons[5][0] = new JButton("B ");

        for(int i = 0; i < 6; i++)
        {
            moveButtons[i][1] = new JButton(
                moveButtons[i][0].getText().charAt(0) + "i");
            moveButtons[i][2] = new JButton(
                moveButtons[i][0].getText().charAt(0) + "2");
        }
        moveButtonsPanel = new JPanel(new GridLayout(6,3));
        for(JButton[] butts : moveButtons)
        {
            for(JButton butt : butts)
            {
                butt.addActionListener(new MoveListener());
                butt.setEnabled(false);
                moveButtonsPanel.add(butt);

            }
        }

        String[] choices = {"Solved", "Checkerboard","Lines"};
        presets = new JComboBox<String>(choices);
//         presets.addItem((Object) "Solved");
//         presets.addItem("Checkerboard");
        presets.setEditable(false);
        presets.setEnabled(false);

        go = new JButton("Go!");
        go.addActionListener(new GoListener());
        go.setEnabled(false);

        scramble = new JButton("Scramble!");
        scramble.addActionListener(new ScrambleListener());
        scramble.setEnabled(false);

//begin top-level components
        cubeUI = new JPanel(new GridLayout(3,4));
        cubeUI.setBorder(
            BorderFactory.createEmptyBorder(
            10,10,10,10));

        //first row
        cubeUI.add(new JPanel());cubeUI.add(facePanels[1]);
            cubeUI.add(new JPanel());cubeUI.add(new JPanel());
        //second row
        cubeUI.add(facePanels[0]);cubeUI.add(facePanels[2]);
            cubeUI.add(facePanels[4]);cubeUI.add(facePanels[5]);
        //third row
        cubeUI.add(new JPanel());cubeUI.add(facePanels[3]);
            cubeUI.add(new JPanel());cubeUI.add(modeButtonPanel);

        messageLabel = new JLabel(
            "Welcome to Rubik's Cube by Boom");
//        messageLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
//        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        colorButtonsPanel = new JPanel(new GridLayout(3,2));
        colorButtonsPanel.setBorder(
            BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.black),
            "Pen Color",TitledBorder.CENTER,TitledBorder.TOP));

        colorButtonsPanel.add(blue);colorButtonsPanel.add(green);
        colorButtonsPanel.add(red);colorButtonsPanel.add(orange);
        colorButtonsPanel.add(yellow);colorButtonsPanel.add(white);
//         colorButtonsPanel.add(black);

        playPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        playPanel.add(moveButtonsPanel);
        playPanel.add(presets);
        playPanel.add(go);
        playPanel.add(scramble);

        add(cubeUI, BorderLayout.CENTER);
        add(messageLabel, BorderLayout.NORTH);
        add(colorButtonsPanel, BorderLayout.EAST);
        add(playPanel, BorderLayout.SOUTH);

        cube = new RubiksCube();

        setVisible(true);

        blue.doClick();
    }
    /**
     * Helper method
     * updates the cube UI to display <code>cube</code>     */
    private void displayCube()
    {
        CornerPiece[] c = (CornerPiece[]) cube.getCorners().clone();
        EdgePiece[] e = (EdgePiece[]) cube.getEdges().clone();
        uFace[6].setBackground(c[0].getColor(CornerPiece.ORIENTED));
        lFace[2].setBackground(c[0].getColor(CornerPiece.CCW));
        fFace[0].setBackground(c[0].getColor(CornerPiece.CW));

        uFace[8].setBackground(c[1].getColor(CornerPiece.ORIENTED));
        fFace[2].setBackground(c[1].getColor(CornerPiece.CCW));
        rFace[0].setBackground(c[1].getColor(CornerPiece.CW));

        uFace[2].setBackground(c[2].getColor(CornerPiece.ORIENTED));
        rFace[2].setBackground(c[2].getColor(CornerPiece.CCW));
        bFace[0].setBackground(c[2].getColor(CornerPiece.CW));

        uFace[0].setBackground(c[3].getColor(CornerPiece.ORIENTED));
        bFace[2].setBackground(c[3].getColor(CornerPiece.CCW));
        lFace[0].setBackground(c[3].getColor(CornerPiece.CW));

        dFace[0].setBackground(c[4].getColor(CornerPiece.ORIENTED));
        fFace[6].setBackground(c[4].getColor(CornerPiece.CCW));
        lFace[8].setBackground(c[4].getColor(CornerPiece.CW));

        dFace[2].setBackground(c[5].getColor(CornerPiece.ORIENTED));
        rFace[6].setBackground(c[5].getColor(CornerPiece.CCW));
        fFace[8].setBackground(c[5].getColor(CornerPiece.CW));

        dFace[8].setBackground(c[6].getColor(CornerPiece.ORIENTED));
        bFace[6].setBackground(c[6].getColor(CornerPiece.CCW));
        rFace[8].setBackground(c[6].getColor(CornerPiece.CW));

        dFace[6].setBackground(c[7].getColor(CornerPiece.ORIENTED));
        lFace[6].setBackground(c[7].getColor(CornerPiece.CCW));
        bFace[8].setBackground(c[7].getColor(CornerPiece.CW));

        uFace[7].setBackground(e[0].getColor(EdgePiece.ORIENTED));
        fFace[1].setBackground(e[0].getColor(EdgePiece.UNORIENTED));

        uFace[5].setBackground(e[1].getColor(EdgePiece.ORIENTED));
        rFace[1].setBackground(e[1].getColor(EdgePiece.UNORIENTED));

        uFace[1].setBackground(e[2].getColor(EdgePiece.ORIENTED));
        bFace[1].setBackground(e[2].getColor(EdgePiece.UNORIENTED));

        uFace[3].setBackground(e[3].getColor(EdgePiece.ORIENTED));
        lFace[1].setBackground(e[3].getColor(EdgePiece.UNORIENTED));

        fFace[3].setBackground(e[4].getColor(EdgePiece.ORIENTED));
        lFace[5].setBackground(e[4].getColor(EdgePiece.UNORIENTED));

        fFace[5].setBackground(e[5].getColor(EdgePiece.ORIENTED));
        rFace[3].setBackground(e[5].getColor(EdgePiece.UNORIENTED));

        bFace[3].setBackground(e[6].getColor(EdgePiece.ORIENTED));
        rFace[5].setBackground(e[6].getColor(EdgePiece.UNORIENTED));

        bFace[5].setBackground(e[7].getColor(EdgePiece.ORIENTED));
        lFace[3].setBackground(e[7].getColor(EdgePiece.UNORIENTED));

        dFace[1].setBackground(e[8].getColor(EdgePiece.ORIENTED));
        fFace[7].setBackground(e[8].getColor(EdgePiece.UNORIENTED));

        dFace[5].setBackground(e[9].getColor(EdgePiece.ORIENTED));
        rFace[7].setBackground(e[9].getColor(EdgePiece.UNORIENTED));

        dFace[7].setBackground(e[10].getColor(EdgePiece.ORIENTED));
        bFace[7].setBackground(e[10].getColor(EdgePiece.UNORIENTED));

        dFace[3].setBackground(e[11].getColor(EdgePiece.ORIENTED));
        lFace[7].setBackground(e[11].getColor(EdgePiece.UNORIENTED));

    }
    /**
     * Helper method
     * updates the cube variable based on the display
     */
    private void updateCube() throws NoSuchPieceException
    {
        CornerPiece[] c = new CornerPiece[8];
        EdgePiece[] e = new EdgePiece[12];

        c[0] = new CornerPiece(
                uFace[6].getBackground(),
                lFace[2].getBackground(),
                fFace[0].getBackground());

        c[1] = new CornerPiece(
                uFace[8].getBackground(),
                fFace[2].getBackground(),
                rFace[0].getBackground());

        c[2] = new CornerPiece(
                uFace[2].getBackground(),
                rFace[2].getBackground(),
                bFace[0].getBackground());

        c[3] = new CornerPiece(
                uFace[0].getBackground(),
                bFace[2].getBackground(),
                lFace[0].getBackground());

        c[4] = new CornerPiece(
                dFace[0].getBackground(),
                fFace[6].getBackground(),
                lFace[8].getBackground());

        c[5] = new CornerPiece(
                dFace[2].getBackground(),
                rFace[6].getBackground(),
                fFace[8].getBackground());

        c[6] = new CornerPiece(
                dFace[8].getBackground(),
                bFace[6].getBackground(),
                rFace[8].getBackground());

        c[7] = new CornerPiece(
                dFace[6].getBackground(),
                lFace[6].getBackground(),
                bFace[8].getBackground());

        e[0] = new EdgePiece(
                uFace[7].getBackground(),
                fFace[1].getBackground());

        e[1] = new EdgePiece(
                uFace[5].getBackground(),
                rFace[1].getBackground());

        e[2] = new EdgePiece(
                uFace[1].getBackground(),
                bFace[1].getBackground());

        e[3] = new EdgePiece(
                uFace[3].getBackground(),
                lFace[1].getBackground());

        e[4] = new EdgePiece(
                fFace[3].getBackground(),
                lFace[5].getBackground());

        e[5] = new EdgePiece(
                fFace[5].getBackground(),
                rFace[3].getBackground());

        e[6] = new EdgePiece(
                bFace[3].getBackground(),
                rFace[5].getBackground());

        e[7] = new EdgePiece(
                bFace[5].getBackground(),
                lFace[3].getBackground());

        e[8] = new EdgePiece(
                dFace[1].getBackground(),
                fFace[7].getBackground());

        e[9] = new EdgePiece(
                dFace[5].getBackground(),
                rFace[7].getBackground());

        e[10] = new EdgePiece(
                dFace[7].getBackground(),
                bFace[7].getBackground());

        e[11] = new EdgePiece(
                dFace[3].getBackground(),
                lFace[7].getBackground());


        cube = new RubiksCube(c,e);
        messageLabel.setText("Cube Build Successful!");
    }
    /**
     * Helper method
     * Sets moveButtons enabled state to the parameter
     * @param state if true, moveButtons will be enabled
     */
    private void setEnabledMoveButtons(boolean state)
    {
        for(JButton[] butts : moveButtons)
        {
            for(JButton butt : butts)
            {
                butt.setEnabled(state);
            }
        }
    }
}