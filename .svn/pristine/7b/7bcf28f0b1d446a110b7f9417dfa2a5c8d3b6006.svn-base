package com.lingang.base;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.lingang.utils.adapterUtils.AnimationType;
import com.lingang.utils.adapterUtils.AnimationUtil;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * @name LinGang
 * @class name：com.lingang.base
 * @class describe
 * @anthor Administrator
 * @time 2017/7/3 0003 11:04
 * @change
 * @chang time
 * @class describe
 */
public abstract class RecycleLabAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {
    private static final String TAG = "RecycleLabAdapter";

    public static class VIEW_TYPE {
        public static final int HEADER = 0x0010;
        public static final int FOOTER = 0x0011;
    }

    /**
     * Base config
     */
    private List<T> mData;
    private Context mContext;
    private LayoutInflater mInflater;

    /**
     * Listener
     */
    private RecycleLabAdapter.OnItemClickListener mOnItemClickListener;
    private RecycleLabAdapter.OnItemLongClickListener mOnItemLongClickListener;
    private RecycleLabAdapter.OnRecyclerViewItemChildClickListener mChildClickListener;
    private RecycleLabAdapter.OnRecyclerViewItemChildLongClickListener mChildLongClickListener;

    /**
     * View type
     */
    private Map<Integer, Integer> layoutIdMap, viewTypeMap;
    private int mCurrentViewTypeValue = 0x0107;

    /**
     * Animation
     */
    private AnimationType mAnimationType;
    private int mAnimationDuration = 300;
    private boolean showItemAnimationEveryTime = false;
    private Interpolator mItemAnimationInterpolator;
    private RecycleLabAdapter.CustomAnimator mCustomAnimator;
    private int mLastItemPosition = -1;

    /**
     * header and footer
     */
    private LinearLayout mHeaderLayout;
    private LinearLayout mFooterLayout;
    private LinearLayout mCopyHeaderLayout = null;
    private LinearLayout mCopyFooterLayout = null;

    public RecycleLabAdapter(Context context) {
        this(context, null);
    }

    public RecycleLabAdapter(Context context, List<T> data) {
        mData = null == data ? new ArrayList<T>() : data;
        layoutIdMap = new HashMap<>();
        viewTypeMap = new HashMap<>();
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder baseViewHolder;
        switch (viewType) {
            case RecycleLabAdapter.VIEW_TYPE.HEADER://header
                baseViewHolder = new BaseViewHolder(mHeaderLayout, mContext);
                break;
            case RecycleLabAdapter.VIEW_TYPE.FOOTER://footer
                baseViewHolder = new BaseViewHolder(mFooterLayout, mContext);
                break;
            default:
                baseViewHolder = new BaseViewHolder(mInflater.inflate(layoutIdMap.get(viewType),
                        parent, false), mContext);
                initItemClickListener(baseViewHolder);

                break;
        }
        return baseViewHolder;
    }

    @Override
    public int getItemViewType(int position) {

        if (position < getHeaderViewCount()) {
            return RecycleLabAdapter.VIEW_TYPE.HEADER;
        } else if (position >= mData.size() + getHeaderViewCount()) {
            return RecycleLabAdapter.VIEW_TYPE.FOOTER;
        } else {
            int currentPosition = position - getHeaderViewCount();
            int currentLayoutId = getItemViewLayoutId(currentPosition, mData.get(currentPosition));
            if (!viewTypeMap.containsKey(currentLayoutId)) {
                mCurrentViewTypeValue++;
                viewTypeMap.put(currentLayoutId, mCurrentViewTypeValue);
                layoutIdMap.put(viewTypeMap.get(currentLayoutId), currentLayoutId);
            }
            return viewTypeMap.get(currentLayoutId);
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case RecycleLabAdapter.VIEW_TYPE.HEADER:
                // Do nothingd
                break;
            case RecycleLabAdapter.VIEW_TYPE.FOOTER:
                // Do nothing
                break;
            default:
                convert(holder, getItem(position - getHeaderViewCount()), position -
                        getHeaderViewCount());
                addAnimation(holder);
                break;
        }
    }

