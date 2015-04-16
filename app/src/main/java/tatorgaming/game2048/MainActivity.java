package tatorgaming.game2048;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements        GestureDetector.OnGestureListener,        GestureDetector.OnDoubleTapListener{

    private GestureDetectorCompat gestureDetector;
    private TextView message;
    private MotionEvent scrollOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message = (TextView)findViewById(R.id.messages);
        this.gestureDetector = new GestureDetectorCompat(this,this);
        gestureDetector.setOnDoubleTapListener(this);
    }
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {

        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        scrollOne=e1;
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        scrollOne=e1;
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_UP){
            endScroll(event);
        }else /*if(event.getAction()==MotionEvent.ACTION_DOWN)*/{
            gestureDetector.onTouchEvent(event);
        }
        return super.onTouchEvent(event);
    }
    public void endScroll(MotionEvent e2){
       double m =  (e2.getRawY()-scrollOne.getRawY())/(e2.getRawX()-scrollOne.getRawX());
        if((e2.getRawX()>scrollOne.getRawX())&&(m<1&&m>-1)){
            message.setText("right");
        }else if((e2.getRawX()<scrollOne.getRawX())&&(m<1&&m>-1)){
            message.setText("left");
        }else if((e2.getRawY()>scrollOne.getRawY())&&(m>1||m<-1)){
            message.setText("down");
        }else if((e2.getRawY()<scrollOne.getRawY())&&(m>1||m<-1)){
            message.setText("up");
        }else{
            message.setText(""+scrollOne.getRawX()+", "+scrollOne.getRawY()+"  "+e2.getRawX()+", "+ e2.getRawY());
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
