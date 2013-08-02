package xuzhenzhen.structure.global;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import javax.imageio.ImageIO;

public class Global {
	public final static int radius=30;
	public final static Random rand=new Random(new Date().getTime());
	public static BufferedImage getVertexImage(boolean arg){
		BufferedImage image=null;
		try {
			if(arg)
				image=ImageIO.read(new File("icons/select_node.png"));
			else
				image=ImageIO.read(new File("icons/node.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	public static int getRandom(){
		return rand.nextInt(500)+50;
	}
	public static void drawText(Graphics g,int x,int y,String text,Color color){
		Graphics2D g0=(Graphics2D)g;
		g0.setColor(color);
		Font font=new Font("default", Font.BOLD, 12);
		FontRenderContext context=g0.getFontRenderContext();
		TextLayout layout=new TextLayout(text, font, context);
		double width=layout.getBounds().getWidth();
		double height=layout.getBounds().getHeight();
		float x0=(float)(x-width/2);
		float y0=(float)(y+height);
		layout.draw(g0, x0,y0);
	}
	public static void drawCenterText(Graphics g,int x,int y,String text,Color color){
		Graphics2D g0=(Graphics2D)g;
		g0.setColor(color);
		Font font=new Font("default", Font.BOLD, 12);
		FontRenderContext context=g0.getFontRenderContext();
		TextLayout layout=new TextLayout(text, font, context);
		double width=layout.getBounds().getWidth();
		double height=layout.getBounds().getHeight();
		float x0=(float)(x-width/2);
		float y0=(float)(y+height/2);
		layout.draw(g0, x0,y0);
	}
	public static boolean drawArrowLine(Graphics g,Point from,Point to,Color color){
		boolean isDraw=false;
		Graphics2D g0=(Graphics2D)g;
		g0.setColor(color);
		int dx=to.x-from.x;
		int dy=to.y-from.y;
		int radius=getVertexImage(false).getHeight();//直径
		double d=Point.distance(from.x, from.y, to.x, to.y);
		if(d-radius>1){
			isDraw=true;
			double sx=from.x+dx*radius/(d*2);//起点x
			double sy=from.y+dy*radius/(d*2);//起点y
			double ex=to.x-dx*radius/(d*2);//终点x
			double ey=to.y-dy*radius/(d*2);//终点y
			double px=ex-dx*radius/(d*2);//终点退回半径长的x
			double py=ey-dy*radius/(d*2);//终点退回半径长的y
			Polygon points=new Polygon();
			points.addPoint((int)ex, (int)ey);
			points.addPoint((int)(px-dy*3/d),(int)(py+dx*3/d));
			points.addPoint((int)(px+dy*3/d), (int)(py-dx*3/d));
			g0.drawLine((int)sx,(int)sy,(int)px,(int)py);
			g.fillPolygon(points);
		}
		return isDraw;
	}
	public static void drawRenderText(Graphics g,int x,int y,String text,Color color){
		Graphics2D g0=(Graphics2D)g;
		Font font=new Font("default", Font.BOLD, 12);
		FontRenderContext context=g0.getFontRenderContext();
		TextLayout layout=new TextLayout(text, font, context);
		double width=layout.getBounds().getWidth();
		double height=layout.getBounds().getHeight();
		float x0=(float)(x-width/2);
		float y0=(float)(y+height/2);
		g0.setColor(Color.LIGHT_GRAY);
		g0.fillRect((int)x0-2,(int)(y0-height),(int)width+4, (int)height+4);
		g0.setColor(color);
		layout.draw(g0, x0,y0);
	}
	public static boolean isBigger(Object a,Object b,Object c){//a+b>c
		if(a==null||b==null)return true;
		if(c==null)return false;
		int a0=(Integer)a;
		int b0=(Integer)b;
		int c0=(Integer)c;
		return a0+b0>=c0;
	}
	public static boolean isBiger(Object a,Object b){//a>b
		if(b==null)return false;
		if(a==null)return true;
		int a0=(Integer)a;
		int b0=(Integer)b;
		return a0>b0;
	}
	public static void showMatrix(Object[][] matrix){
		if(matrix!=null){
			for(int i=0;i<matrix.length;i++){
				for(int j=0;j<matrix[i].length;j++){
					System.out.print(matrix[i][j]+"\t");
				}
				System.out.println();
			}
		}
	}
}
