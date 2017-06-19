package easygame1.becomeayoutuber;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    boolean Ev;
    boolean GoPro;
    boolean f8OyunBilgisayar;
    int energy;
    int healt;
    String[] listJobs;
    String[] listShop;
    ListView listViewJobs;
    ListView listViewshop;
    String[] listinfo;
    ListView listviewinfo;
    int money;
    int subs;
    int maxhealt=100;
    int maxenergy=100;


    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"Thanks For playing",Toast.LENGTH_SHORT).show();
    }


    /* renamed from: easygame1.becomeayoutuber.MainActivity.2 */
    class C01672 implements OnItemClickListener {
        C01672() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            if (position == 0)
            {
                MainActivity.this.healt -= 5;
                MainActivity.this.energy -= 5;
                MainActivity.this.money += 10;
                MainActivity.this.subs += 20;
                MainActivity.this.Kontrol();
                MainActivity.this.Bar();
            }
            else if (position == 1)
            {
                MainActivity.this.healt -= 10;
                MainActivity.this.energy -= 10;
                MainActivity.this.money += 60;
                MainActivity.this.Kontrol();
                MainActivity.this.Bar();
            }
            else if (position == 2)
            {
                if (MainActivity.this.GoPro)
                {
                    MainActivity.this.healt -= 5;
                    MainActivity.this.energy -= 10;
                    MainActivity.this.money += 20;
                    MainActivity.this.subs += 40;
                    MainActivity.this.Kontrol();
                    MainActivity.this.Bar();
                    return;
                }
                Toast.makeText(MainActivity.this.getApplication(), "Go Pro needed for vlog",Toast.LENGTH_SHORT).show();
            }
            else if (position == 3)
            {
                if (MainActivity.this.f8OyunBilgisayar)
                {
                    MainActivity.this.healt -= 5;
                    MainActivity.this.energy -= 10;
                    MainActivity.this.money += 30;
                    MainActivity.this.subs += 50;
                    MainActivity.this.Kontrol();
                    MainActivity.this.Bar();
                    return;
                }
                Toast.makeText(MainActivity.this.getApplication(), "Gaming computer needed for lets play", Toast.LENGTH_SHORT).show();
            }
            else if (position == 4)
            {
                if (MainActivity.this.subs > 5000)
                {
                    MainActivity.this.healt -= 20;
                    MainActivity.this.energy -= 20;
                    MainActivity.this.money += 150;
                    MainActivity.this.subs += 200;
                    MainActivity.this.Kontrol();
                    MainActivity.this.Bar();
                    return;
                }
                Toast.makeText(MainActivity.this.getApplication(), "Not enough subscriber for small ad", Toast.LENGTH_SHORT).show();
            }
            else if (position == 5)
            {
                if (MainActivity.this.subs > 20000)
                {
                    MainActivity.this.healt -= 20;
                    MainActivity.this.energy -= 20;
                    MainActivity.this.money += 1000;
                    MainActivity.this.subs += 1000;
                    MainActivity.this.Kontrol();
                    MainActivity.this.Bar();
                    return;
                }
                Toast.makeText(MainActivity.this.getApplication(), "Not enough subscriber for bigger ad", Toast.LENGTH_SHORT).show();
            }
            else if(position==7)
            {
                if(subs>1000000)
                {
                    subs=subs+50000;
                    money=money+100000;
                    energy-=40;
                    healt-=40;
                    Kontrol();
                    Bar();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Not enough subscriber for hollywood movie",Toast.LENGTH_SHORT).show();
                }
            }
            else if (position != 6)
            {
            }
            else
                {
                if (MainActivity.this.subs > 200000) {
                    MainActivity.this.healt -= 20;
                    MainActivity.this.energy -= 20;
                    MainActivity.this.money += 5000;
                    MainActivity.this.subs += 6000;
                    MainActivity.this.Kontrol();
                    MainActivity.this.Bar();
                    return;
                }
                Toast.makeText(MainActivity.this.getApplication(), "Not enough subscriber for Youtube movie", Toast.LENGTH_SHORT).show();
            }
            RandomEvent(position);
        }
    }

    /* renamed from: easygame1.becomeayoutuber.MainActivity.3 */
    class C01683 implements OnItemClickListener {
        C01683() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            if (position == 0)
            {
                if (MainActivity.this.money >= 5)
                {
                    if(healt<maxhealt) {
                        MainActivity.this.healt += 10;
                        MainActivity.this.energy -= 5;
                        MainActivity.this.money -= 5;
                        MainActivity.this.Kontrol();
                        MainActivity.this.Bar();
                        return;
                    }else{return;}
                }
                Toast.makeText(MainActivity.this.getApplication(), "Not enough money for hot dog", Toast.LENGTH_SHORT).show();
            } else if (position == 1)
            {

                if (MainActivity.this.money >= 20)
                {
                    if(energy<maxenergy) {
                        MainActivity.this.healt -= 5;
                        MainActivity.this.energy += 40;
                        MainActivity.this.money -= 20;
                        MainActivity.this.Kontrol();
                        MainActivity.this.Bar();
                        return;
                    }else{return;}
                }
                Toast.makeText(MainActivity.this.getApplication(), "Not enough money for blue bull", Toast.LENGTH_SHORT).show();
            } else if (position == 2)
            {
                if (MainActivity.this.money >= 20)
                {
                    if(healt<maxhealt) {
                        MainActivity.this.healt += 20;
                        MainActivity.this.money -= 20;
                        MainActivity.this.Kontrol();
                        MainActivity.this.Bar();
                        return;
                    }else{return;}
                }
                Toast.makeText(MainActivity.this.getApplication(), "Not enough money for restaurant", Toast.LENGTH_SHORT).show();
            } else {
                if (position == 3)
                {

                    if (money >= 500) {
                        if (maxhealt < 300) {
                            money = money - 500;
                            maxhealt = maxhealt + 50;
                            Bar();
                        } else
                            {
                            Toast.makeText(getApplicationContext(), "Maximum level reached", Toast.LENGTH_SHORT).show();
                        }
                    } else
                        {
                        Toast.makeText(getApplicationContext(), "Not enough money for steroit", Toast.LENGTH_SHORT).show();
                    }
                } else if (position == 4)
                {
                    if (money>500) {
                        if (maxenergy < 300) {
                            money = money - 500;
                            maxenergy = maxenergy + 50;
                            Bar();
                        } else {Toast.makeText(getApplicationContext(), "Maximum level reached", Toast.LENGTH_SHORT).show();

                        }
                    } else
                        {

                        Toast.makeText(getApplicationContext(), "Not enough money for gym", Toast.LENGTH_SHORT).show();
                    }
                } else if (position == 5)
                {
                    if (MainActivity.this.money >= 1000)
                    {
                        if(GoPro==false) {
                            MainActivity.this.money -= 1000;
                            MainActivity.this.GoPro = true;
                            MainActivity.this.listinfo[1] = "GoPro Yes!";
                            MainActivity.this.Kontrol();
                            MainActivity.this.Bar();
                            return;
                        }
                        else{return;}
                    }
                    Toast.makeText(MainActivity.this.getApplication(), "Not enough money for Go Pro", Toast.LENGTH_SHORT).show();
                } else if (position == 6)
                {
                    if (MainActivity.this.money >= 2000)
                    {
                        if(f8OyunBilgisayar==false)
                        {
                            MainActivity.this.f8OyunBilgisayar = true;
                            MainActivity.this.money -= 2000;
                            MainActivity.this.listinfo[2] = "Gaming Computer Yes!";
                            MainActivity.this.Kontrol();
                            MainActivity.this.Bar();
                            return;
                        }else{return;}
                    }
                    Toast.makeText(MainActivity.this.getApplication(), "Not enough money for Gaming computer", Toast.LENGTH_SHORT).show();
                } else if (position != 7)
                {
                } else
                    {
                    if (MainActivity.this.money >= 5000)
                    {
                        if(Ev==false) {
                            MainActivity.this.money -= 5000;
                            MainActivity.this.Ev = true;
                            MainActivity.this.listinfo[3] = "House Yes!";
                            MainActivity.this.Kontrol();
                            MainActivity.this.Bar();
                            return;
                        }else{return;}
                    }
                    Toast.makeText(MainActivity.this.getApplication(), "Not enough money for House", Toast.LENGTH_SHORT).show();
                }
            }
            RandomEvent(position+8);
        }
    }

    void RandomEvent(int secim)
    {
        /*  secim değerine göre gerçekleşen olay
            50=uyku
            0=record video
            1=Burger shop
            2=RecordVlog
            3=LetsPlay
            4=SmallAd
            5=BiggerAd
            6=Youtube Movie
            7=HollyWood movie
            8=Hot Dog
            9=blueBull
            10=restaurant
            11=steroit
            12=gym
            13=GoPro
            14=Gaming Computer
            15=House
        */
        Random random=new Random();
        int ihtimal=random.nextInt(100);
        Toast RandomEventToast=Toast.makeText(getApplicationContext(),null,Toast.LENGTH_LONG);
        switch (secim)
        {
            case 50:{
                    if(Ev==true) {
                        if (ihtimal == 1) {
                            RandomEventToast.setText("There was fire in your apartment last night and you lost your house");
                            RandomEventToast.show();
                            Ev = false;
                        }
                    }
                        else
                        {
                            if(ihtimal<3) {
                                RandomEventToast.setText("A poisonous spider bitted you and you had to pay 200$ hospital bill ");
                                RandomEventToast.show();
                                money = money - 200;
                            }
                        }
                     break;}
            case 0:{
                if (ihtimal<5)
                {
                    RandomEventToast.setText("Your video got strike you lost 100$ ");
                    RandomEventToast.show();
                    money=money-100;
                }
                if(ihtimal>=5 && ihtimal<10)
                {
                    RandomEventToast.setText("you fell down from chair on video you lose 150 $ but got 150 sub");
                    RandomEventToast.show();
                    money=money-150;
                    subs=subs+150;
                }
                break;}
            case 1: {
                if(ihtimal<5)
                {
                    RandomEventToast.setText("you got too tired and cant upload video today -50 sub");
                    RandomEventToast.show();
                    subs=subs-50;
                }
                if(ihtimal>=5 && ihtimal<10)
                {
                    RandomEventToast.setText("you got fight with one of the customers cant get money from job");
                    RandomEventToast.show();
                    money=money-60;
                }break;}
            case 2: {
                if(GoPro==true) {
                    if (ihtimal < 5) {
                        RandomEventToast.setText("your goPro got broken");
                        RandomEventToast.show();
                        GoPro=false;
                    }
                    if(ihtimal>=5 && ihtimal<10)
                    {
                        RandomEventToast.setText("you saw pewdiepie at mcdonalt and talked with him on your video");
                        RandomEventToast.show();
                        subs=subs+1500;
                    }
                }
                break;}
            case 3:{
                if(f8OyunBilgisayar==true)
                {
                    if(ihtimal<5)
                    {
                        RandomEventToast.setText("Your pc had broken");
                        RandomEventToast.show();
                        f8OyunBilgisayar=false;
                    }
                    if(ihtimal>=5 && ihtimal<20)
                    {
                        RandomEventToast.setText("A new game released -60$");
                        RandomEventToast.show();
                        money=money-60;
                    }
                }
            break;}
            case 4:{
                if(subs>5000)
                {
                    if(ihtimal<5)
                    {
                        RandomEventToast.setText("your fans didnt like ad subs-1000");
                        RandomEventToast.show();
                        subs=subs-1000;
                    }
                }
            break;}
            case 5:{
                if(subs>20000)
                {
                    if(ihtimal<5)
                    {
                        RandomEventToast.setText("your fans didnt like ad subs-1000");
                        RandomEventToast.show();
                        subs=subs-10000;
                    }
                }
            break;}
            case 6:{
                if(subs>200000)
                {
                    if(ihtimal<5)
                    {
                        RandomEventToast.setText("your fans didnt like movie subs-10000");
                        RandomEventToast.show();
                        subs=subs-100000;
                    }
                }
                break;}
        case 7:{
        if(subs>1000000)
        {
            if(ihtimal<5)
            {
                RandomEventToast.setText("your fans didnt like movie subs-300000");
                RandomEventToast.show();
                subs=subs-300000;
            }
        }
        break;}
            case 8:{
                if(money>5)
                {
                    if(ihtimal<5)
                    {
                        RandomEventToast.setText("Hot dog was rotten 20$ hospital bill");
                        RandomEventToast.show();
                        money=money-20;
                    }
                }
                break;}
            case 9:{
                if(money>20)
                {
                    if(ihtimal<5)
                    {
                        RandomEventToast.setText("You have drink too much of blue bull");
                        RandomEventToast.show();
                        money=money-50;
                    }
                }
                break;}
            case 10:{
                if(money>20)
                {
                    if(ihtimal<5)
                    {
                        RandomEventToast.setText("You had to pay for your gf too double bill");
                        RandomEventToast.show();
                        money=money-20;
                    }
                }
                break;}
            case 11:{
                if(money>500)
                {
                    if(ihtimal<25)
                    {
                        RandomEventToast.setText("steroits were venomus and have no effect");
                        RandomEventToast.show();
                        maxhealt=maxhealt-50;
                    }
                }
                break;}
            case 12:{
                if(money>500)
                {
                    if(ihtimal<25)
                    {
                        RandomEventToast.setText("you were too tried from gym and cant upload a video");
                        RandomEventToast.show();
                        subs=subs-1000;
                    }
                }
                break;}
            case 13:{
                if(money>1000)
                {
                    if(ihtimal<5)
                    {
                        RandomEventToast.setText("GoPro that you have bought were broken");
                        RandomEventToast.show();
                        GoPro=false;
                    }
                }
                break;}
            case 14:{
                if(money>2000)
                {
                    if(ihtimal<5)
                    {
                        RandomEventToast.setText("Gaming computers mobo were broken 700$");
                        RandomEventToast.show();
                        money=money-700;
                    }
                }
                break;}
    }

        if(money<0)
            money=0;
        if(subs<0)
            subs=0;

    }

    public MainActivity() {
        this.healt = 50;
        this.energy = 70;
        this.subs = 0;
        this.money = 0;
        this.GoPro = false;
        this.f8OyunBilgisayar = false;
        this.Ev = false;


        this.listinfo = new String[]{"sleep                                 ", "GoPro No!                                       ", "Gaming Computer No!                                     ", "House No!                                           ", "Subscriber:0"};
        this.listJobs = new String[]{"Record A video                                        ", "Burger Shop                                     ", "Record Vlog                                     ", "Lets Play                                       ", "Small Ad                                        ", "Bigger Ad                                       ", "Youtube Movie                                       ","Hollywood Movie                                      "};
        this.listShop = new String[]{"Hot Dog(5$)                                       ", "Blue Bull(20$)                                      ", "restaurant(20$)                                     ","Steroit(500$)                                        ","Gym(500$)                                            ", "Go Pro(1000$)                                       ", "Gaming Computer(2000$)                                      ", "House(5000$)                                        "};

    }



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);

        listviewinfo=(ListView)findViewById(R.id.listinfo);
        String infodizi=getString(R.string.app_name);
        TextView ter=(TextView) findViewById(R.id.textView);
        ter.setText(infodizi);
        listviewinfo.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if (position != 0) {
                    return;
                }
                if (MainActivity.this.Ev)
                {
                    if(energy<maxenergy) {
                        MainActivity.this.energy += 10;
                        MainActivity.this.Kontrol();
                        MainActivity.this.Bar();
                        return;
                    }else{return;}
                }
                if(energy<maxenergy) {
                    MainActivity.this.healt -= 5;
                    MainActivity.this.energy += 10;
                    MainActivity.this.Kontrol();
                    MainActivity.this.Bar();
                }else{return;}
                RandomEvent(50);
            }
        });
        ArrayAdapter<String> infoAdaptor=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,listinfo);
        listviewinfo.setAdapter(infoAdaptor);


        this.listViewJobs = (ListView) findViewById(R.id.listjobs);
        this.listViewJobs.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, this.listJobs));
        this.listViewJobs.setOnItemClickListener(new C01672());
        this.listViewshop = (ListView) findViewById(R.id.listshop);
        this.listViewshop.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, this.listShop));
        this.listViewshop.setOnItemClickListener(new C01683());
        //Yenile();
        TabHost th = (TabHost) findViewById(R.id.tabHost);
        th.setup();
        TabSpec tinfo = th.newTabSpec("tinfo");
        tinfo.setIndicator("info");
        tinfo.setContent(R.id.linearLayout);
        th.addTab(tinfo);
        TabSpec tjobs = th.newTabSpec("tjobs");
        tjobs.setIndicator("jobs");
        tjobs.setContent(R.id.linearLayout2);
        th.addTab(tjobs);
        TabSpec tshop = th.newTabSpec("tshop");
        tshop.setIndicator("shop");
        tshop.setContent(R.id.linearLayout3);
        th.addTab(tshop);
    }

    void Yenile() {
        this.listinfo[4] = "Subscriber : " + String.valueOf(this.subs);
        ArrayAdapter<String> infoAdaptor=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,listinfo);
        listviewinfo.setAdapter(infoAdaptor);

    }

    void Kontrol() {
        if (this.healt <= 0) {
            AlertDialog alertMessage = new Builder(this).create();
            alertMessage.setTitle("You Are Dead");
            alertMessage.setMessage("All items money and subscriber resetted");
            alertMessage.show();
            this.money = 0;
            this.healt = 30;
            this.energy = 70;
            this.subs = 0;
            this.GoPro = false;
            this.f8OyunBilgisayar = false;
            this.Ev = false;
            Bar();
        }
        if (this.energy <= 0) {
            AlertDialog alertMessage = new Builder(this).create();
            alertMessage.setTitle("You pass out");
            alertMessage.setMessage("All your money is gone!!");
            alertMessage.show();
            this.money = 0;
            this.healt = 30;
            this.energy = 70;
            Bar();
        }
    }

    void Bar() {
        if (this.healt > maxhealt) {
            this.healt = maxhealt;
        }
        if (this.energy > maxenergy) {
            this.energy = maxenergy;
        }

        if(healt<20)
        {
            Toast.makeText(getApplicationContext(),"Watch out! About to die!!",Toast.LENGTH_SHORT).show();
        }
        if(energy<20)
        {
            Toast.makeText(getApplicationContext(),"Watch out! About to pass out!!",Toast.LENGTH_SHORT).show();
        }

        ((TextView)findViewById(R.id.Subs_Count)).setText(String.valueOf(subs));

        ((TextView) findViewById(R.id.tv_Energy)).setText("ENERGY: "+ String.valueOf(this.energy)+"/"+String.valueOf(maxenergy));
        ((TextView) findViewById(R.id.tv_Health)).setText("HUNGRY: "+ String.valueOf(this.healt)+"/"+String.valueOf(maxhealt));
        ProgressBar pbenergj = (ProgressBar) findViewById(R.id.progressBarenergy);
        ProgressBar pbhealt = (ProgressBar) findViewById(R.id.progressBarhealt);
        ((TextView) findViewById(R.id.tmoney)).setText(String.valueOf(this.money));
        pbenergj.setProgress(this.energy);
        pbhealt.setProgress(this.healt);
        pbenergj.setMax(maxenergy);
        pbhealt.setMax(maxhealt);
        Yenile();
    }
}