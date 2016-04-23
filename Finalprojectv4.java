import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.color.ColorSpace;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.ColorConvertOp;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.LookupOp;
import java.awt.image.RescaleOp;
import java.awt.image.ShortLookupTable;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.*;
import java.awt.image.*;
import java.awt.image.LookupTable;

import net.coobird.thumbnailator.*;
import net.coobird.thumbnailator.filters.Canvas;
import net.coobird.thumbnailator.geometry.Positions;

import java.awt.Color;


public class Finalprojectv4 extends JFrame 
{
  	ColorPanel displayPanel;
	
	//Button declaration
	JButton grayButton, blurButton, sharpenButton, brightenButton, darkenButton, edgeDetectButton, negativeButton,saveButton; 
	JButton squareButton, rotateButton, redButton, blueButton, exitButton,  greenButton, resetButton, contrastButton, contrastDecButton;

	LookupTable lookupTable;

  	
	public Finalprojectv4() 
	{
    		super();
    		Container container = getContentPane();

    		displayPanel = new ColorPanel();
    		container.add(displayPanel);

    		JPanel panel = new JPanel();
    		panel.setLayout(new GridLayout(4, 4));
    		panel.setBorder(new TitledBorder("Click Any Button to Process the Image..."));

    		grayButton = new JButton("Gray Scale");
    		grayButton.addActionListener(new ButtonListener());
		blurButton = new JButton("Blur");
                blurButton.addActionListener(new ButtonListener());
    		sharpenButton = new JButton("Sharpen");
                sharpenButton.addActionListener(new ButtonListener());
		brightenButton = new JButton("Brighten");
                brightenButton.addActionListener(new ButtonListener());
		darkenButton = new JButton("Darken");
                darkenButton.addActionListener(new ButtonListener());
		contrastButton = new JButton("Contrast>>");
                contrastButton.addActionListener(new ButtonListener());
		contrastDecButton = new JButton("Contrast<<");
                contrastDecButton.addActionListener(new ButtonListener());
		edgeDetectButton = new JButton("EdgeDetection");
                edgeDetectButton.addActionListener(new ButtonListener());
		negativeButton = new JButton("Negative");
                negativeButton.addActionListener(new ButtonListener());
		rotateButton = new JButton("Rotate");
                rotateButton.addActionListener(new ButtonListener());
		redButton = new JButton("Red");
    		redButton.addActionListener(new ButtonListener());
    		blueButton = new JButton("Blue");
    		blueButton.addActionListener(new ButtonListener());	
    		greenButton = new JButton("Green");
                greenButton.addActionListener(new ButtonListener());
		resetButton = new JButton("Reset");
                resetButton.addActionListener(new ButtonListener());
		squareButton = new JButton("SquareIt");
                squareButton.addActionListener(new ButtonListener());		
		saveButton = new JButton("Save");
                saveButton.addActionListener(new ButtonListener());
		
		panel.add(grayButton);
		panel.add(blurButton);
		panel.add(brightenButton);
		panel.add(darkenButton);
		panel.add(contrastButton);
		panel.add(contrastDecButton);
		panel.add(sharpenButton);
		panel.add(edgeDetectButton);
		panel.add(negativeButton);
		panel.add(rotateButton);
		panel.add(redButton);
		panel.add(blueButton);
    		panel.add(greenButton);
    		panel.add(resetButton);
    		panel.add(squareButton);
		panel.add(saveButton);

		container.add(BorderLayout.SOUTH, panel);

    		addWindowListener(new WindowEventHandler());

		JMenu fileMenu = new JMenu("File");
                JMenuItem openItem = new JMenuItem("Open");
                openItem.addActionListener(new ActionListener()
                {
                        public void actionPerformed(ActionEvent event)
                        {
                               	displayPanel.openFile();
                        }
                });
                fileMenu.add(openItem);

                JMenuItem exitItem = new JMenuItem("Exit");
                exitItem.addActionListener(new ActionListener()
                {
                        public void actionPerformed(ActionEvent event)
                        {
                                System.exit(0);
                        }
                });
                fileMenu.add(exitItem);


                JMenuBar menuBar = new JMenuBar();
                menuBar.add(fileMenu);
                setJMenuBar(menuBar);

		setSize(displayPanel.getWidth(), displayPanel.getHeight() );
                setVisible(true);
  	}
	
