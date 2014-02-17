import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Joey
 */
public class CubeApplet extends JApplet
{

    /**
     * Initialization method that will be called after the applet is loaded
     * into the browser.
     */
    public void init()
    {
        try
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    JPanel gui = new GUIPanel();
                    setContentPane(gui);
                }
            });
        }
        catch (Exception e)
        {
            System.err.println("Didn't complete successfully");
        }
    }
    // TODO overwrite start(), stop() and destroy() methods
}
