package com.mulitlevelrecyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.mulitlevelrecyclerview.databinding.ItemLayoutBinding;
import com.mulitlevelrecyclerview.databinding.ViewTypeQuestionCheckBox4Binding;
import com.mulitlevelrecyclerview.databinding.ViewTypeQuestionCheckboxOption3Binding;
import com.mulitlevelrecyclerview.databinding.ViewTypeQuestionCheckboxOption5Binding;
import com.mulitlevelrecyclerview.databinding.ViewTypeQuestionCheckboxOption6Binding;
import com.mulitlevelrecyclerview.databinding.ViewTypeQuestionRadioOption2Binding;
import com.mulitlevelrecyclerview.databinding.ViewTypeQuestionRadioOption3Binding;
import com.mulitlevelrecyclerview.databinding.ViewTypeQuestionRadioOption4Binding;
import com.multilevelview.MultiLevelAdapter;
import com.multilevelview.MultiLevelRecyclerView;
import com.multilevelview.models.RecyclerViewItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class MyAdapter extends MultiLevelAdapter {

    private Holder mViewHolder;
    private LayoutInflater inflater;
    private Context mContext;
    private List<Item> mListItems = new ArrayList<>();
    private Item mItem;
    private MultiLevelRecyclerView mMultiLevelRecyclerView;
    private static final int CHECK_BOX_3 = 0;
    private static final int CHECK_BOX_4 = 1;
    private static final int CHECK_BOX_5 = 2;
    private static final int CHECK_BOX_6 = 3;
    private static final int RADIO_BOX_2 = 4;
    private static final int RADIO_BOX_3 = 5;
    private static final int RADIO_BOX_4 = 6;
    private static final int ITEM_LAYOUT = 7;

    public MyAdapter(Context mContext, List<Item> mListItems, MultiLevelRecyclerView mMultiLevelRecyclerView) {
        super(mListItems);
        this.mListItems = mListItems;
        inflater = LayoutInflater.from(mContext);
        this.mContext = mContext;
        this.mMultiLevelRecyclerView = mMultiLevelRecyclerView;
    }

    private void setExpandButton(ImageView expandButton, boolean isExpanded) {
        // set the icon based on the current state
        expandButton.setImageResource(isExpanded ? R.drawable.ic_keyboard_arrow_down_black_24dp : R.drawable.ic_keyboard_arrow_up_black_24dp);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding;
        switch (viewType) {
            case CHECK_BOX_3:
                binding = DataBindingUtil.inflate(inflater, R.layout.view_type_question_checkbox_option_3, parent, false);
                return new Holder((ViewTypeQuestionCheckboxOption3Binding) binding);
            case CHECK_BOX_4:
                binding = DataBindingUtil.inflate(inflater, R.layout.view_type_question_check_box_4, parent, false);
                return new Holder((ViewTypeQuestionCheckBox4Binding) binding);
            case CHECK_BOX_5:
                binding = DataBindingUtil.inflate(inflater, R.layout.view_type_question_checkbox_option_5, parent, false);
                return new Holder((ViewTypeQuestionCheckboxOption5Binding) binding);
            case CHECK_BOX_6:
                binding = DataBindingUtil.inflate(inflater, R.layout.view_type_question_checkbox_option_6, parent, false);
                return new Holder((ViewTypeQuestionCheckboxOption6Binding) binding);
            case RADIO_BOX_2:
                binding = DataBindingUtil.inflate(inflater, R.layout.view_type_question_radio_option_2, parent, false);
                return new Holder((ViewTypeQuestionRadioOption2Binding) binding);
            case RADIO_BOX_3:
                binding = DataBindingUtil.inflate(inflater, R.layout.view_type_question_radio_option_3, parent, false);
                return new Holder((ViewTypeQuestionRadioOption3Binding) binding);
            case RADIO_BOX_4:
                binding = DataBindingUtil.inflate(inflater, R.layout.view_type_question_radio_option_4, parent, false);
                return new Holder((ViewTypeQuestionRadioOption4Binding) binding);
            case ITEM_LAYOUT:
                binding = DataBindingUtil.inflate(inflater, R.layout.item_layout, parent, false);
                return new Holder((ItemLayoutBinding) binding);
            default:
                break;
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        int viewType = 0;
        Item item = mListItems.get(position);
        if (item.getLevel() == 0) {
            viewType = ITEM_LAYOUT;
        } else {
            if (!item.getTpye_question().isEmpty() && item.getTpye_question().equals("checkbox")) {
                switch (item.getTotal_answer()) {
                    case 3:
                        viewType = CHECK_BOX_3;
                        break;
                    case 4:
                        viewType = CHECK_BOX_4;
                        break;
                    case 5:
                        viewType = CHECK_BOX_5;
                        break;
                    case 6:
                        viewType = CHECK_BOX_6;
                        break;
                }
            } else {
                switch (item.getTotal_answer()) {
                    case 2:
                        viewType = RADIO_BOX_2;
                        break;
                    case 3:
                        viewType = RADIO_BOX_3;
                        break;
                    case 4:
                        viewType = RADIO_BOX_4;
                        break;
                }
            }
        }

        return viewType;
    }

    public static final String TAG = MyAdapter.class.getSimpleName();
    boolean isNext = false;

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        mViewHolder = (Holder) viewHolder;
        final List<RecyclerViewItem> q0 = new ArrayList<>();
        final List<RecyclerViewItem> q1 = new ArrayList<>();
        final List<RecyclerViewItem> q2 = new ArrayList<>();
        final List<RecyclerViewItem> q3 = new ArrayList<>();
        final List<RecyclerViewItem> list = new ArrayList<>();
        list.add(0, new Item(3, "", "In what kind of setting (context, storyline) does the violence occur?",
                "", "radiobox", 2, 0, "Fantastical", "Realistic", "", "", "", ""));
        list.add(1, new Item(4, "", "Does the game have a pixelated or childlike style?",
                "", "radiobox", 2, 0, "Yes", "No", "", "", "", ""));
        list.add(2, new Item(5, "", "How would you describe the reactions to violence?", "", "radiobox", 2,
                0, "Unrealistic", "Realistic", "", "", "", ""));
        list.add(3, new Item(6, "", "How is this violence presented in the game?", "", "checkbox", 6, 0, "Referred to",
                "Implied but not seen", "Rarely depicted from a distant perspective", "Often depicted from a distant perspective",
                "Rarely depicted from a close-up perspective", "Often depicted from a close-up perspective"));
        list.add(4, new Item(7, "", "What is the level of blood and/or gore associated with this violence?",
                "", "radiobox", 4, 0, "None", "Mild/Limited", "Moderate", "High", "", ""));
        list.add(5, new Item(8, "", "How would you describe the general motivation for violence in the game?", "", "radiobox",
                3, 0, "Positive (e.g., protagonist defending civilians)", "Neutral (e.g., no real storyline)", "Negative (e.g., protagonist committing violent crimes)", "", "", ""));
        list.add(6, new Item(9, "", "Does the game take place in a realistic or historical war setting?", "",
                "radiobox", 2, 0, "Yes", "No", "", "", "", ""));
        list.add(7, new Item(10, "", "Can innocent or defenseless characters be seriously injured or killed?", "", "radiobox",
                3, 0, "No", "Yes, with consequences", "Yes, without consequences", "", "", ""));
        list.add(8, new Item(11, "", "Is the player rewarded or otherwise stimulated to use the most aggressive, cruel or bloody violent acts available?", "",
                "radiobox", 2, 0, "Yes", "No", "", "", "", ""));
        list.add(9, new Item(12, "", "Are there any disturbing elements such as fierce sounds, sinister or intimidating characters, or dark overtones?", "",
                "radiobox", 2, 0, "Yes", "No", "", "", "", ""));
        q0.add(new Item(23, "", "Does the game contain pictures or sounds likely to be scary or horrifying?",
                "Please note that this question does notrefer to user-generated content.", "radiobox",
                2, 1, "Yes", "No", "", "", "", ""));
        q1.add(0, new Item(2, "VIOLENCE AGAINST HUMANS", "Does the game contain violence or implied violence against humans?",
                "", "radiobox", 2, 1, "Yes", "No", "", "", "", ""));

        q2.add(0, new Item(3, "FEAR", "In what kind of setting (context, storyline) does the violence occur?",
                "", "radiobox", 2, 0, "Fantastical", "Realistic", "", "", "", ""));
        q3.add(0, new Item(13, "VIOLENCE AGAINST NON-HUMANS", "Does the game contain violence against anything other than humans (e.g., animals, fantasy creatures, robots)?",
                "", "radiobox", 2, 1, "Yes", "No", "", "", "", ""));
//        q1.add(2, new Item(4, "VIOLENCE AGAINST HUMANS", "Does the game have a pixelated or childlike style?",
//                "", "radiobox", 2, 0, "Yes", "No", "", "", "", ""));
//        q1.add(3, new Item(5, "VIOLENCE AGAINST HUMANS", "How would you describe the reactions to violence?",
//                "", "radiobox", 2, 0, "Unrealistic", "Realistic", "", "", "", ""));

        mItem = mListItems.get(i);
        Log.d("onclick", "onBindViewHolder: " + mListItems.size());
        final Item item = mListItems.get(i);
        if (item.getLevel() == 0) {
            mViewHolder.itemLayoutBinding.setVariable(BR.item, item);
            mViewHolder.itemLayoutBinding.executePendingBindings();
//            if (item.hasChildren() && item.getChildren().size() > 0) {
//               // setExpandButton(mViewHolder.itemLayoutBinding.imageView, mItem.isExpanded());
//               // mViewHolder.itemLayoutBinding.expandField.setVisibility(View.VISIBLE);
//            } else {
//                mViewHolder.itemLayoutBinding.expandField.setVisibility(View.GONE);
//            }
        } else {
            if (!item.getTpye_question().isEmpty() && item.getTpye_question().equals("checkbox")) {
                switch (item.getTotal_answer()) {
                    case 3:
                        checkTopic(item, mViewHolder.viewTypeQuestionCheckboxOption3Binding.topic, mViewHolder.viewTypeQuestionCheckboxOption3Binding.noteQuestion);
                        mViewHolder.viewTypeQuestionCheckboxOption3Binding.setVariable(BR.item, item);
                        mViewHolder.viewTypeQuestionCheckboxOption3Binding.executePendingBindings();
                        break;
                    case 4:
                        checkTopic(item, mViewHolder.viewTypeQuestionCheckBox4Binding.topic, mViewHolder.viewTypeQuestionCheckBox4Binding.noteQuestion);
                        mViewHolder.viewTypeQuestionCheckBox4Binding.setVariable(BR.item, item);
                        mViewHolder.viewTypeQuestionCheckBox4Binding.executePendingBindings();
                        break;
                    case 5:
                        checkTopic(item, mViewHolder.viewTypeQuestionCheckboxOption5Binding.topic, mViewHolder.viewTypeQuestionCheckboxOption5Binding.noteQuestion);
                        mViewHolder.viewTypeQuestionCheckboxOption5Binding.setVariable(BR.item, item);
                        mViewHolder.viewTypeQuestionCheckboxOption5Binding.executePendingBindings();
                        break;
                    case 6:
                        checkTopic(item, mViewHolder.viewTypeQuestionCheckboxOption6Binding.topic, mViewHolder.viewTypeQuestionCheckboxOption6Binding.noteQuestion);
                        mViewHolder.viewTypeQuestionCheckboxOption6Binding.setVariable(BR.item, item);
                        mViewHolder.viewTypeQuestionCheckboxOption6Binding.executePendingBindings();
                        break;
                }
            } else {
                switch (item.getTotal_answer()) {
                    case 2:
                        checkTopic(item, mViewHolder.viewTypeQuestionRadioOption2Binding.topic, mViewHolder.viewTypeQuestionRadioOption2Binding.noteQuestion);
                        mViewHolder.viewTypeQuestionRadioOption2Binding.setVariable(BR.item, item);
                        mViewHolder.viewTypeQuestionRadioOption2Binding.executePendingBindings();
                        switch (item.getId()) {
                            case 1:
                                mViewHolder.viewTypeQuestionRadioOption2Binding.groupRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                    @Override
                                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                                        switch (checkedId) {
                                            case R.id.radio1:
                                                Log.d(TAG, "onCheckedChanged: radio1");
                                                mMultiLevelRecyclerView.toggleItemsGroup(item.getPosition());
                                                item.addChildren(q1);
                                                mMultiLevelRecyclerView.toggleItemsGroup(item.getPosition());
                                                break;
                                            case R.id.radio2:
                                                Log.d(TAG, "onCheckedChanged: radio2");
                                                mMultiLevelRecyclerView.toggleItemsGroup(item.getPosition());
                                                for (int j = 0; j < mListItems.size(); j++) {
                                                    Item item1 = mListItems.get(j);
                                                    if (item1.getLevel() == 0 && item1.getTopic().equals("FEAR")) {
                                                        Log.d(TAG, "onCheckedChanged: " + j);
                                                        mListItems.remove(item1);
                                                        notifyItemRangeRemoved(j, 1);
                                                        break;
                                                    }
                                                }
                                                item.addChildren(q2);
                                                mMultiLevelRecyclerView.toggleItemsGroup(item.getPosition());
                                                break;
                                        }
                                    }
                                });
                                break;
                            case 2:
                                mViewHolder.viewTypeQuestionRadioOption2Binding.groupRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                    @Override
                                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                                        switch (checkedId) {
                                            case R.id.radio1:
                                                Log.d(TAG, "onCheckedChanged: radio1");
                                                mMultiLevelRecyclerView.toggleItemsGroup(item.getPosition());
                                                item.addChildren(list);
                                                mMultiLevelRecyclerView.toggleItemsGroup(item.getPosition());
                                                break;
                                            case R.id.radio2:
                                                Log.d(TAG, "onCheckedChanged: radio2");
                                                mMultiLevelRecyclerView.toggleItemsGroup(item.getPosition());
                                                item.addChildren(q3);
                                                mMultiLevelRecyclerView.toggleItemsGroup(item.getPosition());
                                                break;
                                        }
                                    }
                                });
                                break;
                            case 3:

                                break;
                        }
                        break;

                    case 3:
                        checkTopic(item, mViewHolder.viewTypeQuestionRadioOption3Binding.topic, mViewHolder.viewTypeQuestionRadioOption3Binding.noteQuestion);
                        mViewHolder.viewTypeQuestionRadioOption3Binding.setVariable(BR.item, item);
                        mViewHolder.viewTypeQuestionRadioOption3Binding.executePendingBindings();
                        break;
                    case 4:
                        checkTopic(item, mViewHolder.viewTypeQuestionRadioOption4Binding.topic, mViewHolder.viewTypeQuestionRadioOption4Binding.noteQuestion);
                        mViewHolder.viewTypeQuestionRadioOption4Binding.setVariable(BR.item, item);
                        mViewHolder.viewTypeQuestionRadioOption4Binding.executePendingBindings();
                        break;
                }
            }
        }
    }

    private void addLevel(int i, List<RecyclerViewItem> q2) {
        List<RecyclerViewItem> list = new ArrayList<>();
        for (int j = 0; j < mListItems.size(); j++) {
            if (mListItems.get(j).getLevel() == 0) {
                list.add(mListItems.get(j));
            }
        }
        Log.d(TAG, "addLevel: " + list.size());
        switch (i) {
            case 1:
                RecyclerViewItem item = list.get(1);
                item.addChildren(q2);
                mMultiLevelRecyclerView.toggleItemsGroup(item.getPosition());
                break;
        }
    }

    private void checkTopic(Item item, TextView topic, TextView note_question) {
        if ("".equals(item.getTopic())) {
            topic.setVisibility(View.GONE);
        } else {
            topic.setVisibility(View.VISIBLE);
        }
        if ("".equals(item.getNote_question())) {
            note_question.setVisibility(View.GONE);
        } else {
            note_question.setVisibility(View.VISIBLE);
        }
    }

    private class Holder extends RecyclerView.ViewHolder {

        private ViewTypeQuestionCheckboxOption3Binding viewTypeQuestionCheckboxOption3Binding;
        private ViewTypeQuestionCheckBox4Binding viewTypeQuestionCheckBox4Binding;
        private ViewTypeQuestionCheckboxOption5Binding viewTypeQuestionCheckboxOption5Binding;
        private ViewTypeQuestionCheckboxOption6Binding viewTypeQuestionCheckboxOption6Binding;
        private ViewTypeQuestionRadioOption2Binding viewTypeQuestionRadioOption2Binding;
        private ViewTypeQuestionRadioOption3Binding viewTypeQuestionRadioOption3Binding;
        private ViewTypeQuestionRadioOption4Binding viewTypeQuestionRadioOption4Binding;
        private ItemLayoutBinding itemLayoutBinding;

        public Holder(ViewTypeQuestionCheckboxOption3Binding viewTypeQuestionCheckboxOption3Binding) {
            super(viewTypeQuestionCheckboxOption3Binding.getRoot());
            this.viewTypeQuestionCheckboxOption3Binding = viewTypeQuestionCheckboxOption3Binding;
        }

        public Holder(ViewTypeQuestionCheckBox4Binding viewTypeQuestionCheckBox4Binding) {
            super(viewTypeQuestionCheckBox4Binding.getRoot());
            this.viewTypeQuestionCheckBox4Binding = viewTypeQuestionCheckBox4Binding;
        }

        public Holder(ViewTypeQuestionCheckboxOption5Binding viewTypeQuestionCheckboxOption5Binding) {
            super(viewTypeQuestionCheckboxOption5Binding.getRoot());
            this.viewTypeQuestionCheckboxOption5Binding = viewTypeQuestionCheckboxOption5Binding;
        }

        public Holder(ViewTypeQuestionCheckboxOption6Binding viewTypeQuestionCheckboxOption6Binding) {
            super(viewTypeQuestionCheckboxOption6Binding.getRoot());
            this.viewTypeQuestionCheckboxOption6Binding = viewTypeQuestionCheckboxOption6Binding;
        }

        public Holder(final ViewTypeQuestionRadioOption2Binding viewTypeQuestionRadioOption2Binding) {
            super(viewTypeQuestionRadioOption2Binding.getRoot());
            this.viewTypeQuestionRadioOption2Binding = viewTypeQuestionRadioOption2Binding;
        }

        public Holder(ViewTypeQuestionRadioOption3Binding viewTypeQuestionRadioOption3Binding) {
            super(viewTypeQuestionRadioOption3Binding.getRoot());
            this.viewTypeQuestionRadioOption3Binding = viewTypeQuestionRadioOption3Binding;
        }

        public Holder(ViewTypeQuestionRadioOption4Binding viewTypeQuestionRadioOption4Binding) {
            super(viewTypeQuestionRadioOption4Binding.getRoot());
            this.viewTypeQuestionRadioOption4Binding = viewTypeQuestionRadioOption4Binding;
        }

        public Holder(final ItemLayoutBinding itemLayoutBinding) {
            super(itemLayoutBinding.getRoot());
            this.itemLayoutBinding = itemLayoutBinding;
            itemLayoutBinding.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // set click event on expand button here
                    mMultiLevelRecyclerView.toggleItemsGroup(getAdapterPosition());
                    // rotate the icon based on the current state
                    // but only here because otherwise we'd see the animation on expanded items too while scrolling
                    // itemLayoutBinding.imageView.animate().rotation(mListItems.get(getAdapterPosition()).isExpanded() ? -180 : 0).start();
                    Toast.makeText(mContext, String.format(Locale.ENGLISH, "Item at position %d is expanded: %s", getAdapterPosition(), mItem.isExpanded()), Toast.LENGTH_SHORT).show();
                }
            });
        }