	class WindowEventHandler extends WindowAdapter 
	{
    		public void windowClosing(WindowEvent e) 
		{
      			System.exit(0);
    		}
  	}

  	public static void main(String arg[]) 
	{
    		new Finalprojectv4();
  	}

  	class ButtonListener implements ActionListener 
	{
    		public void actionPerformed(ActionEvent e) 
		{
      			JButton button = (JButton) e.getSource();

      			if (button.equals(grayButton)) 
			{
        			displayPanel.grayOut();
        			displayPanel.repaint();
      			} 
			else if (button.equals(blurButton)) 
			{
        			displayPanel.blurOut();	
        			displayPanel.repaint();
      			} 
			else if (button.equals(sharpenButton)) 
			{
        			displayPanel.sharpenOut();
        			displayPanel.repaint();
			} 
			else if (button.equals(brightenButton)) 
			{
        			displayPanel.brightenOut();
        			displayPanel.applyFilter();
        			displayPanel.repaint();
      			} 
			else if (button.equals(darkenButton))
                        {
                                displayPanel.darkenOut();
                                displayPanel.applyFilter();
                                displayPanel.repaint();
                        } 
			else if (button.equals(contrastButton)) 
			{
        			displayPanel.contrastOut();
        			displayPanel.applyFilter();
      	  			displayPanel.repaint();
      			} 
			else if (button.equals(contrastDecButton))
                        {
                                displayPanel.contrastDecOut();
                                displayPanel.applyFilter();
                                displayPanel.repaint();
                        } 
			else if (button.equals(edgeDetectButton)) 
			{
        			displayPanel.edgeDetectOut();
        			displayPanel.repaint();
			} 
			else if (button.equals(negativeButton)) 
			{
        			displayPanel.negativeOut();
        			displayPanel.applyFilter();
        			displayPanel.repaint();
      			} 
			else if (button.equals(rotateButton)) 
			{
        			displayPanel.rotateOut();
        			displayPanel.repaint();
			} 
			else if (button.equals(redButton)) 
			{
        			displayPanel.redOut();
        			displayPanel.repaint();
			} 
			else if (button.equals(blueButton)) 
			{
        			displayPanel.blueOut();
        			displayPanel.repaint();
			} 
			else if (button.equals(greenButton)) 
			{
        			displayPanel.greenOut();
        			displayPanel.repaint();
			}
  			else if (button.equals(resetButton)) 
			{
        			displayPanel.resetOut();
        			displayPanel.repaint();	
      			}		
			else if (button.equals(squareButton))
			{
				displayPanel.squareOut();
				displayPanel.repaint();
			}
			else if (button.equals(saveButton))
				displayPanel.saveOut();
		}
	}	

	class ColorPanel extends JLabel 
	{
  		Image displayImage,img;
		
		int x=0;
  		BufferedImage bi,biSrc,biSrc1,biDest;

  		Graphics2D big;
		File f = null;

		RescaleOp rescale;
    		float scaleFactor = 1.0f;
    		float offset = 10;
		boolean brighten, contrastInc;


  		ColorPanel() 
		{
    			setBackground(Color.black);
    			loadImage();
    			setSize(displayImage.getWidth(this), displayImage.getWidth(this));

    			createBufferedImage();
  		}

  		public void loadImage() 
		{
    			displayImage = Toolkit.getDefaultToolkit().getImage("Screen Shot 2016-03-21 at 10.42.23 PM.jpg");
    			MediaTracker mt = new MediaTracker(this);
    			mt.addImage(displayImage, 1);
    			try 
			{
      				mt.waitForAll();
    			} 
			catch (Exception e) 
			{
      				System.out.println("Exception while loading.");
    			}
    			if (displayImage.getWidth(this) == -1) 
			{
      				System.out.println("No jpg ");
      				System.exit(0);
    			}
			x=1;
  		}
	
