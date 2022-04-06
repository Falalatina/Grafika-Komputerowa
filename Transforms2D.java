import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Transforms2D extends JPanel {

	private class Display extends JPanel {
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.translate(300,300);  // Moves (0,0) to the center of the display.
			int whichTransform = transformSelect.getSelectedIndex();

			// TODO Apply transforms here, depending on the value of whichTransform!
		/*	Paint paint = rgb(100, 30, 90);
			g2.setPaint(paint);
			
			Shape shape = line;
			g2.draw(shape); */
			  // int x[] = { -250, -200, -170, -140, -110, -80, -50, -10, 20, 50, 80, 110, 150, 190, 200, 250  };
			//   int y[] = { 200,    20,   50,   80,   30,  10,  50,  30, 40, 50, 110, 20, 110, 140, 170, 180  };
		//	g2.fillPolygon(x, y, 16);
			
		//	g2.drawImage(pic, -200, -150, null); // Draw image with center at (0,0).
			 switch(whichTransform)
				{
				    case 0: break;
				    case 1:
				        g2.scale(0.5,0.5);
				        break;

				    case 2: 
				    	
				    	g2.rotate(0.5);
				        break;

				    case 3:
				        g2.scale(0.5,0.8);
				        g2.rotate(Math.toRadians(180));
				        break;

				    case 4:
				        g2.shear(0.35,0);
				        break;

				    case 5:
				        g2.scale(1,0.3);
				        g2.translate(0,-900);
				        break;

				    case 6:
				        g2.shear(0,-0.5);
				        g2.rotate(Math.PI / 2);
				        break;

				    case 7:
				    	g2.scale(0.5, 1);
						g2.rotate(Math.PI);
						break;
				        

				    case 8:
				        g2.rotate(Math.toRadians(30));
				        g2.scale(1,0.3);
				        g2.translate(0,200);
				        break;

				    case 9:
				    	g2.translate(100, 0);
						g2.shear(0, 0.25);
						g2.rotate(Math.PI);
						break;

				}



		            int[] xpts = new int[16];
		            int[] ypts = new int[16];
		            for(int i = 1; i < 17; i++)
		            {
		                xpts[i-1] = (int) (200*Math.cos((2*Math.PI/16)*i));
		            }

		            for(int i = 1; i < 16; i++)
		            {
		                ypts[i-1] = (int) (200*Math.sin((2*Math.PI/16)*i));
		            }

		            Polygon wielokat = new Polygon(xpts, ypts, 16);
		            g2.setColor(Color.green);
		            
					g2.fillPolygon(wielokat);
		}
		
	}

	private Display display;
	private BufferedImage pic;
	private JComboBox<String> transformSelect;

	public Transforms2D() throws IOException {
		pic = ImageIO.read(getClass().getClassLoader().getResource("shuttle.jpg"));
		display = new Display();
		display.setBackground(Color.BLUE);
		display.setPreferredSize(new Dimension(600,600));
		transformSelect = new JComboBox<String>();
		transformSelect.addItem("None");
		for (int i = 1; i < 10; i++) {
			transformSelect.addItem("No. " + i);
		}
		transformSelect.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.repaint();
			}
		});
		setLayout(new BorderLayout(3,3));
		setBackground(Color.GRAY);
		setBorder(BorderFactory.createLineBorder(Color.GRAY,10));
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout(FlowLayout.CENTER));
		top.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		top.add(new JLabel("Transform: "));
		top.add(transformSelect);
		add(display,BorderLayout.CENTER);
		add(top,BorderLayout.NORTH);
	}


	public static void main(String[] args) throws IOException {
		JFrame window = new JFrame("2D Transforms");
		window.setContentPane(new Transforms2D());
		window.pack();
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		window.setLocation( (screen.width - window.getWidth())/2, (screen.height - window.getHeight())/2 );
		window.setVisible(true);
	}

}
