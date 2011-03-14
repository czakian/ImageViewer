import javax.swing.*;
import javax.media.jai.*;
import com.sun.media.jai.widget.DisplayJAI;
import com.sun.media.jai.codec.*;

public class ImageViewer{
    public static void main(String[] args){
	try {
	    RenderedOp img;
	    String input = (args.length < 1 ? "From Stream" : args[0]);
	    if(args.length < 1) { //redirecting a file apparently is not an argument
		SeekableStream iis = SeekableStream.wrapInputStream(System.in, true);
		img = JAI.create("stream", iis);
	    } else {
		img = JAI.create("fileload", input);
	    }
	    JFrame frame = new JFrame("ImageViewer " + input);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.add(new JScrollPane(new DisplayJAI(img)));
	    frame.pack();
	    frame.setVisible(true);
	}catch(IllegalArgumentException e) {
	    JOptionPane.showMessageDialog
		(null, "File: not found! Please check your path and try again", "Error!", JOptionPane.ERROR_MESSAGE);
	    e.printStackTrace();
	}
    }
}
