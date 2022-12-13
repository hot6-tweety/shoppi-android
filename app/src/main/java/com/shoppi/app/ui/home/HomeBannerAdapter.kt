package com.shoppi.app.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shoppi.app.databinding.ItemHomeBannerBinding
import com.shoppi.app.model.Banner


class HomeBannerAdapter(private val viewModel: HomeViewModel) :
    ListAdapter<Banner, HomeBannerAdapter.HomeBannerViewHolder>(
        BannerDiffCallback()
    ) {
    private lateinit var binding: ItemHomeBannerBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBannerViewHolder {
        binding = ItemHomeBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeBannerViewHolder(binding)
    }

    // HomeBannerViewHolder(binding) 가 잘 전달이 되면 holder 인자를 전달해줌
    override fun onBindViewHolder(holder: HomeBannerViewHolder, position: Int) {
        // 해당 position 에 데이터타입을 반환해줌
        holder.bind(getItem(position))
    }

    inner class HomeBannerViewHolder(private val binding: ItemHomeBannerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        // 바인딩할 데이터 객체
        fun bind(banner: Banner) {
            binding.banner = banner
            binding.viewModel = viewModel
            binding.executePendingBindings()
        }
    }
}

// ListAdapter 에 순차적으로 바인딩할 데이터를 서로 구분하는 기준을 정함
class BannerDiffCallback : DiffUtil.ItemCallback<Banner>() {
    override fun areItemsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem.productDetail.productId == newItem.productDetail.productId
    }

    override fun areContentsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem == newItem
    }

}