  		public void createBufferedImage() 
		{
    			biSrc = new BufferedImage(displayImage.getWidth(this), 
						displayImage.getHeight(this), BufferedImage.TYPE_INT_RGB);
			
			big = biSrc.createGraphics();
    			big.drawImage(displayImage, 0, 0, this);
			
			biDest = new BufferedImage(displayImage.getWidth(this),
                                   displayImage.getHeight(this),
                                   BufferedImage.TYPE_INT_RGB);
        		bi = biSrc;
  		}
		public void openFile()
		{
			JFileChooser chooser = new JFileChooser();
                	chooser.setCurrentDirectory(new File("."));
                	String[] extensions = ImageIO.getReaderFileSuffixes();
                	//chooser.setFileFilter(new FileNameExtensionFilter("Image files", extensions));
                	int r = chooser.showOpenDialog(this);
                	if (r != JFileChooser.APPROVE_OPTION) return;
        	
        	try
        	{
                	img = ImageIO.read(chooser.getSelectedFile());

                	biSrc1 = new BufferedImage(img.getWidth(null), img.getHeight(null),BufferedImage.TYPE_INT_RGB);

                	big = biSrc1.createGraphics();
                	big.drawImage(img, 0, 0, this);
                	biDest = new BufferedImage(img.getWidth(null),img.getHeight(null),BufferedImage.TYPE_INT_RGB);
                	bi = biSrc1;
			x=2;
        	}
        	catch (IOException e)
        	{
                	JOptionPane.showMessageDialog(this, e);
        	}
        	repaint();
	}	
		public void brightenOut() 
		{
    			short brighten[] = new short[256];
    			for (int i = 0; i < 256; i++) 
			{
      				short pixelValue = (short) (i + 10);
      				if (pixelValue > 255)
        			pixelValue = 255;
      			else if (pixelValue < 0)
        			pixelValue = 0;
      				brighten[i] = pixelValue;
    			}	
    			lookupTable = new ShortLookupTable(0, brighten);
  		}

		public void darkenOut() 
		{
    			short brighten[] = new short[256];
    			for (int i = 0; i < 256; i++) 
			{
      				short pixelValue = (short) (i - 10);
      				if (pixelValue > 255)
        				pixelValue = 255;
      				else if (pixelValue < 0)
        				pixelValue = 0;
      				brighten[i] = pixelValue;
    			}
    			lookupTable = new ShortLookupTable(0, brighten);
  		}

		public void contrastOut() 
		{
    			short brighten[] = new short[256];
    			for (int i = 0; i < 256; i++) 
			{
      				short pixelValue = (short) (i * 1.2);
      				if (pixelValue > 255)
        			pixelValue = 255;
      				else if (pixelValue < 0)
        			pixelValue = 0;
      				brighten[i] = pixelValue;
    			}
    			lookupTable = new ShortLookupTable(0, brighten);
  		}

		public void contrastDecOut() 
		{
    			short brighten[] = new short[256];
    			for (int i = 0; i < 256; i++) 
			{
      				short pixelValue = (short) (i / 1.2);
      				if (pixelValue > 255)
        				pixelValue = 255;
      				else if (pixelValue < 0)
        				pixelValue = 0;
      				brighten[i] = pixelValue;
    			}
    			lookupTable = new ShortLookupTable(0, brighten);
  		}

  		public void grayOut() 
		{
    			ColorConvertOp colorConvert = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
    			colorConvert.filter(bi, bi);
  		}

		public void resetOut() 
		{
    			big.setColor(Color.black);
    			big.clearRect(0, 0, bi.getWidth(this), bi.getHeight(this));
    			if(x==1)
			{
				big.drawImage(displayImage, 0, 0, this);
				bi = biSrc;
			}
			if(x==2)
			{
				big.drawImage(img, 0, 0, this);
                                bi = biSrc1;
			}	

  		}
		
		public void blurOut()
		{
               		float weight = 1.0f / 9.0f;
               		float[] elements = new float[9];
               		for (int i = 0; i < 9; i++)
                  		elements[i] = weight;
               		convolve(elements);
            	}

		public void sharpenOut()
		{
			float[] elements = { 0.0f, -1.0f, 0.0f, -1.0f, 5.f, -1.0f, 0.0f, -1.0f, 0.0f };
               		convolve(elements);
		}

		public void edgeDetectOut()
		{
			float[] elements = { 0.0f, -1.0f, 0.0f, -1.0f, 4.f, -1.0f, 0.0f, -1.0f, 0.0f };
               		convolve(elements);
		}
	
		public void negativeOut() 
		{
    			byte negative[] = new byte[256];
    			for (int i = 0; i < 256; i++) 
			{
      				negative[i] = (byte) (255 - i);
    			}
    			lookupTable = new ByteLookupTable(0, negative);
  		}	
		
