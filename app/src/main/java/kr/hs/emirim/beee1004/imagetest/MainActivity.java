package kr.hs.emirim.beee1004.imagetest;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MyImage mImg;
    Button rotateBtn,transBtn,scaleBtn,skewBtn;
    public static final int ORIGINAL=0;
    public static final int ROTATE=1;
    public static final int TRANSLATE=2;
    public static final int SCALE=3;
    public static final int SKEW=4;
    int choose=ORIGINAL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //getApplicationContext()도 가능
        LinearLayout linear1=(LinearLayout) findViewById(R.id.linear1);
        mImg=new MyImage(getApplicationContext());
        linear1.addView(mImg);

        rotateBtn=(Button)findViewById(R.id.but_rotate);
        transBtn=(Button)findViewById(R.id.but_translate);
        scaleBtn=(Button)findViewById(R.id.but_scale);
        skewBtn=(Button)findViewById(R.id.but_skew);

        rotateBtn.setOnClickListener(this);
        transBtn.setOnClickListener(this);
        scaleBtn.setOnClickListener(this);
        skewBtn.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.but_rotate:
                choose=ROTATE;
                break;
            case R.id.but_translate:
                choose=TRANSLATE;
                break;
            case R.id.but_scale:
                choose=SCALE;
                break;
            case R.id.but_skew:
                choose=SKEW;
                break;
        }
        mImg.setChoose(choose);
        mImg.invalidate(); //onDraw 다시 호출
    }
}