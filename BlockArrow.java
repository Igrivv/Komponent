/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komponenty;

import java.awt.*;
/**
 *
 * @author CIWEiI_A
 */
public class BlockArrow extends Component {
    private ArrowDirection direction;

    public ArrowDirection getDirection() {
        return direction;
    }

    public void setDirection(ArrowDirection direction) {
        ArrowDirection oldDirection = this.direction;
        this.direction = direction;
        firePropertyChange("direction", oldDirection, direction);
    }
    
    public BlockArrow(){
        setPreferredSize(new Dimension(30,30));
        setForeground(Color.CYAN);
        direction=ArrowDirection.RIGHT;
    }
    public synchronized void paint(Graphics g){
        Dimension d = getSize();
        int w=d.width-1;
        int h = d.height-1;
        int[] xPoints={0,0,w};
        int[] yPoints = {h,0,h/2};
        switch (direction) {
      case LEFT: xPoints = new int[]{w,w,0};  // yPoints - no change
                 break;
      case UP:   xPoints = new int[]{w,0,w/2};
                 yPoints = new int[]{h,h,0};
                 break;
      case DOWN: xPoints = new int[]{w,0,w/2};
                 yPoints = new int[]{0,0,h};
   }
        g.fillPolygon(xPoints,yPoints,3);
    }
    
}