    protected final void addAnimation(final BaseViewHolder holder) {
        int currentPosition = holder.getAdapterPosition();
        if (null != mCustomAnimator) {
            mCustomAnimator.getAnimator(holder.itemView).setDuration(mAnimationDuration).start();
        } else if (null != mAnimationType) {
            if (showItemAnimationEveryTime || currentPosition > mLastItemPosition) {
                new AnimationUtil()
                        .setAnimationType(mAnimationType)
                        .setTargetView(holder.itemView)
                        .setDuration(mAnimationDuration)
                        .setInterpolator(mItemAnimationInterpolator)
                        .start();
                mLastItemPosition = currentPosition;
            }
        }
    }

    /**
     * init the baseViewHolder to register mOnItemClickListener and mOnItemLongClickListener
     *
     * @param holder
     */
    protected final void initItemClickListener(final BaseViewHolder holder) {
        if (null != mOnItemClickListener) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final int position = holder.getAdapterPosition() - getHeaderViewCount();
                    mOnItemClickListener.onItemClick(view, mData.get(position), position);
                }
            });
        }

        if (null != mOnItemLongClickListener) {
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    final int position = holder.getAdapterPosition() - getHeaderViewCount() - 1;
                    mOnItemLongClickListener.onItemLongClick(v, mData.get(position), position);
                    return true;
                }
            });
        }
    }

    /**
     * Base api
     */
    protected abstract void convert(BaseViewHolder holder, T item, int position);

    protected abstract int getItemViewLayoutId(int position, T item);

    protected T getItem(int position) {

        return mData.get(position);
    }

    @Override
    public int getItemCount() {

        return mData.size() + getHeaderViewCount() + getFooterViewCount();

    }


    /**
     * Listener api
     */
    public void setOnItemClickListener(RecycleLabAdapter.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(RecycleLabAdapter.OnItemLongClickListener onItemLongClickListener) {
        mOnItemLongClickListener = onItemLongClickListener;
    }

    /**
     * Register a callback to be invoked when childView in this AdapterView has
     * been clicked and held
     * {@link RecycleLabAdapter.OnRecyclerViewItemChildClickListener}
     *
     * @param childClickListener The callback that will run
     */
    public void setOnItemChildClickListener(RecycleLabAdapter.OnRecyclerViewItemChildClickListener childClickListener) {
        this.mChildClickListener = childClickListener;
    }

    public class OnItemChildClickListener implements View.OnClickListener {
        public RecyclerView.ViewHolder mViewHolder;

        @Override
        public void onClick(View v) {
            if (mChildClickListener != null)
                mChildClickListener.onItemChildClick(RecycleLabAdapter.this, v, mViewHolder.getLayoutPosition() - getHeaderViewCount() - 1);
        }
    }

    /**
     * Register a callback to be invoked when childView in this AdapterView has
     * been longClicked and held
     * {@link RecycleLabAdapter.OnRecyclerViewItemChildLongClickListener}
     *
     * @param childLongClickListener The callback that will run
     */
    public void setOnItemChildLongClickListener(RecycleLabAdapter.OnRecyclerViewItemChildLongClickListener childLongClickListener) {
        this.mChildLongClickListener = childLongClickListener;
    }

    public class OnItemChildLongClickListener implements View.OnLongClickListener {
        public RecyclerView.ViewHolder mViewHolder;

        @Override
        public boolean onLongClick(View v) {
            if (mChildLongClickListener != null) {
                return mChildLongClickListener.onItemChildLongClick(RecycleLabAdapter.this, v, mViewHolder.getLayoutPosition() - getHeaderViewCount() - 1);
            }
            return false;
        }
    }


    /**
     * Animation api
     */
    public void setItemAnimation(AnimationType animationType) {
        mAnimationType = animationType;
    }

    public void setItemAnimationDuration(int animationDuration) {
        mAnimationDuration = animationDuration;
    }

    public void setItemAnimationInterpolator(Interpolator animationInterpolator) {
        mItemAnimationInterpolator = animationInterpolator;
    }

    public void setShowItemAnimationEveryTime(boolean showItemAnimationEveryTime) {
        this.showItemAnimationEveryTime = showItemAnimationEveryTime;
    }

    public void setCustomItemAnimator(RecycleLabAdapter.CustomAnimator customAnimator) {
        mCustomAnimator = customAnimator;
    }


    /**
     * Header and footer api
     */
    public LinearLayout getHeaderLayout() {
        return mHeaderLayout;
    }

    public LinearLayout getFooterLayout() {
        return mFooterLayout;
    }

    public void addHeaderView(View header) {
        addHeaderView(header, -1);
    }

    public void addHeaderView(View header, int index) {
        if (mHeaderLayout == null) {
            if (mCopyHeaderLayout == null) {
                mHeaderLayout = new LinearLayout(header.getContext());
                mHeaderLayout.setOrientation(LinearLayout.VERTICAL);
                mHeaderLayout.setLayoutParams(new RecyclerView.LayoutParams(MATCH_PARENT, WRAP_CONTENT));
                mCopyHeaderLayout = mHeaderLayout;
            } else {
                mHeaderLayout = mCopyHeaderLayout;
            }
        }
        index = index >= mHeaderLayout.getChildCount() ? -1 : index;
        mHeaderLayout.addView(header, index);
        this.notifyDataSetChanged();
    }

    public void addFooterView(View footer) {
        addFooterView(footer, -1);
    }

    public void addFooterView(View footer, int index) {
        if (mFooterLayout == null) {
            if (mCopyFooterLayout == null) {
                mFooterLayout = new LinearLayout(footer.getContext());
                mFooterLayout.setOrientation(LinearLayout.VERTICAL);
                mFooterLayout.setLayoutParams(new RecyclerView.LayoutParams(MATCH_PARENT, WRAP_CONTENT));
                mCopyFooterLayout = mFooterLayout;
            } else {
                mFooterLayout = mCopyFooterLayout;
            }
        }
        index = index >= mFooterLayout.getChildCount() ? -1 : index;
        mFooterLayout.addView(footer, index);
        this.notifyDataSetChanged();
    }

    public void removeHeaderView(View header) {
        if (mHeaderLayout == null) return;

        mHeaderLayout.removeView(header);
        if (mHeaderLayout.getChildCount() == 0) {
            mHeaderLayout = null;
        }
        this.notifyDataSetChanged();
    }

    public void removeFooterView(View footer) {
        if (mFooterLayout == null) return;

        mFooterLayout.removeView(footer);
        if (mFooterLayout.getChildCount() == 0) {
            mFooterLayout = null;
        }
        this.notifyDataSetChanged();
    }

    public void removeAllHeaderView() {
        if (mHeaderLayout == null) return;

        mHeaderLayout.removeAllViews();
        mHeaderLayout = null;
    }

    public void removeAllFooterView() {
        if (mFooterLayout == null) return;

        mFooterLayout.removeAllViews();
        mFooterLayout = null;
    }

    public int getHeaderViewCount() {
        return null == mHeaderLayout ? 0 : 1;
    }

    public int getFooterViewCount() {
        return null == mFooterLayout ? 0 : 1;
    }

    /**
     * Some interface
     */
    public interface OnItemClickListener<T> {
        void onItemClick(View view, T item, int position);
    }

    public interface OnItemLongClickListener<T> {
        void onItemLongClick(View view, T item, int position);
    }

    public interface OnRecyclerViewItemChildClickListener {
        void onItemChildClick(RecycleLabAdapter adapter, View view, int position);
    }

    public interface OnRecyclerViewItemChildLongClickListener {
        boolean onItemChildLongClick(RecycleLabAdapter adapter, View view, int position);
    }

    public interface CustomAnimator {
        Animator getAnimator(View itemView);
    }

    /**
     * This is parallax header view wrapper class ,it aim to clip layout height on Y.
     */
    static class CustomRelativeWrapper extends RelativeLayout {

        private int mOffset;
        private boolean mShouldClip;

        public CustomRelativeWrapper(Context context) {
            super(context);
        }

        public CustomRelativeWrapper(Context context, boolean shouldClick) {
            super(context);
            mShouldClip = shouldClick;
        }

        @Override
        protected void dispatchDraw(Canvas canvas) {
            if (mShouldClip) {
                canvas.clipRect(new Rect(getLeft(), getTop(), getRight(), getBottom() + mOffset));
            }
            super.dispatchDraw(canvas);
        }

        public void setClipY(int offset) {
            mOffset = offset;
            invalidate();
        }
    }
}
