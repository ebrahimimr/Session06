package ir.mreonline.session06;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import ir.mreonline.session06.models.VehicleModel;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.viewHolder> {

    VehicleModel vModel;

    RecyclerAdapter(VehicleModel V) {
        vModel = V;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        viewHolder holder = new viewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        try{

            holder.txtType.setText("Type : "+ vModel.getVehicles().get(position).getType());
            holder.txtLat.setText("Let : " + vModel.getVehicles().get(position).getLat().toString());
            holder.txtLng.setText("Lng : "+vModel.getVehicles().get(position).getLng().toString());
            holder.txtBearing.setText("Bearing :"+vModel.getVehicles().get(position).getBearing().toString());
            Glide.with(holder.itemView).load(vModel.getVehicles().get(position).getImageUrl().toString() ).into(holder.imgView);
        }
        catch (Exception ex) {
            Log.d("myError", "onBindViewHolder: "+ex);
        }

    }


    @Override
    public int getItemCount() {
        Integer size = 0;
        try {
            size = vModel.getVehicles().size();
        } catch (Exception ex) {
            Log.d("myError", "getItemCount: "+ex);
        }

        return size;
    }

    class viewHolder extends RecyclerView.ViewHolder {
        TextView txtType;
        TextView txtLat;
        TextView txtLng;
        TextView txtBearing;
        ImageView imgView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            txtType = itemView.findViewById(R.id.txtType);
            txtLat = itemView.findViewById(R.id.txtLat);
            txtLng = itemView.findViewById(R.id.txtLng);
            txtBearing = itemView.findViewById(R.id.txtBearing);
            imgView = itemView.findViewById(R.id.imgView);
        }
    }
}