		public void rotateOut()
		{
			if (bi == null) return;
               		AffineTransform transform = AffineTransform.getRotateInstance(Math.toRadians(90),
                     	bi.getWidth() / 2, bi.getHeight() / 2);
               		AffineTransformOp op = new AffineTransformOp(transform,
                     	AffineTransformOp.TYPE_BICUBIC);
               		filter(op);
		}

		public void redOut()
		{
			short[] red = new short[256];
	                short[] green = new short[256];
	                short[] blue = new short[256];
	
                	for(short i = 0; i< 256; i++)
                	{
                	        red[i]=(short) (255 - i);
                	        green[i]=blue[i]=i;
                	}
                	short[][] data = new short[][]
                	{
                        	red,green,blue
                	};
                	ShortLookupTable lookupTable = new ShortLookupTable(0, data);
               		LookupOp op = new LookupOp(lookupTable, null);
               		filter(op);
		}
  		
		public void blueOut() 
		{
                	short[] red = new short[256];
                	short[] green = new short[256];
                	short[] blue = new short[256];

                	for(short i = 0; i< 256; i++)
                	{
                        	blue[i]=(short) (255 - i);
                        	green[i]=red[i]=i;
                	}
                	short[][] data = new short[][]
                	{
                        	red,green,blue
                	};
                	ShortLookupTable lookupTable = new ShortLookupTable(0, data);
               		LookupOp op = new LookupOp(lookupTable, null);
               		filter(op);
         	}
        
   		public void greenOut()
		{
			short[] red = new short[256];
                	short[] green = new short[256];
                	short[] blue = new short[256];

                	for(short i = 0; i< 256; i++)
                	{
                	        green[i]=(short) (255 - i);
                	        blue[i]=red[i]=i;
                	}
                		short[][] data = new short[][]
                	{
                        	red,green,blue
                	};
                	ShortLookupTable lookupTable = new ShortLookupTable(0, data);
               		LookupOp op = new LookupOp(lookupTable, null);
               		filter(op);
		}
		
		public void squareOut()
		{
			try
    			{
        			Thumbnails.of(bi)
        			.size(2000, 2000)
        			.addFilter(new Canvas(2000, 2000, Positions.CENTER, Color.WHITE))
        			.toFile("/Users/darshan/Desktop/Square_image.jpg");
				
    			}
    			catch (IOException e)
    			{
     		 		e.printStackTrace(System.out);
    			}
		}
		
		public void saveOut()
		{
			 //write image
        		try
			{
            			f = new File("/Users/darshan/Desktop/Processed Image.jpg");
            			ImageIO.write(bi, "jpg", f);
        		}
			catch(IOException e)
			{
            			System.out.println("error");
        		}

		}
  		
		public void paintComponent(Graphics g) 
		{
    			super.paintComponent(g);
    			Graphics2D g2D = (Graphics2D) g;

    			g2D.drawImage(bi, 0, 0, this);
  		}

		public void applyFilter() 
		{
    			LookupOp lop = new LookupOp(lookupTable, null);
    			lop.filter(bi, bi);
  		}

		private void filter(BufferedImageOp op)
   		{
      			if (bi == null) 
				return;
      			bi = op.filter(bi, null);
      			repaint();
   		}

		private void convolve(float[] elements)
   		{
      			Kernel kernel = new Kernel(3, 3, elements);
      			ConvolveOp op = new ConvolveOp(kernel);
      			filter(op);
   		}
	
		public void changeOffSet() 
		{
        		if (brighten) 
			{
            			if (offset < 255)
               				offset = offset+5.0f;
        		}
        		else 
			{
            			if (offset > 0)
               				offset = offset-5.0f;
        		}
		}
    
		public void changeScaleFactor() 
		{
        		if (contrastInc) 
			{
            			if (scaleFactor < 2)
                			scaleFactor = scaleFactor+0.1f;
        		}
        		else 
			{
            			if (scaleFactor > 0)
                			scaleFactor = scaleFactor-0.1f;
        		}
    		}

    	
		public void rescale() 
		{
        		rescale = new RescaleOp(scaleFactor, offset, null);
        		rescale.filter(biSrc, biDest);
        		bi = biDest;
    		}


	}
}


