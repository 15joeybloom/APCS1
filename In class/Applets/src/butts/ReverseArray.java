package butts;

import java.applet.Applet;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * @author Joey Bloom
 * In class learning about Applets
 *
 */
public class ReverseArray extends Applet implements ActionListener
{
    private int[] score;
    private TextField size = new TextField(3);
    private Label sizeLabel = new Label("Size");
    private TextField value = new TextField(7);
    private Label valueLabel = new Label("Value");
    private int index = 0;
    private TextArea result = new TextArea(4,40);

    @Override
    public void init()
    {
        add(sizeLabel);
        add(size);
        add(value);
        add(valueLabel);
        add(result);

        size.addActionListener(this);
        value.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        int count = Integer.parseInt(size.getText());
        if(source == size)
        {
            score = new int[count];
            value.setEnabled(true);
            index = 0;
            result.append("\n");
        }
        else if(source == value)
        {
            int num = Integer.parseInt(value.getText());
            if(index == 0)
            {
                result.append("The original array is {");
            }
            if(index != 0)
            {
                result.append(",");
            }
            result.append(String.valueOf(num));
            score[index++] = num;
            value.setText("");
            if(index == count)
            {
                value.setEnabled(false);

                int temp; //used to store a value during swap
                int left = 0; // index of left element to swap
                int right = score.length - 1;

                while(left < right)
                {
                    temp = score[left];
                    score[left++] = score[right];
                    score[right--] = temp;
                }

                result.append("}\n");

                result.append("The reversed array is {");
                for(int i = 0; i < score.length; i++)
                {
                    if(i != 0)
                    {
                        result.append(",");
                    }
                    result.append(String.valueOf(score[i]));
                }
                result.append("}");
            }
        }
    }
}
