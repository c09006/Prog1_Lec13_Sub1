import java.applet.Applet;
import java.awt.Graphics;
import java.util.Calendar;

public class Prog1_Lec13_Sub1 extends Applet {
	public void paint( Graphics g){
		//アナログ時計を描画する
		int x0, y0, r=50;  // 直線の始点(x0, y0),終点(x1, y1), 半径r=50
		int xh,yh,xm,ym,xs,ys; //時、分、秒針のx,y座標を保持する変数
		int sec, min,hour; //現在の秒、分、時を保持する変数
		x0 = y0 = 70;	//時計の中心を指定
		Calendar cal = Calendar.getInstance();//現在時刻を取得
	    sec = cal.get(Calendar.SECOND);		//secに現在の秒を代入
        min = cal.get(Calendar.MINUTE);		//minに現在の分を代入
        hour = cal.get(Calendar.HOUR);		//hourに現在の時を代入
        
        //分針の角度を取得（ラジアン角）
        double Sm = (min / 60.0) * 2.0 * Math.PI;
        //時針の角度を取得（ラジアン角）
        double Sh = ((hour / 12.0) * 2.0 * Math.PI) + ((min / 60.0 * 2.0 * Math.PI) / 12.0);
        
        //秒針のｘ座標ｙ座標を計算
        xs = 70+(int)Math.rint(r*Math.sin(Math.toRadians(sec*6)));
        ys = 70-(int)Math.rint(r*Math.cos(Math.toRadians(sec*6)));
        
        //分針のｘ座標ｙ座標を計算
        xm = 70+(int)Math.rint(40*Math.sin(Sm));
        ym = 70-(int)Math.rint(40*Math.cos(Sm));
        
        //時針のｘ座標ｙ座標を計算
        xh = 70+(int)Math.rint(30*Math.sin(Sh));
        yh = 70-(int)Math.rint(30*Math.cos(Sh));
        
        //秒針を描画
        g.drawLine(x0, y0, xs, ys);
        //分針を描画
        g.drawLine(x0, y0, xm, ym);
        //時針を描画
        g.drawLine(x0, y0, xh, yh);
        //時計の外枠を描画
        g.drawOval(20, 20, 100, 100);
        
        //目盛描画
    	int rad = 0;
    	int Sx1, Sy1, Sx2, Sy2;
        for(int i = 0; i < 60; i++){
        	if(i % 5 == 0){
            	Sx1 = 70+(int)Math.rint(r*Math.sin(Math.toRadians(rad)));
            	Sy1 = 70-(int)Math.rint(r*Math.cos(Math.toRadians(rad)));
            	Sx2 = 70+(int)Math.rint(40*Math.sin(Math.toRadians(rad)));
            	Sy2 = 70-(int)Math.rint(40*Math.cos(Math.toRadians(rad)));
        	}else{
            	Sx1 = 70+(int)Math.rint(r*Math.sin(Math.toRadians(rad)));
            	Sy1 = 70-(int)Math.rint(r*Math.cos(Math.toRadians(rad)));
            	Sx2 = 70+(int)Math.rint(45*Math.sin(Math.toRadians(rad)));
            	Sy2 = 70-(int)Math.rint(45*Math.cos(Math.toRadians(rad)));
        	}
            g.drawLine(Sx1, Sy1, Sx2, Sy2);
            rad += 6;
        }
	}
}
