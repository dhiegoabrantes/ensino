package br.edu.nassau.pmob.componentes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.edu.nassau.pmob.componentes.R;
import br.edu.nassau.pmob.componentes.model.Pack;

/**
 * Created by dhiego on 22/09/15.
 */
public class MyCustomAdapter extends BaseAdapter{

    private Context context;
    private List<Pack> list;

    public MyCustomAdapter(Context context, List<Pack> packs ){
        super();
        this.context = context;
        this.list = packs;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Pack pack = list.get(position);
        View linha = LayoutInflater.from(this.context)
                .inflate(R.layout.custom_adapter_row, null);
        TextView packNameEditText = (TextView)
                linha.findViewById(R.id.packNameEditText);
        TextView trackNumberEditText = (TextView)
                linha.findViewById(R.id.trackNumberEditText);
        packNameEditText.setText(pack.getName());
        trackNumberEditText.setText(pack.getTrackNumber());
        return linha;
    }
}
