package com.ka.lych.graphics;

import com.ka.lych.annotation.Json;
import java.util.Objects;
import com.ka.lych.list.LYosos;
import com.ka.lych.observable.LDouble;
import com.ka.lych.observable.LObservable;
import com.ka.lych.util.LLog;

/**
 *
 * @author klausahrenberg
 * 
 * Possible fxml description:
 * 
 * <LLinearGradient style="fill" spreadMethod="reflect" x1="4" y1="4" x2="10" y2="10">    
 *     <stops>         
 *         <LStop offset="0.0" color="red" />
 *         <LStop offset="0.5" color="blue" />
 *         <LStop offset="1.0" color="black" />
 *     </stops>
 * </LLinearGradient>
 * 
 */
public class LLinearGradient extends LAbstractPaint {

    @Json
    protected LDouble x1;
    
    @Json
    protected LDouble y1, x2, y2;
    @Json
    protected LObservable<LSpreadMethod> spreadMethod;
    @Json
    protected LObservable<LYosos<LStop>> stops;
    
    public LLinearGradient() {       
    }            
    
    public LLinearGradient(double x1, double y1, double x2, double y2, LSpreadMethod spreadMethod, LStop... stops) {
        this.setX1(x1);
        this.setY1(y1);
        this.setX2(x2);
        this.setY2(y2);
        this.setSpreadMethod(spreadMethod);
        this.setStops(new LYosos<>(stops));
    }
    
    public final LDouble x1() {
        if (x1 == null) {
            x1 = new LDouble();            
        }
        return x1;
    }
    
    public final double getX1() {
        return (x1 != null ? x1.get() : 0.0);
    }

    public final void setX1(double x1) {
        x1().set(x1);
    }
    
    public final LDouble x2() {
        if (x2 == null) {
            x2 = new LDouble();            
        }
        return x2;
    }
    
    public final double getX2() {
        return (x2 != null ? x2.get() : 0.0);
    }

    public final void setX2(double x2) {
        x2().set(x2);
    }

    public final LDouble y1() {
        if (y1 == null) {
            y1 = new LDouble();            
        }
        return y1;
    }

    public final double getY1() {
        return (y1 != null ? y1.get() : 0.0);
    }

    public final void setY1(double y1) {
        y1().set(y1);
    }

    public final LDouble y2() {
        if (y2 == null) {
            y2 = new LDouble();            
        }
        return y2;
    }

    public final double getY2() {
        return (y2 != null ? y2.get() : 0.0);
    }

    public final void setY2(double y2) {
        y2().set(y2);
    }
    
    public LObservable<LSpreadMethod> spreadMethod() {
        if (spreadMethod == null) {
            spreadMethod = new LObservable<>(LSpreadMethod.PAD);            
        }
        return spreadMethod;
    }
        
    public LSpreadMethod getSpreadMethod() {
        return (spreadMethod != null ? spreadMethod.get() : LSpreadMethod.PAD);
    }

    public void setSpreadMethod(LSpreadMethod spreadMethod) {
        spreadMethod().set(spreadMethod);
    }
    
    public LObservable<LYosos<LStop>> stops() {
        if (stops == null) {
            stops = new LObservable<>(new LYosos<>());            
        }
        return stops;
    }
        
    public LYosos<LStop> getStops() {
        return (stops != null ? stops.get() : null);
    }

    public void setStops(LYosos<LStop> stops) {
        stops().set(stops);
    }
    
    @Override
    public Object clone() {
        try {
            LLinearGradient p = (LLinearGradient) super.clone();
            LDouble.clone(x1);
            LDouble.clone(y1);
            LDouble.clone(x2);
            LDouble.clone(y2);
            LObservable.clone(spreadMethod);
            LObservable.clone(stops);
            return p;
        } catch (Exception e) {
            LLog.error(this, "clone failed", e);
            throw new InternalError();
        }
    }
    
    @Override
    public boolean equals(Object st) {
        return ((st != null) && (st instanceof LLinearGradient) ? this.hashCode() == st.hashCode() : false);
    }

    @Override
    public int hashCode() {
        //x1, y1, x2, y2;
        //spreadMethod;
        //<LYosos<LStop>> stops;
        return Objects.hash(getStyle(), getX1(), getY1(), getX2(), getY2(), getSpreadMethod(), getStops());
    }
    
}
