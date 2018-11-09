package com.jpndev.dbapp.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.constraint.Guideline;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.jpndev.dbapp.R;
import com.jpndev.dbapp.db.model.Note;
import com.jpndev.dbapp.utility.LogUtils;
import com.jpndev.utilitylibrary.CustomFontTextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterRcvNoteItem extends  RecyclerView.Adapter<RecyclerView.ViewHolder> {

   // RcvNoteItemAdapter // AdapterRcvNoteItem
    private final int VIEW_TYPE_LOADING = -1;
    public List<Note> resultlist;
    public int totalcount=0;
    private Context context;
    private LayoutInflater layoutInflater;


    public  AdapterRcvNoteItem (Context context, List<Note> resultlist, int totalcount ) {
        this.context = context;
        this.resultlist = resultlist;
        this.totalcount = totalcount;
        this.layoutInflater = LayoutInflater.from(context);


    }
       public   AdapterRcvNoteItem (Context context , List<Note> resultlist) {
        this.context = context;
        this.resultlist = resultlist;
        this.totalcount = isValid(resultlist)?resultlist.size():0;
        this.layoutInflater = LayoutInflater.from(context);


    }
    public   AdapterRcvNoteItem (Context context ) {
        this.context = context;
        this.resultlist = new ArrayList<Note>();
        this.totalcount = 0;
        this.layoutInflater = LayoutInflater.from(context);


    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder rcv=null;
   /*     View rootView = LayoutInflater.from(context).inflate(R.layout.recycler_item_feed, parent, false);
        if (viewType==VIEW_TYPE_LOADING) {
            rootView = LayoutInflater.from(context).inflate(R.layout.layout_loading_item, parent, false);
            rcv = new AdapterAuction.LoadingViewHolder(rootView);
        }
        else if (viewType==0) {
            rootView = LayoutInflater.from(context).inflate(R.layout.recycler_item_auction, parent, false);
            rcv = new AdapterAuction.ViewHolder(rootView);
        }*/
        View rootView = LayoutInflater.from(context).inflate(R.layout.rcv_note_item, parent, false);
        rcv = new  AdapterRcvNoteItem.ViewHolder(rootView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder topholder, int position) {
        try {
            if(topholder!=null) {
                if (topholder instanceof  AdapterRcvNoteItem.LoadingViewHolder) {
                    AdapterRcvNoteItem.LoadingViewHolder loadingViewHolder = ( AdapterRcvNoteItem.LoadingViewHolder) topholder;
                    loadingViewHolder.progressBar.setIndeterminate(true);
                }else if (topholder instanceof  AdapterRcvNoteItem.ViewHolder) {
                    AdapterRcvNoteItem.ViewHolder holder = ( AdapterRcvNoteItem.ViewHolder) topholder;
                    setViewholder(holder,position);
                }
                else
                {
                }
            }
        } catch (Exception e) {
            LogUtils.LOGD("exception", "AdapterRcvNoteItem onBindViewHolder " + e.getMessage());
        }
    }
    private void setViewholder(ViewHolder holder, int position) {
        try {
            final Note results =  getItem(position);
            if(isValid(results)) {
                defSetText(holder.topicCtxv,results.getTitle());
                defSetText(holder.desCtxv,results.getDescription());
        }
    } catch (Exception e) {
                LogUtils.LOGD("exception", "AdapterRcvNoteItem setViewholder " +position+" e  "+ e.getMessage());
            }
        }

    public Note getItem (int position) {

        Note results = null;
        if (isValid(resultlist, position))
            results = resultlist.get(position);
        return results;
    }
    @Override
    public int getItemCount() {
        return isValid(resultlist)?resultlist.size():0;
    }
    @Override
    public int getItemViewType(int position) {
        //  int pos=0;
    /*    //   pos=result90list.size()
        if(position==0)
            pos=position;
        else
        {

            pos=getItem(position) == null ? VIEW_TYPE_LOADING : position;
        }*/
        //  return position;

        return position;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    void postEventOnMainThread(final Object event) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                //BusProvider.getInstance().post(event);
                // bus.post(event);
            }
        });

    }

    public Boolean isValid(List list)
    {
        if(list!=null)
            if(list.size()>0)
                return  true;
        return  false;

    }

    public Boolean isValid(List list, int position)
    {
        if(isValid(list))
            if(list.size()>=position)
                return  true;
        return  false;

    }

    public Boolean isValid(Object object)
    {
        if(object!=null)
            return  true;
        return  false;

    }

    public Boolean isValid(String text) {
        if(text != null) if(!text.trim().equalsIgnoreCase("")) return true;
        return false;

    }

    public String defString(EditText text, String def) {
        if(text != null) if(isValid(text.getText() + "")) return text.getText() + "";
        return def;

    }

    public String defString(EditText text) {
        if(text != null) if(isValid(text.getText() + "")) return text.getText() + "";
        return "";

    }

    public String defString(String text, String def) {
        if(text != null) return text;
        return def;

    }

    public String defString(String text) {
        if(text != null) return text;
        return "";

    }

    public void defSetText(TextView textv, String text, String def) {
        if(isValid(textv))
            textv.setText(defString(text,def));

    }

    public void defSetText(TextView textv,String text) {
        if(isValid(textv))
            textv.setText(defString(text));

    }

    public void defSetText(EditText textv,String text, String def) {
        if(isValid(textv))
            textv.setText(defString(text,def));

    }

    public void defSetText(EditText textv,String text) {
        if(isValid(textv))
            textv.setText(defString(text));

    }

    static class LoadingViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar progressBar;

        public LoadingViewHolder(View itemView) {
            super(itemView);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar1);
        }
    }


    public class ViewHolder  extends RecyclerView.ViewHolder{
        private Guideline guideline;
    private Guideline guidelineXleft;
    private Guideline guidelineXright;
    private Guideline guidelineLogoLeft;
    private Guideline guidelineLogoRight;
    private Guideline guidelineHCenter;
    private Guideline guidelineVCenter;
   // private CardView retCardv;
    private Guideline cardGuidelineCenter;
    private Guideline cardGuidelineTop10;
    private Guideline cardGuidelineXLeft;
    private Guideline cardGuidelineXRight;
    private Guideline cardGuidelineXContentRight;
    private Guideline cardGuidelineXStarRight;
    private Guideline cardGuidelineHorizontal60;
    private Guideline cardGuidelineVCenter;
    private Guideline cardGuidelineH75;
    private Guideline cardGuidelineH78;
    private CustomFontTextView topicCtxv;
    private CustomFontTextView desCtxv;
    private View bottomView;

        public ViewHolder(View view) {
            super(view);
            guideline = (Guideline) view.findViewById(R.id.guideline);
            guidelineXleft = (Guideline) view.findViewById(R.id.guideline_xleft);
            guidelineXright = (Guideline) view.findViewById(R.id.guideline_xright);
            guidelineLogoLeft = (Guideline) view.findViewById(R.id.guideline_logo_left);
            guidelineLogoRight = (Guideline) view.findViewById(R.id.guideline_logo_right);
            guidelineHCenter = (Guideline) view.findViewById(R.id.guideline_h_center);
            guidelineVCenter = (Guideline) view.findViewById(R.id.guideline_v_center);
           // retCardv = (CardView) view.findViewById(R.id.ret_cardv);
            cardGuidelineCenter = (Guideline) view.findViewById(R.id.card_guideline_center);
            cardGuidelineTop10 = (Guideline) view.findViewById(R.id.card_guideline_top_10);
            cardGuidelineXLeft = (Guideline) view.findViewById(R.id.card_guideline_x_left);
            cardGuidelineXRight = (Guideline) view.findViewById(R.id.card_guideline_x_right);
            cardGuidelineXContentRight = (Guideline) view.findViewById(R.id.card_guideline_x_content_right);
            cardGuidelineXStarRight = (Guideline) view.findViewById(R.id.card_guideline_x_star_right);
            cardGuidelineHorizontal60 = (Guideline) view.findViewById(R.id.card_guideline_horizontal_60);
            cardGuidelineVCenter = (Guideline) view.findViewById(R.id.card_guideline_v_center);
            cardGuidelineH75 = (Guideline) view.findViewById(R.id.card_guideline_h_75);
            cardGuidelineH78 = (Guideline) view.findViewById(R.id.card_guideline_h_78);
            topicCtxv = (CustomFontTextView) view.findViewById(R.id.topic_ctxv);
            desCtxv = (CustomFontTextView) view.findViewById(R.id.des_ctxv);
            bottomView = (View) view.findViewById(R.id.bottom_view);
        }
    }
}