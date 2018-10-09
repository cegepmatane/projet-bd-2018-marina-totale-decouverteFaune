package ca.qc.cgmatane.informatique.marinaconnect.vue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ca.qc.cgmatane.informatique.marinaconnect.R;
import ca.qc.cgmatane.informatique.marinaconnect.modele.EtreVivant;

public class CustomListAdapter extends BaseAdapter {

    private List<EtreVivant> listeEtreVivant;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter(Context aContext, List<EtreVivant> listeEtreVivant){
        this.context = aContext;
        if(this.listeEtreVivant != null){
            this.listeEtreVivant.clear();
        }
        this.listeEtreVivant = listeEtreVivant;
        layoutInflater = LayoutInflater.from(aContext);
    }

    public int getCount(){
        return listeEtreVivant.size();
    }

    public Object getItem(int position){
        return listeEtreVivant.get(position);
    }

    public long getItemId(int position){
        return position;
    }

    public View getView (int position, View convertView, ViewGroup parent){
        ViewHolder holder;
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.item_liste_faune,null);
            holder = new ViewHolder();
            holder.nomItemFauneView = (TextView)convertView.findViewById(R.id.texte_item_faune);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        EtreVivant etreVivant = this.listeEtreVivant.get(position);
        holder.nomItemFauneView.setText(etreVivant.getEspece());

        return convertView;
    }

    static class ViewHolder {
        TextView nomItemFauneView;
        //TextView populationView;
    }


}
