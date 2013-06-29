package net.sebastien;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import android.widget.TabHost.TabSpec;

public class Tirage extends Activity implements OnCheckedChangeListener  {
    /** Called when the activity is first created. */
  
    private TabHost monTabHost;
    ImageView monImage;
   
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        CheckBox check = (CheckBox)findViewById(R.id.check);
        check.setOnCheckedChangeListener(this);
        monImage = (ImageView)findViewById(R.id.monImage);
        
        final AutoCompleteTextView actv = (AutoCompleteTextView)findViewById(R.id.actv);
        
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, 
        		android.R.layout.simple_dropdown_item_1line,
        		new String[] {"English", "Hebrew", "Hindi", "Spanish", "German",
        		"Greek"});
        actv.setAdapter(aa);
        
        final MultiAutoCompleteTextView mactv = (MultiAutoCompleteTextView)findViewById(R.id.mactv);
        ArrayAdapter<String> aa2 = new ArrayAdapter<String>(this, 
        		android.R.layout.simple_dropdown_item_1line,
        		new String[] {"English", "Hebrew", "Hindi", "Spanish", "German",
        		"Greek"});
        mactv.setAdapter(aa2);
        mactv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
      
        final Button yat = (Button)findViewById(R.id.button1);
        yat.setOnClickListener(new OnClickListener() {

			
			public void onClick(View v) {
				ChiffreLoto1 yahoo = new ChiffreLoto1();
				final TextView yati = (TextView)findViewById(R.id.textView1);
				yati.setText(yahoo.tirageGagnant());
				final TextView yati1 = (TextView)findViewById(R.id.TextViewOnglet2);
				yati1.setText("vous allez bien?");
				final ImageView yati2 = (ImageView)findViewById(R.id.imageView1);
				yati2.setImageResource(R.drawable.apc3);		
			}
        	
        });
        
        	
        
        
    
     // Récupération du TabHost
     monTabHost =(TabHost) findViewById(R.id.TabHost01);
    // Avant d’ajouter des onglets, il faut impérativement appeler la méthode
    // setup() du TabHost
    monTabHost.setup();
    // Nous ajoutons les 3 onglets dans notre TabHost
    // Nous paramétrons le 1er Onglet
    TabSpec spec = monTabHost.newTabSpec("Loto");
    // Nous paramétrons le texte qui s’affichera dans l’onglet
    // ainsi que l’image qui se positionnera
    // au dessus du texte.
     spec.setIndicator("Euromillion");
     //,getResources().getDrawable(R.drawable.icon));
    // On spécifie le Layout qui s’affichera lorsque l’onglet sera sélectionné
    spec.setContent(R.id.Onglet1);
    // On ajoute l’onglet dans notre TabHost
    monTabHost.addTab(spec);
    // Vous pouvez ajouter des onglets comme ceci :
    monTabHost.addTab(monTabHost.newTabSpec("onglet_2").setIndicator(
    "Texte").setContent(R.id.Onglet2));
    monTabHost.addTab(monTabHost.newTabSpec("onglet_3").setIndicator(
    "checkBox").setContent(R.id.Onglet3));
    
    // Nous paramétrons un écouteur onTabChangedListner pour récupérer
    // le changement d’onglet.
    monTabHost.setOnTabChangedListener(
    new TabHost.OnTabChangeListener (){
    public void onTabChanged(String tabId){
    	// Vous pourrez exécuter du code lorsqu’un
    	// onglet est cliqué. Pour déterminer
    	// quel onglet a été cliqué, il
    	// vous suffira de vérifier le tabId envoyé lors
    	// du clic et d’exécuter votre code en
    	// conséquence.
    	Toast.makeText(Tirage.this, "L’onglet avec l’identifiant : "
    	+ tabId + " a été cliqué", Toast.LENGTH_SHORT).show();
    	}
    	}
    	);
    	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		if (isChecked){
			monImage.setImageResource(R.drawable.apc3);
		}else
			monImage.setImageResource(R.drawable.ingres);
	}
   


}