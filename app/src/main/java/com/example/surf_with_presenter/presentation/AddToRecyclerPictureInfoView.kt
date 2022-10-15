package com.example.surf_with_presenter.presentation

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface AddToRecyclerPictureInfoView : MvpView {
    @AddToEndSingle
    fun setPictureInfoOnRecyclerView(list: List<ViewPictureInfo>)
}