//        TextView mTitle, mSubtitle;
//        ImageView mExpandIcon;
//        LinearLayout mTextBox, mExpandButton;

//        Holder(View itemView) {
//            super(itemView);
////            mTitle = (TextView) itemView.findViewById(R.id.title);
////            mSubtitle = (TextView) itemView.findViewById(R.id.subtitle);
////            mExpandIcon = (ImageView) itemView.findViewById(R.id.image_view);
////            mTextBox = (LinearLayout) itemView.findViewById(R.id.text_box);
////            mExpandButton = (LinearLayout) itemView.findViewById(R.id.expand_field);
//
//            // The following code snippets are only necessary if you set multiLevelRecyclerView.removeItemClickListeners(); in MainActivity.java
//            // this enables more than one click event on an item (e.g. Click Event on the item itself and click event on the expand button)
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    //set click event on item here
//                    Toast.makeText(mContext, String.format(Locale.ENGLISH, "Item at position %d was clicked!", getAdapterPosition()), Toast.LENGTH_SHORT).show();
//                }
//            });
//
//            //set click listener on LinearLayout because the click area is bigger than the ImageView
//            mExpandButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    // set click event on expand button here
//
//                    // rotate the icon based on the current state
//                    // but only here because otherwise we'd see the animation on expanded items too while scrolling
//                    mExpandIcon.animate().rotation(mListItems.get(getAdapterPosition()).isExpanded() ? -180 : 0).start();
//
//                    Toast.makeText(mContext, String.format(Locale.ENGLISH, "Item at position %d is expanded: %s", getAdapterPosition(), mItem.isExpanded()), Toast.LENGTH_SHORT).show();
//                }
//            });
//        }

        public void bindData(int i, Holder holder, RadioButton radio1, RadioButton
                radio2, RadioButton radio3, RadioButton radio4) {
//            mMultiLevelRecyclerView.toggleItemsGroup(getAdapterPosition());
//            if (i == 0) {
//
//                });
//            }
//
//            Toast.makeText(mContext, String.format(Locale.ENGLISH, "Item at position %d is expanded: %s", getAdapterPosition(), mItem.isExpanded()), Toast.LENGTH_SHORT).show();
        }
    }


}
