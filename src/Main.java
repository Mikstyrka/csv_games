import org.jfree.ui.RefineryUtilities;

public class Main {
    public static void main(String[] args){
        var eu = new SelectEUmax();
        eu.select();
        var jp = new SelectJPmax();
        jp.select();
        var gist = new Ghistogramm("Statistics Sales","Mean Sales");
        gist.pack();
        RefineryUtilities.centerFrameOnScreen(gist);
        gist.setVisible(true);
    }

}